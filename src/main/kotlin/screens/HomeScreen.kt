package screens

import org.junit.Assert
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

open class HomeScreen : BaseScreen() {
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"My Account\"]")
    lateinit var profileGrid: WebElement

    fun checkIfUserIsLoggedIn(): HomeScreen {
        wait.until(ExpectedConditions.visibilityOf(profileGrid))
        Assert.assertTrue(profileGrid.isDisplayed)
        return this
    }

}