package pageObjects;

import org.openqa.selenium.By;

public class CapacidadOperativaPage extends BasePage{

    /*--- LOCALIZADORES FEATURE COPE_OCI CP0001  ---*/
    private final By divMenuCapacidadOperativa = By.cssSelector("dx-item dx-treeview-item");
    private final By capacidadOperativaMenu = By.xpath("//div[@class='dx-item dx-treeview-item'][contains(.,'Registrar Capacidad Operativa - OP OCI')]");
    private final By limpiarAmbitoIcon = By.xpath("(//span[contains(@class,'dx-icon dx-icon-clear')])[1]");
    private final By desplegarAmbitoComboBox = By.xpath("(//div[@class='dx-dropdowneditor-icon'])[1]");
    private final By seleccionarAmbitoComboBox = By.xpath("//div[@class='dx-item-content dx-treeview-item-content'][contains(.,'PODER JUDICIAL')]");
    private final By buscarButton = By.xpath("//div[@class='dx-button-content'][contains(.,'Buscar')]");
    private final By divBuscarButton = By.cssSelector(".dx-overlay-wrapper.dx-loadpanel-wrapper.dx-overlay-shader");
    private final By accionesDropDownButton = By.xpath("//dx-select-box[contains(@dropdownbuttontemplate,'dropDownButtonTemplate')]");
    private final By seleccionarAgregarPersonalDropDownButton = By.xpath("//div[@class='dx-scrollable-content'][contains(.,'Agregar Personal')]");
    private final By validarAccesoAgregarPersonal = By.xpath("//div[@class='section-caption'][contains(.,'Lista de Personales')]");
    private final By buscarAgregarButton = By.xpath("//dx-button[@role='button'][contains(@id,'add')][contains(.,'Buscar y agregar')]");
    private final By divAgregarPersonalButton = By.cssSelector(".dx-overlay-wrapper.dx-loadpanel-wrapper.dx-overlay-shader");
    private final By nroDocumentoTextBox = By.xpath("(//input[@class='dx-texteditor-input'][contains(@name,'documento')])[2]");
    private final By buscarPersonalButton = By.xpath("(//dx-button[@class='dx-widget dx-button dx-button-mode-contained dx-button-normal dx-button-has-text dx-button-has-icon primary-custom-dx-button custom-dx-button'][contains(@aria-label,'Buscar')])[2]");
    private final By divSeleccionarPersonalCheckBox = By.cssSelector(".dx-overlay-wrapper.dx-loadpanel-wrapper.dx-overlay-shader");
    private final By seleccionarPersonalCheckbox = By.xpath("(//span[contains(@class,'dx-checkbox-icon')])[2]");
    private final By divAgregarCapacidadOperativaButton = By.cssSelector(".dx-overlay-wrapper.dx-loadpanel-wrapper.dx-overlay-shader");
    private final By agregarCapacidadOperativaButton = By.xpath("//div[@class='dx-button-content'][contains(.,'Agregar Capacidad Operativa')]");
    private final By guardarCapacidadOperativaButton = By.xpath("//div[@class='dx-button-content'][contains(.,'Guardar Capacidad Operativa')]");
    private final By verDetalleValidacionModal = By.xpath("//div[@class='dx-template-wrapper dx-item-content dx-accordion-item-title'][contains(.,'Ver detalle')]");
    private final By validarMensajeExcepcionModal = By.xpath("//li[contains(.,'listaPersonal[0]: El personal nro 40472538 se encuentra registrada en otro Órgano de Control (L352), debe solicitar que sea compartido.')]");

    /*--- LOCALIZADORES FEATURE COPE_OCI CP0002  ---*/
    private final By validarMensajeNroDctoIncorrecto = By.xpath("//span[@class='message'][contains(.,'\"description\":[\"Ingrese número DNI valido\"]')]");

    public CapacidadOperativaPage() {
        super(driver);
    }

    /*--- METODOS CP001 ---*/
    public void elUsuarioDeOciIngresaACapacidadOperativa(){
        waitForWebElementInvisibilityOfElementLocated(divMenuCapacidadOperativa);
        waitForWebElementClickable(capacidadOperativaMenu);
        click(capacidadOperativaMenu);
    }

    public void seleccinoElAmbito() throws InterruptedException {
        Thread.sleep(1000);
        waitForWebElementVisibilityOfElementLocated(limpiarAmbitoIcon); //espero que este visible el icono limpiar
        waitForWebElementClickable(limpiarAmbitoIcon); //y espero que sea clickeable el icono limpiar
        click(limpiarAmbitoIcon);

        waitForWebElementPresenceOfElementLocated(desplegarAmbitoComboBox);
        Thread.sleep(1000);
        click(desplegarAmbitoComboBox);


        waitForWebElementVisibilityOfElementLocated(seleccionarAmbitoComboBox);
        click(seleccionarAmbitoComboBox);

        waitForWebElementClickable(buscarButton);
        click(buscarButton);
    }

    public void doyClicEnAgregarPersonal(){
        waitForWebElementInvisibilityOfElementLocated(divBuscarButton);
        waitForWebElementClickable(accionesDropDownButton);
        click(accionesDropDownButton);
        click(seleccionarAgregarPersonalDropDownButton);
        waitForWebElementVisibilityOfElementLocated(validarAccesoAgregarPersonal);
        assertEqualsGetTextAttributeForText("Lista de Personales", validarAccesoAgregarPersonal);
    }

    public void doyClicEnBuscarYAgregar(String nroDocumento){
        waitForWebElementClickable(buscarAgregarButton);
        click(buscarAgregarButton);
        waitForWebElementInvisibilityOfElementLocated(divAgregarPersonalButton);
        waitForWebElementClickable(nroDocumentoTextBox);
        typeText(nroDocumentoTextBox, nroDocumento);
        click(buscarPersonalButton);
    }

    public void seleccionoElPersonalBuscadoYLoAgrego() throws InterruptedException {
        waitForWebElementInvisibilityOfElementLocated(divSeleccionarPersonalCheckBox);
        waitForWebElementPresenceOfElementLocated(seleccionarPersonalCheckbox);
        Thread.sleep(1000);
        waitForWebElementInvisibilityOfElementLocated(divAgregarCapacidadOperativaButton);
        click(seleccionarPersonalCheckbox);

        click(agregarCapacidadOperativaButton);
    }

    public void doyClicAlBotonGuardarCapacidadOperativa(){
        waitForWebElementClickable(guardarCapacidadOperativaButton);
        click(guardarCapacidadOperativaButton);
    }

    public void seMuestraElMensajeDeValidacionYSeImpideLaGrabacion(){
        waitForWebElementClickable(verDetalleValidacionModal);
        click(verDetalleValidacionModal);
        waitForWebElementVisibilityOfElementLocated(validarMensajeExcepcionModal);
        assertEqualsGetTextAttributeForText("listaPersonal[0]: El personal nro 40472538 se encuentra registrada en otro Órgano de Control (L352), debe solicitar que sea compartido.", validarMensajeExcepcionModal);
        takeScreenshot("CP001");
    }

    /*--- METODOS CP002 ---*/

    public void seMuestraElMensajeIngreseNumeroDniValido(){
        waitForWebElementVisibilityOfElementLocated(validarMensajeNroDctoIncorrecto);
        assertTrueGetTextContains("\"description\":[\"Ingrese número DNI valido\"]", validarMensajeNroDctoIncorrecto);
        takeScreenshot("CP002");
    }

}
