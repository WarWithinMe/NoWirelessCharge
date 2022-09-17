# 关于本 App
安装了这个 App，会在 BYD DiLink 4.0 系统启动时，或者手动打开本 App 时，关闭无线充电功能，然后立即结束程序。本质上这个 App 做的事情和系统状态栏上的快捷方式无异。

# Why
有些人可能会观察到出厂设置下，无线充电功在关闭状态，然后关闭车机立刻再开机，此时无线充电功能仍处于关闭状态。但其实车机关闭一段时间后再打开，无线充电会自动打开。猜测大概率是因为刚关闭车机立刻打开，可能仍存在电容给电路供电，从而让无线充电功能状态没有丢失。从反编译 framework.jar / SystemUIWithLegacyRecents.apk 来看 DiLink 4.0 应该是没有记忆此状态的功能。

# 使用方式
1. 在 Release 页面下载 APK，并安装到车机上。
2. 安装完成后，运行一次 app。（拉下状态栏会发现无线充电功能已关闭。）
3. 在系统设置 -> DiLink -> 应用管理 -> 禁止自启动中，取消勾选允许本 App（NoWirelessCharge）的选项，从而允许其自启动。
4. 验证 App 是否生效：手动打开无线充电功能，然后关闭车机。再次打开车机之后，无线充电功能应该处于关闭状态。

# 免责声明
1. 本人不对本 App 负任何责任，请有需要的人慎重考虑。
2. DiLink 3.0 系统估计也能用，但不确定。如果不能用，需要提取 `framework.jar` 和 `SystemUIWithLegacyRecents.apk` 反编译之后具体看看关闭无线充电功能的代码是如何。
