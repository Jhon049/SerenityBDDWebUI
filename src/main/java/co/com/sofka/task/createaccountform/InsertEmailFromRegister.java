package co.com.sofka.task.createaccountform;

import co.com.sofka.task.contactus.FillContactUs;
import co.com.sofka.userinterface.contactus.ContactUsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import co.com.sofka.userinterface.createaccountform.*;

import static co.com.sofka.userinterface.createaccountform.CreateAccountFormPage.*;
import static co.com.sofka.userinterface.signinpage.SignInPage.EMAIL_CREATE_FIELD;

public class InsertEmailFromRegister implements Task {

    private String emailRegister;

    public  InsertEmailFromRegister usingEmail(String emailRegister) {
        this.emailRegister = emailRegister;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(EMAIL_CREATE_FIELD),
                Click.on(EMAIL_CREATE_FIELD),
                Enter.theValue(emailRegister).into(EMAIL_CREATE_FIELD),

                Scroll.to(),
                Click.on(ContactUsPage.SUBMIT)

        );
    }
    public static InsertEmailFromRegister InsertEmailFromRegister(){
        return new InsertEmailFromRegister();
    }
}
