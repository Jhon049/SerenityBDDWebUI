package co.com.sofka.question.signin;

import co.com.sofka.userinterface.createaccountform.CreateAccountFormPage;
import co.com.sofka.userinterface.signinpage.SignInPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SignInIsUnsuccessful implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return SignInPage.SIGNIN_ERROR_MESSAGE.resolveFor(actor).getText().trim().equalsIgnoreCase("There is 1 error");
    }

    public static SignInIsUnsuccessful signInIsUnsuccessful() {
        return new SignInIsUnsuccessful();
    }
}
