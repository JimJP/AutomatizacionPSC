package pageObjects;

import org.openqa.selenium.By;
import utils.Constants_Variables;

public class LoginPage extends BasePage{

    private final By userNameInput = By.id("txtUsuario");
    private final By passwordInput = By.id("txtPassword");
    private final By loginButton = By.id("btnIngresar");
    private final By welcomeSiscoLabel = By.xpath("//div[@class='clearfix'][contains(.,'Sistema Integrado de Seguridad')]");

    public LoginPage() {
        super(driver);
    }

    public void elUsuarioIniciaSesion (){
        typeText(userNameInput, Constants_Variables.USER_DEV);
        typeText(passwordInput, Constants_Variables.USER_PASSWORD_DEV);
        click(loginButton);
    }

    public void seMuestraLaInterfazDeSisco(){
        waitForWebElementVisibilityOfElementLocated(welcomeSiscoLabel);
        assertEqualsGetTextAttributeForText("Sistema Integrado de Seguridad", welcomeSiscoLabel);
    }

}
