import data.UserData
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.junit.jupiter.api.*
import screens.HomeScreen
import screens.LoginScreen

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class LoginTest {
    var driver: AppiumDriver<MobileElement>? = null

    @BeforeEach
    fun testSetup() {
        driver = Capabilities.driverSetup()
    }

    @AfterEach
    fun testTearDown(){
        Capabilities.driverTearDown()
    }

    @Test
    @Order(1)
    fun userShouldLoginSuccessfully() {
        LoginScreen()
            .login(UserData().email, UserData().password)

        HomeScreen().checkIfUserIsLoggedIn()
    }

    @Test
    @Order(2)
    fun userShouldNotLoginWithInvalidPassword() {
        LoginScreen()
            .login(UserData().email, UserData().invalidPassword)
            .checkIfWrongPasswordAlertIsVisible()
            .checkWrongPasswordMessage("If you cannot remember your password, please tap Forgot Password.")

    }

    @Test
    @Order(3)
    fun userShouldNotLoginWithInvalidEmail() {
        LoginScreen()
            .login(UserData().invalidEmail, UserData().password)
            .checkIfInvalidEmailAlertIsVisible()
            .checkInvalidEmailMessage("A profile with that email was not found.")

    }

}