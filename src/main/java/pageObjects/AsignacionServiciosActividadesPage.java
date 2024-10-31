package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class AsignacionServiciosActividadesPage extends BasePage {

    private final By esperarSeHagaInvisibleOverlayLoadingPage = By.cssSelector(".dx-overlay-wrapper dx-loadpanel-wrapper dx-overlay-shader");
    private final By menuAsignacionServicios = By.xpath("//div[@class='menu-item-title'][contains(.,'Asignación de Servicios y Actividades')]");
    private final By welcomeAsignacionServiciosLabel = By.xpath("//b[@class='cgr-list-subtitle'][contains(.,'Listado de Asignaciones de Actividades')]");
    private final By welcomeListadoAsignacionUoOci = By.xpath("//b[@class='cgr-list-subtitle'][contains(.,'Lista de asignaciones Uo / Oci')]");
    private final By accionesSelect = By.xpath("//div[@class='cgr-operations has-one-element']//dx-select-box[@placeholder='Acciones']");
    private final By agregarAsignacionSelected = By.xpath("//div[@class='custom-select-item dx-template-wrapper dx-item-content dx-list-item-content'][contains(.,'Agregar asignación')]");
    private final By welcomeAgregarAsignacionActividades = By.xpath("//div[@class='caption cgr-form-subtitle'][contains(.,'Agregar Asignación de Actividades')]");
    private final By registroIndividualRadioButton = By.xpath("//div[@class='dx-radiobutton-icon']");
    private final By buscarUoListBox = By.xpath("//dx-select-box[@id='field_caocCodOrgctrl']//input[@role='combobox']");
    private final By buscarYSeleccionarActivButton = By.xpath("//span[@class='dx-button-text'][contains(.,'Buscar y seleccionar actividades')]");
    private final By welcomeModalBuscarActividades = By.xpath("//input[@autocomplete='off'][contains(@id,'cactNombre')]");
    private final By catalogoPncCombobox = By.xpath("//div[@class='dx-template-wrapper'][contains(.,'Catálogo PNCEl campo Catálogo PNC es requerido.')]");
    private final By seleccionarCatalogoPnc = By.xpath("//div[@class='dx-item-content dx-treeview-item-content'][contains(.,'2024 - 1.5')]");
    private final By grupoActividadesCombobox = By.xpath("//dx-drop-down-box[@placeholder='Seleccione'][contains(.,'Seleccione Grupo de Actividad')]");
    private final By escribirNombreGrupo = By.xpath("(//input[contains(@autocomplete,'off')])[16]");
    private final By seleccionarGrupoActividades = By.xpath("//span[contains(.,'GRUPO AUTOMATION - NO BORRAR NI EDITAR')]");
    private final By buscarModalButton = By.xpath("(//span[text()='Buscar'])[2]");
    private final By seleccionarTodasActividadesCheckbox = By.xpath("//div[contains(@aria-label,'Seleccionar todo')]");
    private final By asignarActividadesButton = By.xpath("//div[@class='dx-button-content'][contains(.,'Asignar')]");
    private final By modificarActividadesIcon = By.xpath("//td[@class='dx-command-edit dx-command-edit-with-icons']//a[@title='Modificar']");
    private final By seleccionarUnidadMedidaCombobox = By.xpath("(//div[contains(@class,'dx-texteditor-buttons-container')])[19]");
    private final By seleccionoUnidadMedida = By.xpath("//div[@class='dx-item dx-list-item'][contains(.,'Porcentaje')]");
    private final By seleccionarProductoComboBox = By.xpath("(//div[contains(@class,'dx-texteditor-buttons-container')])[20]");
    private final By seleccionoProducto = By.xpath("//div[@class='dx-item dx-list-item'][contains(.,'Informe')]");
    private final By guardarDatosGrillaAsignacion = By.xpath("//a[contains(@title,'Guardar')]");
    private final By grabarAsignacionButton = By.xpath("//div[@class='dx-button-content'][contains(.,'Grabar')]");
    private final By mensajeExitoAsignacion = By.xpath("//p[contains(.,'La petición se realizó correctamente')]");

    //LOCALIZADORES DINAMICOS

    private By resultadoCodigoUO(String codigoUO) {
        return By.xpath("//div[contains(text(), '" + codigoUO + "')]");
    }

    public AsignacionServiciosActividadesPage() {
        super(driver);
    }

    public void elUsuarioDePlaneamientoIngresaAAsignacionDeServicios() {
        waitForWebElementInvisibilityOfElementLocated(esperarSeHagaInvisibleOverlayLoadingPage);
        waitForWebElementClickable(menuAsignacionServicios);
        click(menuAsignacionServicios);
    }

    public void hagoClicEnLaOpcionEditarDelPeriodo2024() throws InterruptedException {
        // Se localiza el texto dinámico y la XPath para mi metodo getEditButton
        String valorDinamicoCelda = "2024";
        String xpathBtnEditar = "//tr[td[text()='%s']]/td/div/span/dx-button[@aria-label='edit']";

        waitForWebElementVisibilityOfElementLocated(welcomeAsignacionServiciosLabel);
        WebElement btnEditar = getEditButton(xpathBtnEditar, valorDinamicoCelda);
        clickJavaScript(btnEditar);
    }

    public void seMuestraElListadoDeAsignacionesDeUoOci(){
        waitForWebElementVisibilityOfElementLocated(welcomeListadoAsignacionUoOci);
        assertTrueGetTextContains("Lista de asignaciones Uo / Oci", welcomeListadoAsignacionUoOci);
    }

    public void hagoClicEnAccionesYLuegoEnAgregarAsignacion() {
        click(accionesSelect);
        click(agregarAsignacionSelected);
    }

    public void seMuestraLaInterfazAgregarAsignacionDeActividades() {
        waitForWebElementVisibilityOfElementLocated(welcomeAgregarAsignacionActividades);
        assertTrueGetTextContains("Agregar Asignación de Actividades", welcomeAgregarAsignacionActividades);
    }

    public void buscoYAgregoLaUoDeFormaManual(String codigoUO) throws InterruptedException {
        waitForWebElementInvisibilityOfElementLocated(esperarSeHagaInvisibleOverlayLoadingPage);
        waitForWebElementClickable(registroIndividualRadioButton);
        click(registroIndividualRadioButton);
        click(buscarUoListBox);
        typeText(buscarUoListBox, codigoUO);

        // Esperar a que el elemento que contiene el códigoUO esté visible para hacer clic
        WebElement listItem = waitForTextInWebElementVisibilityOfElementLocated(resultadoCodigoUO(codigoUO), codigoUO);
        listItem.click();
    }

    public void hagoClicEnElBotonBuscar() {
        click(buscarYSeleccionarActivButton);
    }

    public void seleccionoUnCatalogoPncYUnGrupoDeActividades() throws InterruptedException {
        try {
            waitForWebElementVisibilityOfElementLocated(welcomeModalBuscarActividades);
            waitForWebElementClickable(catalogoPncCombobox);
            click(catalogoPncCombobox);
            click(seleccionarCatalogoPnc);

            // Captura el combobox de nuevo antes de interactuar
            Thread.sleep(1000);
            waitForWebElementVisibilityOfElementLocated(grupoActividadesCombobox);
            waitForWebElementPresenceOfElementLocated(grupoActividadesCombobox);
            waitForWebElementClickable(grupoActividadesCombobox);
            WebElement grupoActividades = driver.findElement(grupoActividadesCombobox);
            //waitForWebElementClickable(grupoActividadesCombobox);
            grupoActividades.click();

            waitForWebElementVisibilityOfElementLocated(escribirNombreGrupo);
            waitForWebElementClickable(escribirNombreGrupo);
            click(escribirNombreGrupo);
            typeText(escribirNombreGrupo, "GRUPO AUTOMATION");

            // Captura el grupo de actividades de nuevo antes de hacer clic
            WebElement seleccionarGrupo = driver.findElement(seleccionarGrupoActividades);
            waitForWebElementVisibilityOfElementLocated(grupoActividadesCombobox);
            waitForWebElementPresenceOfElementLocated(grupoActividadesCombobox);
            waitForWebElementClickable(grupoActividadesCombobox);
            seleccionarGrupo.click();

        } catch (StaleElementReferenceException e) { // En el catch se reintenta el click al grupo de actividades y seleccionar grupo
            System.out.println("Mensaje: El metodo seleccionoUnCatalogoPncYUnGrupoDeActividades no pudo ejecutarse en el " +
                    "TRY y fue reejecutado en el CATCH");

            Thread.sleep(1000);
            waitForWebElementVisibilityOfElementLocated(grupoActividadesCombobox);
            waitForWebElementPresenceOfElementLocated(grupoActividadesCombobox);
            WebElement grupoActividades = driver.findElement(grupoActividadesCombobox);
            waitForWebElementClickable(grupoActividadesCombobox);
            grupoActividades.click();

            waitForWebElementClickable(escribirNombreGrupo);
            click(escribirNombreGrupo);
            typeText(escribirNombreGrupo, "GRUPO AUTOMATION");

            // Captura el grupo de actividades de nuevo antes de hacer clic
            waitForWebElementVisibilityOfElementLocated(seleccionarGrupoActividades);
            WebElement seleccionarGrupo = driver.findElement(seleccionarGrupoActividades);
            waitForWebElementClickable(seleccionarGrupoActividades);
            seleccionarGrupo.click();
        }
    }

    public void hagoClicEnElBotonBuscarDelModal() {
        click(buscarModalButton);
    }

    public void agregoTodosLosServiciosYActividades() {
        waitForWebElementClickable(seleccionarTodasActividadesCheckbox);
        click(seleccionarTodasActividadesCheckbox);
        click(asignarActividadesButton);
    }

    public void seMuestranTodasLasActividadesAgregadasALaU() {
        waitForWebElementVisibilityOfElementLocated(welcomeAgregarAsignacionActividades);
        mouseDown(grabarAsignacionButton);
    }

    public void agregoLaUnidadDeMedidaYProductoALasActividades() throws InterruptedException {
        waitForWebElementClickable(modificarActividadesIcon);
        click(modificarActividadesIcon);
        Thread.sleep(1000);
        waitForWebElementClickable(seleccionarUnidadMedidaCombobox);
        click(seleccionarUnidadMedidaCombobox);
        click(seleccionoUnidadMedida);
        WebElement clickProducto = driver.findElement(seleccionarProductoComboBox);
        clickJavaScript(clickProducto);
        click(seleccionoProducto);
        WebElement iconoGuardar = driver.findElement(guardarDatosGrillaAsignacion);
        clickJavaScript(iconoGuardar);

    }

    public void hagoClicEnElBotonGuardar() {
        click(grabarAsignacionButton);
    }

    public void seMuestraUnMensajeDeExito() {
        waitForWebElementVisibilityOfElementLocated(mensajeExitoAsignacion);
        assertEqualsGetTextAttributeForText("La petición se realizó correctamente", mensajeExitoAsignacion);
    }
}
