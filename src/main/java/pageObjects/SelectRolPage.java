package pageObjects;

import org.openqa.selenium.By;

public class SelectRolPage extends BasePage{

    private final By moduloSiscoButton = By.xpath("//a[@title='SISTEMA DE CONTROL SISCO  - PAGINA CONEXION SCA']");
    private final By welcomeModuloSiscoLabel = By.xpath("//div[@class='content-block subtitle-main'][contains(.,'Sistema de control SISCO')]");
    private final By divComBoxRol = By.cssSelector(".dx-overlay-wrapper.dx-loadpanel-wrapper.dx-overlay-shader");
    private final By rolComboBox = By.xpath("//div[contains(@class,'dx-dropdowneditor-input-wrapper dx-selectbox-container')]");
    private final By selectRolOpeOciComboBox = By.xpath("//div[@class='dx-item-content dx-list-item-content'][contains(.,'OPERADOR DE PLANEAMIENTO OCI')]");
    private final By cargaPaginaRolOverlay = By.xpath("//div[contains(@class,'dx-loadpanel-content-wrapper')]");
    private final By pscButton = By.xpath("//img[contains(@src,'PSC')]");
    private final By welcomeModuloPscLabel = By.xpath("//img[@class='img-icon']");

    public SelectRolPage() {
        super(driver);
    }

    public void ingresoAlModuloSisco(){
        click(moduloSiscoButton);
    }

    public void seMuestraLaInterfazDeRoles(){
        waitForWebElementVisibilityOfElementLocated(welcomeModuloSiscoLabel);
        assertEqualsGetTextAttributeForText("Sistema de control SISCO", welcomeModuloSiscoLabel);
    }

    public void seleccionoElRolOperadorDePlaneamientoOci() throws InterruptedException {
        waitForWebElementInvisibilityOfElementLocated(divComBoxRol);
        click(rolComboBox);
        click(selectRolOpeOciComboBox);
        waitForWebElementVisibilityOfElementLocated(pscButton);
        waitForWebElementInvisibilityOfElementLocated(cargaPaginaRolOverlay);
        click(pscButton);
    }

    public void seMuestraLaInterfazDePsc(){
        waitForWebElementVisibilityOfElementLocated(welcomeModuloPscLabel);
        assertTrueGetClassAttributeForClass("img-icon", welcomeModuloPscLabel);
    }
}
