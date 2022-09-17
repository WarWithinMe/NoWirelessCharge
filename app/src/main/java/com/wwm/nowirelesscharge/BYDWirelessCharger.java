package com.wwm.nowirelesscharge;

import android.content.Context;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BYDWirelessCharger {
    static public void turnOn(Context context)  { toggle(1, context); }
    static public void turnOff(Context context) { toggle(2, context); }

    static private void toggle(int state, Context context) {
        try {
            // Allow accessing hidden api
            Method forName                = Class.class.getDeclaredMethod("forName", String.class);
            Method getDeclaredMethod      = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class  vmRuntimeClass         = (Class) forName.invoke(null, "dalvik.system.VMRuntime");
            Method getRuntime             = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "getRuntime", null);
            Object vmRuntime              = getRuntime.invoke(null);
            Method setHiddenApiExemptions = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "setHiddenApiExemptions", new Class[] {String[].class});
            setHiddenApiExemptions.invoke(vmRuntime, new String[][]{new String[]{"L"}});

            // Use reflection to get BYD framework classes.
            Class  deviceClass = Class.forName("android.hardware.bydauto.charging.BYDAutoChargingDevice");
            Method getInstance = deviceClass.getMethod("getInstance", Context.class);
            Object device      = getInstance.invoke(null, context);

            Method getDeviceTypeMethod = deviceClass.getMethod("getDevicetype");
            int    mDeviceType         = (int) getDeviceTypeMethod.invoke(device);

            Class featureIdsClass        = Class.forName("android.hardware.bydauto.BYDAutoFeatureIds");
            Field chargingSwitchSetField = featureIdsClass.getDeclaredField("CHARGING_CHARGE_WIRELESS_CHARGING_SWITCH_SET");
            int   chargingSwitchSet      = (int) chargingSwitchSetField.get(null);

            Class  absAutoClass = Class.forName("android.hardware.bydauto.AbsBYDAutoDevice");
            Method setMethod    = absAutoClass.getDeclaredMethod("set", int.class, int.class, int.class);
            setMethod.setAccessible(true);
            setMethod.invoke(device, mDeviceType, chargingSwitchSet, state);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
