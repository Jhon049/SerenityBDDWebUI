package co.com.sofka.question.createaccountform;

import co.com.sofka.userinterface.signinpage.SignInPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

public class CreateAccountUnsuccess implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return SignInPage.CREATE_ACCOUNT_ERROR_MESSAGE_VALIDATION.resolveFor(actor).getText().trim().equalsIgnoreCase("Invalid email address.");
    }

    public static CreateAccountUnsuccess createAccountIsUnsuccessful(){
        Scroll.to(SignInPage.CREATE_ACCOUNT_ERROR_MESSAGE_VALIDATION);
        return new CreateAccountUnsuccess();
    }
}
