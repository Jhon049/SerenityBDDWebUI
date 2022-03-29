package co.com.sofka.stepdefinitions;

import co.com.sofka.task.signinpage.FillTheSignInForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import static co.com.sofka.question.createaccountform.CreateAccountSuccess.createAccountIsSuccess;
import static co.com.sofka.question.createaccountform.CreateAccountUnsuccess.createAccountIsUnsuccessful;
import static co.com.sofka.question.signin.SignInIsUnsuccessful.signInIsUnsuccessful;
import static co.com.sofka.task.landingpage.GoToSignIn.goToSignIn;
import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SignInStepDefinitions extends Setup{
    private static final String ACTOR_NAME = "Jhon";

    @Given("ingreso a sign in")
    public void ingresoASignIn(){
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage(),
                goToSignIn());
    }

    @When("diligencio las credenciales")
    public void diligencioLasCredenciales(){
        theActorInTheSpotlight().attemptsTo(
                new FillTheSignInForm()
                        .withEmail("Jhon71@hotmail.com")
                        .andPassword("1234@"));
    }

    @Then("ingreso al perfil del usuario")
    public void ingresoAlPerfilDelUsuario(){
        theActorInTheSpotlight().should(
                seeThat(createAccountIsSuccess(), Matchers.equalTo(true)));
    }

    @Given("ingreso a modulo")
    public void ingresoAModulo(){
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage(),
                goToSignIn());
    }

    @When("diligencio las credenciales incorrectas")
    public void diligencioLasCredencialesIncorrectas(){
        theActorInTheSpotlight().attemptsTo(
                new FillTheSignInForm()
                        .withEmail("Jhon71@gmail.com")
                        .andPassword("1234@"));
    }

    @Then("se valida error en ingreso")
    public void seValidaErrorEnIngreso(){
        theActorInTheSpotlight().should(
                seeThat(signInIsUnsuccessful(), Matchers.equalTo(true)));
    }
}
