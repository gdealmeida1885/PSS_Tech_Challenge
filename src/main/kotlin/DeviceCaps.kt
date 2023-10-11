interface DeviceCaps {
    companion object {
        val path: String = System.getProperty("user.dir")
        val platformName: String = "Android"
        val deviceName: String  = "23a1026825057ece"
        val automationName: String = "UiAutomator2"
        val app: String = "$path/src/main/resources/scruff_app.apk"
        val permissions: Boolean = true
    }
}