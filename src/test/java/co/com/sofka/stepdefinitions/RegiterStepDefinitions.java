package co.com.sofka.stepdefinitions;

import co.com.sofka.task.signinpage.GoToCreateAccountForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import static co.com.sofka.question.createaccountform.CreateAccountSuccess.createAccountIsSuccess;
import static co.com.sofka.question.createaccountform.CreateAccountUnsuccess.createAccountIsUnsuccessful;
import static co.com.sofka.task.createaccountform.FillCreateAccountForm.fillCreateAccountForm;
import static co.com.sofka.task.landingpage.GoToSignIn.goToSignIn;
import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static java.lang.Math.random;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegiterStepDefinitions extends Setup{

    private static final String ACTOR_NAME = "Jhon";


    @Given("me encuentro en el modulo sign in")
    public void meEncuentroEnElModuloSignIn (){
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage(),
                goToSignIn());
    }

    @When("diligencio el correo a registrar")
    public void diligencioElCorreoARegistrar() {
        theActorInTheSpotlight().attemptsTo(
                new GoToCreateAccountForm()
                        .withCreateEmail(ACTOR_NAME+(int)(random()*1000)+"@hotmail.com")
        );
    }

    @When ("diligencio el formulario de registro")
    public void diligencioElFormularioDeRegistro(){

        theActorInTheSpotlight().attemptsTo(
                fillCreateAccountForm()
                       .withFirstName("sofka")
                        .withLastName("land")
                        .withPassword("1234@")
                        .withAddress("casa sofka")
                        .withCity("Medellin")
                        .withState("Alabama")
                        .withZipCode("05001")
                        .withCountry("United States")
                        .withMobilePhone("31524815")
        );

    }

    @Then("se valida la creacion de la cuenta")
    public void seValidaLaCreacionDeLaCuenta(){
        theActorInTheSpotlight().should(
                seeThat(createAccountIsSuccess(), Matchers.equalTo(true)));
    }


    @Given ("ingreso al modulo sign in")
    public void ingresoAlModuloSignIn (){
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage(),
                goToSignIn());
    }

    @When ("dejo el correo en blanco")
    public void dejoElCorreoEnBlanco (){
        theActorInTheSpotlight().attemptsTo(
                new GoToCreateAccountForm()
                        .withCreateEmail("")
        );
    }

    @Then ("se valida el error generado")
    public void seValidaElErrorGenerado (){
        theActorInTheSpotlight().should(
                seeThat(createAccountIsUnsuccessful(), Matchers.equalTo(true)));
    }



}
