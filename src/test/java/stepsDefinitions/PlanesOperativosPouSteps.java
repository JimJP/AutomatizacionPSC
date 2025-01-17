package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageObjects.PlanesOperativosPouPage;
import pageObjects.SelectRolPage;

public class PlanesOperativosPouSteps {

    PlanesOperativosPouPage planesOperativosPouPage = new PlanesOperativosPouPage();
    private String rolActual;

    @Given("El usuario ingresa con el {string}")
    public void elUsuarioIngresaConElRol(String rol){
        rolActual = rol;
        By locatorRol;

        switch (rol) {
            case "Operador de Planeamiento UO":
                locatorRol = By.xpath("//div[@class='dx-item-content dx-list-item-content'][contains(.,'OPERADOR DE PLANEAMIENTO UO')]");
                break;
            case "Supervisor UO":
                locatorRol = By.xpath("//div[@class='dx-item-content dx-list-item-content' and text()='SUPERVISOR UO']");
                break;
            case "Responsable UO":
                locatorRol = By.xpath("//div[@class='dx-item-content dx-list-item-content'][contains(.,'RESPONSABLE UO')]");
                break;
            case "Responsable de la Gerencia":
                locatorRol = By.xpath("//div[@class='dx-item-content dx-list-item-content'][contains(.,'RESPONSABLE DE LA GERENCIA')]");
                break;
            case "Supervisor OI Superior":
                locatorRol = By.xpath("//div[@class='dx-item-content dx-list-item-content'][contains(.,'SUPERVISOR O.I.SUPERIOR')]");
                break;
            case "Responsable OI Superior":
                locatorRol = By.xpath("//div[@class='dx-item-content dx-list-item-content'][contains(.,'RESPONSABLE O.I.SUPERIOR')]");
                break;
            case "Usuario de Planeamiento":
                locatorRol = By.xpath("//div[@class='dx-item-content dx-list-item-content'][contains(.,'USUARIO DE PLANEAMIENTO')]");
                break;
            case "Supervisor PLPREPI":
                locatorRol = By.xpath("//div[@class='dx-item-content dx-list-item-content'][contains(.,'SUPERVISOR PLPREPI')]");
                break;

            default:
                throw new IllegalArgumentException("Rol no reconocido: " + rol);
        }
        planesOperativosPouPage.elUsuarioIngresaConElRol(locatorRol);
    }

    @Then("Se muestra la interfaz de PSC Sisco")
    public void seMuestraLaInterfazDePscSisco (){
        planesOperativosPouPage.seMuestraLaInterfazDePscSisco();
    }

    @And("Selecciono el menu Planes Operativos POU")
    public void seleccionoElMenuPlanesOperativosPou(){
        planesOperativosPouPage.seleccionoElMenuPlanesOperativosPou();
    }

    @When("Selecciono el {string} y {string} del Plan Operativo")
    public void seleccionoElAmbitoYAnioDelPlanOperativo(String ambito, String anio) throws InterruptedException {


        System.out.println("Valor de rolActual antes del if: " + rolActual);
        if ("Responsable UO".equals(rolActual.trim())) {
            System.out.println("Entra al bloque if para 'Responsable UO'");
            planesOperativosPouPage.seleccionarUoYPeriodoResponsableUo(ambito, anio);
        } else if ("Usuario de Planeamiento".equals(rolActual.trim())){
                planesOperativosPouPage.seleccionarUoYPeriodoUsuarioPlaneamiento(ambito, anio);
        } else if ("Supervisor PLPREPI".equals(rolActual.trim())){
            planesOperativosPouPage.seleccionarUoYPeriodoSupervisorPlprepi(ambito, anio);
        }
        else {
            planesOperativosPouPage.seleccionoElAmbitoYAnioDelPlanOperativo(ambito, anio);
        }
    }

    @And("Deriva el Plan Operativo")
    public void derivaElPlanOperativo() throws InterruptedException {
        if ("Responsable UO".equals(rolActual.trim())) {
            planesOperativosPouPage.derivarElPlanOperativoRolResponsableUo();
        } else if ("Usuario de Planeamiento".equals(rolActual.trim())) {
                planesOperativosPouPage.derivarElPlanOperativoRolUsuarioPlaneamiento();
        } else if ("Supervisor PLPREPI".equals(rolActual.trim())){
            //planesOperativosPouPage.aprobarElPlanOperativoRolSupervisorPlprepi();
        }
        else {
            planesOperativosPouPage.derivaElPlanOperativo();
        }
    }

    @Then("Muestra mensaje de exito plan derivado")
    public void muestraMensajeDeExitoPlanDerivado (){
        planesOperativosPouPage.muestraMensajeDeExitoPlanDerivado();
    }

}
