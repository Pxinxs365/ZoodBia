import platform.Foundation.NSProcessInfo

actual fun isDebug() = NSProcessInfo.processInfo.environment["DEBUG"] == "true"
