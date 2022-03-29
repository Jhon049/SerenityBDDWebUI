package co.com.sofka.userinterface.signinpage;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignInPage extends PageObject {

    public static final Target EMAIL_CREATE_FIELD = Target
            .the("Email create field")
            .located(By.id("email_create"));

    public static final Target CREATE_AN_ACCOUNT_BTN = Target
            .the("Create an account button")
            .located(By.id("SubmitCreate"));

    public static final Target EMAIL_SIGNIN_FIELD = Target
            .the("Email Sign in field")
            .located(By.id("email"));
    public static final Target PASSWORD_FIELD = Target
            .the("Password field")
            .located(By.id("passwd"));
    public static final Target SIGNIN_BTN = Target
            .the("Sign in button")
            .located(By.cssSelector("#SubmitLogin > span"));

    public static final Target CREATE_ACCOUNT_ERROR_MESSAGE_VALIDATION = Target
            .the("Create account Error message")
            .located(By.id("create_account_error"));

    public static final Target SIGNIN_ERROR_MESSAGE = Target
            .the("Sign In Error message")
            .located(By.xpath("//*[@id=\"center_column\"]/div[1]/p"));
}
