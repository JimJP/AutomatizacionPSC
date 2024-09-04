package stepsDefinitions.loginSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;
import pageObjects.LoginPage;
import pageObjects.SelectRolPage;
import utils.Constants_Variables;

public class LoginSteps extends BasePage {

    public LoginSteps() {
        super(driver);
    }

    LoginPage loginPage = new LoginPage();
    SelectRolPage selectRolPage = new SelectRolPage();

    @Given("El usuario inicia sesión")
    public void iniciarSesion(){
        navigateToUrl(Constants_Variables.URL_DEV);
        loginPage.elUsuarioIniciaSesion();
    }

    @Then("Se muestra la interfaz de SISCO")
    public void verificarInicioSesion(){
        loginPage.seMuestraLaInterfazDeSisco();
    }

    @And("Ingreso al modulo SISCO")
    public void ingresarSisco(){
        selectRolPage.ingresoAlModuloSisco();
    }

    @Then("Se muestra la interfaz de Roles")
    public void verificarIngresoSisco(){
        selectRolPage.seMuestraLaInterfazDeRoles();
    }

    @And("Selecciono el Rol Operador de Planeamiento Oci")
    public void seleccionarRol() throws InterruptedException {
        selectRolPage.seleccionoElRolOperadorDePlaneamientoOci();
    }

    @Then("Se muestra la interfaz de PSC")
    public void verificarIngresoPsc(){
        selectRolPage.seMuestraLaInterfazDePsc();
    }

}