package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AsignacionServiciosActividadesPage;

public class AsignacionServiciosActividadesSteps {

    AsignacionServiciosActividadesPage asignacionServiciosActividadesPage = new AsignacionServiciosActividadesPage();

    @Given("El usuario de planeamiento ingresa a Asignacion de Servicios")
    public void elUsuarioDePlaneamientoIngresaAAsignacionDeServicios(){
        asignacionServiciosActividadesPage.elUsuarioDePlaneamientoIngresaAAsignacionDeServicios();
    }

    @And("Hago clic en la opción \"Editar\" del periodo 2024")
    public void hagoClicEnLaOpciónEditarDelPeriodo2024() throws InterruptedException {
        asignacionServiciosActividadesPage.hagoClicEnLaOpcionEditarDelPeriodo2024();
    }

    @Then("Se muestra el listado de asignaciones de UO y OCI")
    public void seMuestraElListadoDeAsignacionesDeUoOci(){
        asignacionServiciosActividadesPage.seMuestraElListadoDeAsignacionesDeUoOci();
    }

    @And("Hago clic en \"Acciones\" y luego en \"Agregar Asignación\"")
    public void hagoClicEnAccionesYLuegoEnAgregarAsignacion(){
        asignacionServiciosActividadesPage.hagoClicEnAccionesYLuegoEnAgregarAsignacion();
    }

    @Then("Se muestra la interfaz \"Agregar Asignación de Actividades\"")
    public void seMuestraLaInterfazAgregarAsignacionDeActividades(){
        asignacionServiciosActividadesPage.seMuestraLaInterfazAgregarAsignacionDeActividades();
    }

    @And("Busco y agrego la UO de forma manual {string}")
    public void buscoYAgregoLaUoDeFormaManual(String codigoUO) throws InterruptedException {
        asignacionServiciosActividadesPage.buscoYAgregoLaUoDeFormaManual(codigoUO);
    }

    @And("Hago clic en el botón \"Buscar\"")
    public void hagoClicEnElBotonBuscarYSeleccionoActividades(){
        asignacionServiciosActividadesPage.hagoClicEnElBotonBuscar();
    }

    @When("Selecciono un catálogo PNC y un grupo de actividades")
    public void seleccionoUnCatalogoPncYUnGrupoDeActividades() throws InterruptedException {
        asignacionServiciosActividadesPage.seleccionoUnCatalogoPncYUnGrupoDeActividades();
    }

    @And("Hago clic en el botón \"Buscar\" del modal")
    public void hagoClicEnElBotonBuscarDelModal(){
        asignacionServiciosActividadesPage.hagoClicEnElBotonBuscarDelModal();
    }

    @And("Agrego todos los servicios y actividades")
    public void agregoTodosLosServiciosYActividades() {
        asignacionServiciosActividadesPage.agregoTodosLosServiciosYActividades();
    }

    @Then("Se muestran todas las actividades agregadas a la UO")
    public void seMuestranTodasLasActividadesAgregadasALaU() {
        asignacionServiciosActividadesPage.seMuestranTodasLasActividadesAgregadasALaU();
    }

    @And("Agrego la Unidad de Medida y Producto a las actividades")
    public void agregoLaUnidadDeMedidaYProductoALasActividades() throws InterruptedException {
        asignacionServiciosActividadesPage.agregoLaUnidadDeMedidaYProductoALasActividades();
    }

    @And("Hago clic en el botón \"Guardar\"")
    public void hagoClicEnElBotonGuardar(){
        asignacionServiciosActividadesPage.hagoClicEnElBotonGuardar();
    }

    @Then("Se muestra un mensaje de éxito")
    public void seMuestraUnMensajeDeExito(){
        asignacionServiciosActividadesPage.seMuestraUnMensajeDeExito();
    }
}
