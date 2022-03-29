package co.com.sofka.question.createaccountform;

import co.com.sofka.userinterface.createaccountform.CreateAccountFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CreateAccountSuccess implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return CreateAccountFormPage.ACCOUNT_LINK.resolveFor(actor).getText().trim().equalsIgnoreCase("MY ACCOUNT");
    }

    public static CreateAccountSuccess createAccountIsSuccess(){
        return new CreateAccountSuccess();
    }
}
