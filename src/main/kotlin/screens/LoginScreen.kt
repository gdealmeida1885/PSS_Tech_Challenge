package screens

import org.junit.Assert
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

open class LoginScreen : BaseScreen() {
    @FindBy(id = "com.appspot.scruffapp:id/email_edit_text")
    lateinit var userEmailInput: WebElement
    @FindBy(id = "com.appspot.scruffapp:id/password_edit_text")
    lateinit var userPasswordInput: WebElement
    @FindBy(id = "com.appspot.scruffapp:id/login_button")
    lateinit var loginButton: WebElement
    @FindBy(id = "com.appspot.scruffapp:id/md_text_title")
    lateinit var wrongPasswordAlert: WebElement
    @FindBy(id = "com.appspot.scruffapp:id/md_text_message")
    lateinit var wrongPasswordMessage: WebElement
    @FindBy(id = "com.appspot.scruffapp:id/md_text_title")
    lateinit var invalidEmailAlert: WebElement
    @FindBy(id = "com.appspot.scruffapp:id/md_text_message")
    lateinit var invalidEmailMessage: WebElement

    private fun fillUserEmail(email: String): LoginScreen {
        tapElement(userEmailInput)
        sendKeys(userEmailInput, email)
        return this
    }

    private fun fillUserPassword(password: String): LoginScreen {
        sendKeys(userPasswordInput, password)
        return this
    }

    private fun tapLoginButton() {
        tapElement(loginButton)
    }

    fun login(email: String, password: String): LoginScreen {
        fillUserEmail(email)
        fillUserPassword(password)
        tapLoginButton()
        return this
    }

    fun checkIfWrongPasswordAlertIsVisible(): LoginScreen {
        wait.until(ExpectedConditions.visibilityOf(wrongPasswordMessage))
        Assert.assertTrue(wrongPasswordAlert.isDisplayed)
        return this
    }

    fun checkWrongPasswordMessage(message: String): LoginScreen {
        wait.until(ExpectedConditions.visibilityOf(wrongPasswordMessage))
        Assert.assertEquals(wrongPasswordMessage.text, message)
        return this
    }

    fun checkIfInvalidEmailAlertIsVisible(): LoginScreen {
        wait.until(ExpectedConditions.visibilityOf(invalidEmailAlert))
        Assert.assertTrue(invalidEmailAlert.isDisplayed)
        return this
    }

    fun checkInvalidEmailMessage(message: String): LoginScreen {
        wait.until(ExpectedConditions.visibilityOf(invalidEmailMessage))
        Assert.assertEquals(invalidEmailMessage.text, message)
        return this
    }

}