package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CapacidadOperativaPage;

public class CapacidadOperativaSteps {

    CapacidadOperativaPage capacidadOperativaPage = new CapacidadOperativaPage();

    /*--- CP001 ---*/

    @Given("El usuario de OCI ingresa a Capacidad Operativa")
    public void elUsuarioDeOciIngresaACapacidadOperativa(){
        capacidadOperativaPage.elUsuarioDeOciIngresaACapacidadOperativa();
    }

    @When("Selecciono el ambito")
    public void seleccionoElAmbito() throws InterruptedException {
        capacidadOperativaPage.seleccinoElAmbito();
    }

    @And("Doy clic en Agregar Personal")
    public void doyClicEnAgregarPersonal(){
        capacidadOperativaPage.doyClicEnAgregarPersonal();
    }

    @And("Doy clic en Buscar y agregar {string}")
    public void doyClicEnBuscarYAgregar(String nroDocumento){
        capacidadOperativaPage.doyClicEnBuscarYAgregar(nroDocumento);
    }

    @And("Selecciono el Personal buscado y lo agrego")
    public void seleccionoElPersonalBuscadoYLoAgrego() throws InterruptedException {
        capacidadOperativaPage.seleccionoElPersonalBuscadoYLoAgrego();
    }

    @And("Doy clic al botón Guardar Capacidad Operativa")
    public void doyClicAlBotonGuardarCapacidadOperativa(){
        capacidadOperativaPage.doyClicAlBotonGuardarCapacidadOperativa();
    }

    @Then("Se muestra el mensaje de validacion y se impide la grabación")
    public void seMuestraElMensajeDeValidacionYSeImpideLaGrabacion(){
        capacidadOperativaPage.seMuestraElMensajeDeValidacionYSeImpideLaGrabacion();
    }

    /*--- CP002 ---*/

    @Then("Se muestra el mensaje Ingrese número DNI valido")
    public void seMuestraElMensajeIngreseNumeroDniValido(){
        capacidadOperativaPage.seMuestraElMensajeIngreseNumeroDniValido();
    }
}
