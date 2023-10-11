
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

open class Capabilities : DeviceCaps {

    companion object {
        var driver: AppiumDriver<MobileElement>? = Capabilities.driverSetup()

        fun driverSetup(): AppiumDriver<MobileElement>? {
            if (driver == null) {
                createDriver()
            }
            return driver
        }

        private fun setCapabilities(): DesiredCapabilities {
            val desiredCapabilities = DesiredCapabilities()
            desiredCapabilities.setCapability("platformName", DeviceCaps.platformName)
            desiredCapabilities.setCapability("deviceName", DeviceCaps.deviceName)
            desiredCapabilities.setCapability("automationName", DeviceCaps.automationName)
            desiredCapabilities.setCapability("app", DeviceCaps.app)
            desiredCapabilities.setCapability("autoGrantPermissions", DeviceCaps.permissions)
            return desiredCapabilities
        }

        private fun createDriver() {
            driver = AppiumDriver(URL("http://127.0.0.1:4723/"), setCapabilities())
        }

        fun driverTearDown() {
            if (driver != null) {
                driver!!.quit()
                driver = null
            }
        }
    }
}