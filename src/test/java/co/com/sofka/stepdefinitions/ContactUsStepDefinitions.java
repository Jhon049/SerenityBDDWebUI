package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import static co.com.sofka.question.contactus.ContactUs.contactUs;
import static co.com.sofka.question.contactus.ContactUsFailed.contactUsFailed;
import static co.com.sofka.task.contactus.FillContactUs.fillContactUs;
import static co.com.sofka.task.landingpage.GoToContactUs.goToContactUs;
import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static java.lang.Math.random;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ContactUsStepDefinitions extends Setup {

    private static final String ACTOR_NAME = "Jhon";

    @Given("me encuentro en el modulo de contact us")
    public void meEncuentroEnElModuloDeContactUs (){
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage(),
                goToContactUs());
    }

    @When("diligencio el formulario")
    public void diligencioElFormulario (){
        theActorInTheSpotlight().attemptsTo(
                fillContactUs()
                        .usingEmail(ACTOR_NAME+(int)(random()*1000)+"@hotmail.com")
                        .choosingSubject()
                        .AndWithTheMessage("Enviando prueba")
        );
    }

    @Then("se confirma el envio")
    public void seConfirmaElEnvio(){
        theActorInTheSpotlight().should(
                seeThat(contactUs(), Matchers.equalTo(true)));
    }

    @Given ("ingreso al modulo de contact us")
    public void ingresoAlModuloDeContactUs (){
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage(),
                goToContactUs());
    }

    @When("diligencio el formulario sin correo")
    public void diligencioElFormularioSinCorreo (){
        theActorInTheSpotlight().attemptsTo(
                fillContactUs()
                        .choosingSubject()
                        .usingEmail("")
                        .AndWithTheMessage("Enviando prueba")
        );
    }

    @Then("se valida el error por el correo")
    public void seValidaElErrorPorElCorreo (){
        theActorInTheSpotlight().should(
                seeThat(contactUsFailed(), Matchers.equalTo(true)));
    }
}
