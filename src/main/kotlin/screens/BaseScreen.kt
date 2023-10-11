package screens

import Capabilities
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import utils.Timeouts

open class BaseScreen : Capabilities() {
    private val driver: AppiumDriver<MobileElement>? = driverSetup()
    var wait = WebDriverWait(driver, Timeouts.MEDIUM.waitTime)

    fun tapElement(element: WebElement) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click()
    }

    fun sendKeys(element: WebElement, string: String) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(string)
    }

    init {
       PageFactory.initElements(driver, this)
    }
}