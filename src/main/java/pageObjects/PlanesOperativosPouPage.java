package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.File;

public class PlanesOperativosPouPage extends BasePage {

    /*--- LOCALIZADORES DE SELECCIÓN DE ROL ---*/
    private final By divComBoxRol = By.cssSelector(".dx-overlay-wrapper.dx-loadpanel-wrapper.dx-overlay-shader");
    private final By rolesComboBox = By.xpath("//div[contains(@class,'dx-dropdowneditor-input-wrapper dx-selectbox-container')]");
    private final By cargaPaginaRolOverlay = By.xpath("//div[contains(@class,'dx-loadpanel-content-wrapper')]");
    private final By pscButton = By.xpath("//img[contains(@src,'PSC')]");
    private final By welcomeModuloPscLabel = By.xpath("//img[@class='img-icon']");


    /*--- LOCALIZADORES DEL PAGE DE PLANES POU ---*/
    private final By menuPlanesOperativosPou = By.xpath("//div[@class='menu-item-title'][contains(.,'Planes operativos UO(POU)')]");
    private final By validarIngresoPlanesOperativosPou = By.xpath("//b[@class='cgr-list-subtitle'][contains(.,'Planes Operativos Anuales de UO')]");
    private final By listadoAmbitos = By.xpath("//dx-drop-down-box[@placeholder='Seleccione'][contains(.,'Ambito UO')]");
    private final By escribirCodAmbito = By.xpath("(//input[contains(@autocomplete,'off')])[5]");
    private final By loadingPanel = By.className("dx-loadpanel");
    private final By listadoAnio = By.xpath("//dx-drop-down-box[@placeholder='Seleccione'][contains(.,'Año')]");
    private final By botonBuscarPlanes = By.xpath("//div[@class='dx-button-content'][contains(.,'Buscar')]");
    private final By listadoAcciones = By.xpath("//dx-select-box[contains(@dropdownbuttontemplate,'dropDownButtonTemplate')]");
    private final By accionDerivar = By.xpath("//div[@class='custom-select-item dx-template-wrapper dx-item-content dx-list-item-content'][contains(.,'Derivar')]");
    private final By validarModalDerivarPlan = By.xpath("//div[@class='section-caption'][contains(.,'El Plan será derivado ¿Desea continuar?')]");
    private final By botonAceptarModalDerivarPlan = By.xpath("//div[@class='dx-button-content'][contains(.,'Aceptar')]");
    private final By mensajeExitosoPlanDerivado = By.xpath("//p[contains(.,'El registro se realizó correctamente')]");

    /*--- LOCALIZADORES ROL "RESPONSABLE UO" ---*/
    private final By listadoUo = By.xpath("//dx-drop-down-box[@placeholder='Seleccione'][contains(.,'UO')]");
    private final By escribirCodUo = By.xpath("//dx-text-box[contains(@placeholder,'Buscar...')]");
    private final By listadoPeriodo = By.xpath("//dx-drop-down-box[@placeholder='Seleccione'][contains(.,'Periodo')]");
    private final By seleccionarPlanCheckbox = By.xpath("//div[contains(@aria-label,'Seleccionar fila')]");

    /*--- LOCALIZADORES ROL "SUPERVISOR PLPREPI ---*/
    private final By accionAprobar = By.xpath("//div[@class='dx-item dx-list-item'][contains(.,'Aprobar')]");
    private final By validarModalAprobarPlan = By.xpath("//div[@class='caption cgr-form-subtitle'][contains(.,'Aprobar plan')]");
    private final By resolucionTextBox = By.name("resolucionDesc");
    private final By dropTargetPdf = By.xpath("//div[@class='dx-fileuploader-input-wrapper'][contains(.,'Adjuntar...Arrastre aqui.')]");
    private final By botonAdjuntarResol = By.xpath("//div[@class='dx-button-content'][contains(.,'Adjuntar...')]");
    private final By botonAceptarAdjuntarResol = By.xpath("//div[@class='dx-button-content'][contains(.,'Aceptar')]");
    private final By botonAprobarPlan = By.xpath("//div[@class='dx-button-content'][contains(.,'Aprobar')]");
    private final By confirmarAprobarPlan = By.xpath("//div[@class='dx-button-content'][contains(.,'Si')]");
    private final By mensajeExitosoAprobacionPlan = By.xpath("//p[contains(.,'El registro se realizó correctamente')]");

    /*--- LOCALIZADORES DINAMICOS ---*/

    private By resultadoAmbito(String ambito) {
        return By.xpath("//span[contains(text(), '" + ambito + "')]");
    }

    private By resultadoNroAnio(String anio) {
        return By.xpath("//span[contains(text(), '" + anio + "')]");
    }

    public PlanesOperativosPouPage() {
        super(driver);
    }

    public void elUsuarioIngresaConElRol(By locatorRol) {
        waitForWebElementInvisibilityOfElementLocated(divComBoxRol);
        click(rolesComboBox);
        waitForWebElementPresenceOfElementLocated(locatorRol);
        mouseDown(locatorRol);
        click(locatorRol);
        waitForWebElementVisibilityOfElementLocated(pscButton);
        waitForWebElementInvisibilityOfElementLocated(cargaPaginaRolOverlay);
        click(pscButton);
        //Se muestra la interfaz de PSC
        waitForWebElementVisibilityOfElementLocated(welcomeModuloPscLabel);
        assertTrueGetClassAttributeForClass("img-icon", welcomeModuloPscLabel);
    }

    public void seMuestraLaInterfazDePscSisco() {
        waitForWebElementVisibilityOfElementLocated(welcomeModuloPscLabel);
        assertTrueGetClassAttributeForClass("img-icon", welcomeModuloPscLabel);
    }

    public void seleccionoElMenuPlanesOperativosPou() {
        waitForWebElementClickable(menuPlanesOperativosPou);
        click(menuPlanesOperativosPou);
        waitForWebElementVisibilityOfElementLocated(validarIngresoPlanesOperativosPou);
    }

    public void seleccionoElAmbitoYAnioDelPlanOperativo(String ambito, String anio) throws InterruptedException {
        waitForWebElementClickable(listadoAmbitos);
        click(listadoAmbitos);
        click(escribirCodAmbito);
        typeText(escribirCodAmbito, ambito);
        // Esperar a que el elemento que contiene el código de Ambito esté visible para hacer clic
        WebElement resultadoAmbito = waitForTextInWebElementVisibilityOfElementLocated(resultadoAmbito(ambito), ambito);
        resultadoAmbito.click();

        waitForWebElementInvisibilityOfElementLocated(loadingPanel);
        waitForWebElementPresenceOfElementLocated(listadoAnio);
        waitForWebElementClickable(listadoAnio);
        click(listadoAnio);
        //click(escribirNroAnio);
        //typeText(escribirNroAnio, anio);
        // Esperar a que el elemento que contiene el nro de Año esté visible para hacer clic
        WebElement resultadoAnio = waitForTextInWebElementVisibilityOfElementLocated(resultadoNroAnio(anio), anio);
        resultadoAnio.click();

        waitForWebElementClickable(botonBuscarPlanes);
        click(botonBuscarPlanes);
    }

    public void derivaElPlanOperativo() throws InterruptedException {
        // Se localiza el valor dinámico y la XPath para mi metodo getElementAndValueDinamic
        String valorAnioPlanOperativo = "02/02/2024";
        String xpathPlanOperativo = String.format("//tr[td[text()='%s']]", valorAnioPlanOperativo); // String.format(): Utiliza este método para reemplazar %s en el XPath con el valor de valorAnioPlanOperativo
        waitForWebElementPresenceOfElementLocated(By.xpath(xpathPlanOperativo)); // By.xpath() crea un objeto By con el XPath dinámico
        WebElement listadoPlanesOperativos = getElementAndValueDinamic(xpathPlanOperativo, valorAnioPlanOperativo);
        clickJavaScript(listadoPlanesOperativos);

        click(listadoAcciones);
        click(accionDerivar);
        waitForWebElementVisibilityOfElementLocated(validarModalDerivarPlan);
        click(botonAceptarModalDerivarPlan);
    }

    public void muestraMensajeDeExitoPlanDerivado() {
        waitForWebElementVisibilityOfElementLocated(mensajeExitosoPlanDerivado);
    }

    public void seleccionarUoYPeriodoResponsableUo(String ambito, String anio) throws InterruptedException {
        System.out.println("Enrta al metodo seleccionarUoYPeriodoResponsableUo");
        waitForWebElementPresenceOfElementLocated(listadoUo);
        System.out.println("intenta localizar primer elemento");
        //waitForWebElementClickable(listadoUo);
        click(listadoUo);
        click(escribirCodUo);
        Thread.sleep(1000);
        typeText(escribirCodUo, ambito);
        // Esperar a que el elemento que contiene el código de Ambito esté visible para hacer clic
        WebElement resultadoAmbito = waitForTextInWebElementVisibilityOfElementLocated(resultadoAmbito(ambito), ambito);
        resultadoAmbito.click();

        //waitForWebElementInvisibilityOfElementLocated(loadingPanel);
        //waitForWebElementPresenceOfElementLocated(listadoPeriodo);
        Thread.sleep(1000);
        waitForWebElementClickable(listadoPeriodo);
        click(listadoPeriodo);
        // Esperar a que el elemento que contiene el nro de Año esté visible para hacer clic
        WebElement resultadoPeriodo = waitForTextInWebElementVisibilityOfElementLocated(resultadoNroAnio(anio), anio);
        resultadoPeriodo.click();

        waitForWebElementClickable(botonBuscarPlanes);
        click(botonBuscarPlanes);
    }

    public void derivarElPlanOperativoRolResponsableUo() throws InterruptedException {
        // Se localiza el valor dinámico y la XPath para mi metodo getElementAndValueDinamic
        Thread.sleep(1000);
        String valorAnioPlanOperativo = "02/02/2024";
        String xpathPlanOperativo = String.format("//tr[td[contains(text(), '%s')]]//td[contains(@class, 'dx-command-select')]", valorAnioPlanOperativo); // String.format(): Utiliza este método para reemplazar %s en el XPath con el valor de valorAnioPlanOperativo

        click(seleccionarPlanCheckbox);

        click(listadoAcciones);
        click(accionDerivar);
        waitForWebElementVisibilityOfElementLocated(validarModalDerivarPlan);
        click(botonAceptarModalDerivarPlan);
    }

    public void seleccionarUoYPeriodoUsuarioPlaneamiento(String ambito, String anio) throws InterruptedException {
        System.out.println("Enrta al metodo seleccionarUoYPeriodoResponsableUo");
        waitForWebElementPresenceOfElementLocated(listadoUo);
        System.out.println("intenta localizar primer elemento");
        //waitForWebElementClickable(listadoUo);
        click(listadoUo);
        click(escribirCodUo);
        Thread.sleep(1000);
        typeText(escribirCodUo, ambito);
        // Esperar a que el elemento que contiene el código de Ambito esté visible para hacer clic
        WebElement resultadoAmbito = waitForTextInWebElementVisibilityOfElementLocated(resultadoAmbito(ambito), ambito);
        resultadoAmbito.click();

        //waitForWebElementInvisibilityOfElementLocated(loadingPanel);
        //waitForWebElementPresenceOfElementLocated(listadoPeriodo);
        Thread.sleep(1000);
        waitForWebElementClickable(listadoPeriodo);
        click(listadoPeriodo);
        // Esperar a que el elemento que contiene el nro de Año esté visible para hacer clic
        WebElement resultadoPeriodo = waitForTextInWebElementVisibilityOfElementLocated(resultadoNroAnio(anio), anio);
        resultadoPeriodo.click();

        waitForWebElementClickable(botonBuscarPlanes);
        click(botonBuscarPlanes);
    }

    public void derivarElPlanOperativoRolUsuarioPlaneamiento() throws InterruptedException {
        // Se localiza el valor dinámico y la XPath para mi metodo getElementAndValueDinamic
        Thread.sleep(1000);
        String valorAnioPlanOperativo = "02/02/2024";
        String xpathPlanOperativo = String.format("//tr[td[contains(text(), '%s')]]//td[contains(@class, 'dx-command-select')]", valorAnioPlanOperativo); // String.format(): Utiliza este método para reemplazar %s en el XPath con el valor de valorAnioPlanOperativo

        click(seleccionarPlanCheckbox);

        click(listadoAcciones);
        click(accionDerivar);
        waitForWebElementVisibilityOfElementLocated(validarModalDerivarPlan);
        click(botonAceptarModalDerivarPlan);
    }

    public void seleccionarUoYPeriodoSupervisorPlprepi(String ambito, String anio) throws InterruptedException {
        System.out.println("Enrta al metodo seleccionarUoYPeriodoResponsableUo");
        waitForWebElementPresenceOfElementLocated(listadoUo);
        System.out.println("intenta localizar primer elemento");
        //waitForWebElementClickable(listadoUo);
        click(listadoUo);
        click(escribirCodUo);
        Thread.sleep(1000);
        typeText(escribirCodUo, ambito);
        // Esperar a que el elemento que contiene el código de Ambito esté visible para hacer clic
        WebElement resultadoAmbito = waitForTextInWebElementVisibilityOfElementLocated(resultadoAmbito(ambito), ambito);
        resultadoAmbito.click();

        //waitForWebElementInvisibilityOfElementLocated(loadingPanel);
        //waitForWebElementPresenceOfElementLocated(listadoPeriodo);
        Thread.sleep(1000);
        waitForWebElementClickable(listadoPeriodo);
        click(listadoPeriodo);
        // Esperar a que el elemento que contiene el nro de Año esté visible para hacer clic
        WebElement resultadoPeriodo = waitForTextInWebElementVisibilityOfElementLocated(resultadoNroAnio(anio), anio);
        resultadoPeriodo.click();

        waitForWebElementClickable(botonBuscarPlanes);
        click(botonBuscarPlanes);
    }

    public void aprobarElPlanOperativoRolSupervisorPlprepi(String filePath) throws InterruptedException {
        // Se localiza el valor dinámico y la XPath para mi metodo getElementAndValueDinamic
        Thread.sleep(1000);
        String valorAnioPlanOperativo = "02/02/2024";
        String xpathPlanOperativo = String.format("//tr[td[contains(text(), '%s')]]//td[contains(@class, 'dx-command-select')]", valorAnioPlanOperativo); // String.format(): Utiliza este método para reemplazar %s en el XPath con el valor de valorAnioPlanOperativo

        click(seleccionarPlanCheckbox);

        click(listadoAcciones);
        click(accionAprobar);
        waitForWebElementVisibilityOfElementLocated(validarModalAprobarPlan);
        typeText(resolucionTextBox, "Test Automation");

        // Verificar si el archivo existe
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IllegalArgumentException("El archivo especificado no existe: " + filePath);
        }

        try {
            // Localizar el área de arrastre
            WebElement dropTarget = driver.findElement(dropTargetPdf);

            // Script de JavaScript para simular el drag-and-drop
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String dragAndDropScript = "const target = arguments[0];"
                    + "const dataTransfer = new DataTransfer();"
                    + "dataTransfer.items.add(new File([''], arguments[1]));"
                    + "target.dispatchEvent(new DragEvent('drop', { dataTransfer }));";

            // Ejecutar el script con el área de arrastre y el archivo
            js.executeScript(dragAndDropScript, dropTarget, file.getAbsolutePath());

            System.out.println("Archivo arrastrado y soltado exitosamente: " + filePath);
        } catch (Exception e) {
            System.err.println("Error durante la operación de arrastrar y soltar: " + e.getMessage());


        /*
        //Interactuar con el botón adjuntar y el explorador de archivos
        click(botonAdjuntarResol);
        Thread.sleep(1000);
        // Localizar el elemento input[type="file"]
        WebElement inputFile = driver.findElement(By.xpath("//input[@type='file']"));
        // Enviar la ruta absoluta del archivo
        inputFile.sendKeys("C:\\Users\\Usuario\\Downloads\\prueba.pdf");
         */
        }
    }
}

