package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants_Variables;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;

    static { //Crea una instancia de ChromeOptions e Inicializa el WebDriver con el ChromeDriver
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Variables.DEFAULT_TIMEOUT));
    }

    public BasePage(WebDriver driver) { //Constructor de la clase BasePage que toma un objeto WebDriver como argumento y se utilizan para inicializar nuevos objetos de una clase
        BasePage.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants_Variables.DEFAULT_TIMEOUT));
        driver.manage().window().maximize();
    }

    public static void navigateToUrl (String url){ //Metodo navegar a una URL del navegador
        try { // Verifica si la URL es válida y no es nula o vacía
            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("La URL no puede ser nula o estar vacía.");
            }
            // Intenta navegar a la URL proporcionada
            driver.get(url);

        } catch (IllegalArgumentException e) { // Maneja excepciones donde la URL es nula o inválida
            System.err.println("Error: " + e.getMessage());

        } catch (WebDriverException e) { // Maneja excepciones específicas de WebDriver
            System.err.println("Error: Ocurrió un problema al intentar navegar a la URL.");
            e.printStackTrace();

        } catch (Exception e) { // Maneja cualquier otra excepción no específica
            System.err.println("Error inesperado al intentar navegar a la URL.");
            e.printStackTrace();
        }
    }

    public static void closeBrowser() { //Cerrar navegador
        try {
            // Intenta cerrar el navegador
            if (driver != null) {
                driver.quit();
            } else {
                System.err.println("Error: El driver es nulo. No se puede cerrar el navegador.");
            }

        } catch (WebDriverException e) { // Maneja excepciones específicas de WebDriver
            System.err.println("Error: Ocurrió un problema al intentar cerrar el navegador.");
            e.printStackTrace();

        } catch (Exception e) { // Maneja cualquier otra excepción no específica
            System.err.println("Error inesperado al intentar cerrar el navegador.");
            e.printStackTrace();

        } finally { // Asegura que el driver se establezca como null para evitar referencias erróneas
            driver = null;
        }
    }

    public WebElement findElement(By locator) { //Localiza y retorna el WebElement
        try {
            return driver.findElement(locator);

        } catch (NoSuchElementException e) { // Maneja la excepción si el elemento no se encuentra
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();
            return null;

        } catch (Exception e) { // Maneja cualquier otra excepción que pueda ocurrir
            System.err.println("Error inesperado al intentar localizar el elemento: " + locator.toString());
            e.printStackTrace();
            return null;
        }
    }

    public void typeText(By locator, String typeText) { //Localiza y escribe texto
        try {
            WebElement element = driver.findElement(locator);
            element.sendKeys(typeText);

        } catch (NoSuchElementException e) { // Maneja la excepción si el elemento no se encuentra
            System.err.println("Error: No se pudo encontrar el elemento para escribir: " + locator.toString());
            e.printStackTrace();

        } catch (ElementNotInteractableException e) { // Maneja la excepción si el elemento no es interactuable
            System.err.println("Error: No se puede interactuar con el elemento para escribir: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento para escribir ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) { // Maneja cualquier otra excepción que pueda ocurrir
            System.err.println("Error inesperado al intentar escribir texto: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void click(By locator) { //Localiza y hace clic
        try {
            WebElement element = driver.findElement(locator);
            element.click();

        } catch (NoSuchElementException e) { // Maneja la excepción si el elemento no se encuentra
            System.err.println("Error: No se pudo encontrar el elemento para hacer click: " + locator.toString());
            e.printStackTrace();

        } catch (ElementNotInteractableException e) { // Maneja la excepción si el elemento no es interactuable
            System.err.println("Error: No se puede interactuar con el elemento para hacer click: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale) para hacer click: " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) { // Maneja cualquier otra excepción que pueda ocurrir
            System.err.println("Error inesperado al intentar hacer clic al elemento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void doubleClic(By locator) { //Localiza y hace doble clic
        try {
            WebElement element = driver.findElement(locator);
            action.doubleClick(element).perform();

        } catch (NoSuchElementException e) { // Maneja la excepción si el elemento no se encuentra
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (ElementNotInteractableException e) { // Maneja la excepción si el elemento no es interactuable
            System.err.println("Error: No se puede interactuar con el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) { // Maneja cualquier otra excepción que pueda ocurrir
            System.err.println("Error inesperado al intentar hacer doble clic al elemento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void rightClic(By locator) { //Localiza y hace clic derecho
        try {
            WebElement element = driver.findElement(locator);
            action.contextClick(element).perform();

        } catch (NoSuchElementException e) { // Maneja la excepción si el elemento no se encuentra
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (ElementNotInteractableException e) { // Maneja la excepción si el elemento no es interactuable
            System.err.println("Error: No se puede interactuar con el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) { // Maneja cualquier otra excepción que pueda ocurrir
            System.err.println("Error inesperado al intentar hacer clic derecho al elemento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void mouseDown(By locator) { //Localiza y hace clic a un elemento para bajar el mouse
        try {
            WebElement element = driver.findElement(locator);
            action.clickAndHold(element).perform();

        } catch (NoSuchElementException e) { // Maneja la excepción si el elemento no se encuentra
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (ElementNotInteractableException e) { // Maneja la excepción si el elemento no es interactuable
            System.err.println("Error: No se puede interactuar con el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) { // Maneja cualquier otra excepción que pueda ocurrir
            System.err.println("Error inesperado al intentar hacer mouse down al elemento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void mouseUp(By locator) { //Localiza y hace clic a un elemento para subir el mouse
        try {
            WebElement element = driver.findElement(locator);
            action.release(element).perform();

        } catch (NoSuchElementException e) { // Maneja la excepción si el elemento no se encuentra
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (ElementNotInteractableException e) { // Maneja la excepción si el elemento no es interactuable
            System.err.println("Error: No se puede interactuar con el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) { // Maneja cualquier otra excepción que pueda ocurrir
            System.err.println("Error inesperado al intentar hacer mouse up al elemento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void moveCursorToElement(By locator){ //Mueve el cursor del ratón a un elemento web (menús desplegables, tooltips, etc.)
        try {
            WebElement element = driver.findElement(locator);
            action.moveToElement(element).perform();

        } catch (NoSuchElementException e) { // Maneja la excepción si el elemento no se encuentra
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (ElementNotInteractableException e) { // Maneja la excepción si el elemento no es interactuable
            System.err.println("Error: No se puede interactuar con el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) { // Maneja cualquier otra excepción que pueda ocurrir
            System.err.println("Error inesperado al intentar mover el cursor al elemento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean elementIsDisplayed(By locator) { //Retorna si es visible el elemento (true) o no visible (false)
        try {
            WebElement element = findElement(locator);
            return element.isDisplayed();

        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            return false;

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            return false;

        } catch (Exception e) {
            System.err.println("Error inesperado al verificar si el elemento está visible: " + e.getMessage());
            return false;
        }
    }

    public void waitForWebElementClickable(By locator) { //Espera que el Elemento sea clickeable con un maximo de 20 seg
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));

        } catch (TimeoutException e) {
            System.err.println("Error: El elemento no se volvió clickeable en el tiempo esperado: " + locator.toString());
            e.printStackTrace();

        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale) y no puede esperar que sea clickeable: " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error inesperado al esperar que el elemento sea clickeable: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void waitForWebElementClickable(WebElement element) { //Espera que el Elemento sea clickeable con un maximo de 20 seg

        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void waitForWebElementPresenceOfElementLocated(By locator) { //Espera hasta que un elemento esté presente en el DOM. No garantiza visibilidad y podría estar oculto
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        } catch (TimeoutException e) {
            System.err.println("Error: El elemento no se hizo presente en el DOM en el tiempo esperado: " + locator.toString());
            e.printStackTrace();

        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar la presencia del elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error inesperado al esperar que el elemento esté presente en el DOM: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void waitForWebElementVisibilityOfElementLocated(By locator) { //Espera hasta que un elemento esté visible en la página para interactuar inmediatamente con el
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (TimeoutException e) {
            System.err.println("Error: El elemento no se hizo visible en el tiempo esperado: " + locator.toString());
            e.printStackTrace();

        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error inesperado al esperar que el elemento sea visible: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public WebElement waitForTextInWebElementVisibilityOfElementLocated(By locator, String codigoUO) { //Permite que el texto tenga coincidencia con el elemento de carga en el listbox
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, codigoUO));

        } catch (TimeoutException e) {
            System.err.println("Error: El elemento no se hizo visible o no contenía el texto esperado en el tiempo establecido: " + locator.toString());
            e.printStackTrace();

        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error inesperado al esperar que el elemento sea visible: " + e.getMessage());
            e.printStackTrace();
        }
        return element;
    }

    public void waitForWebElementInvisibilityOfElementLocated(By locator) { //Espera hasta que un elemento no sea visible o haya sido eliminado del DOM (modal, alertas, etc)
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

        } catch (TimeoutException e) {
            System.err.println("Error: El elemento no se hizo invisible en el tiempo esperado: " + locator.toString());
            e.printStackTrace();

        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error inesperado al esperar que el elemento sea invisible: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void waitForWebElementInvisibilityOfElementLocatedWebElement(WebElement element) { //Espera hasta que un elemento no sea visible o haya sido eliminado del DOM (modal, alertas, etc)
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));

        } catch (TimeoutException e) {
            System.err.println("Error: El WebElement no se hizo invisible en el tiempo esperado: " + element.toString());
            e.printStackTrace();

        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el WebElement: " + element.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + element.toString());
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error inesperado al esperar que el WebElement sea invisible: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void assertEqualsGetTextAttributeForText(String mensaje, By locator) { //Verifica que la cadena de texto completa de un elemento web sea igual a un mensaje específico
        try {
            WebElement element = driver.findElement(locator);
            Assert.assertEquals("El texto del elemento no coincide con el mensaje esperado.", mensaje, element.getText());

        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error inesperado al verificar el texto del elemento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void assertTrueGetTextContains(String mensaje, By locator){ //Verifica que la cadena de texto de forma parcial de un elemento web sea igual a un mensaje específico
        try {
            WebElement element = driver.findElement(locator);
            String textoElemento = element.getText();
            Assert.assertTrue("El texto del elemento no contiene el mensaje esperado o parcial.", textoElemento.contains(mensaje));

        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error inesperado al verificar si el texto del elemento contiene el mensaje: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void assertTrueGetClassAttributeForClass(String mensaje, By locator) { //Verifica que el atributo class de un elemento web (puede ser img) sea igual a un mensaje específico
        try {
            WebElement element = driver.findElement(locator);
            String classAttribute = element.getAttribute("class");
            Assert.assertEquals("El atributo class del elemento no coincide con el atributo esperado.", mensaje, classAttribute);

        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el elemento: " + locator.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + locator.toString());
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error inesperado al verificar si el texto del elemento contiene el mensaje de manera parcial: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void waitForWebElementPresence(WebElement element) {  // Espera explícita para esperar a que el elemento sea visible y continuar con la siguiente acción
        try {
            wait.until(ExpectedConditions.visibilityOf(element));

        } catch (TimeoutException e) {
            System.err.println("Error: El elemento no se hizo presente en el tiempo esperado: " + element.toString());
            e.printStackTrace();

        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el elemento: " + element.toString());
            e.printStackTrace();

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM (Stale): " + element.toString());
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error inesperado al esperar que el elemento este presente en el DOM: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void takeScreenshot(String fileName) { // Metodo para tomar capturas de pantallas
        // Convertir el driver a TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Capturar la pantalla y guardarla en un archivo
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        // Especificar la ruta donde se guardará la captura
        File destFile = new File("C:/Users/jose.julca/Downloads/" + fileName + ".png");
        try {
            // Guardar el archivo
            FileHandler.copy(srcFile, destFile);
            System.out.println("Captura de pantalla guardada en: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebElement getElementAndValueDinamic(String xpathPattern, String valorDinamico){ // Método para encontrar un elemento según un XPath dinámico y un valor dinamico para insertar
        try {
            String xpathCompleto = String.format(xpathPattern, valorDinamico);
            return driver.findElement(By.xpath(xpathCompleto));
        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el elemento con el XPath: " + xpathPattern);
            e.printStackTrace();
            return null; // Retornar null si no se encuentra el elemento
        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM: " + xpathPattern);
            e.printStackTrace();
            return null; // Manejar cuando el elemento ya no es válido
        } catch (ElementNotInteractableException e) {
            System.err.println("Error: El elemento no es interactuable: " + xpathPattern);
            e.printStackTrace();
            return null; // Manejar cuando el elemento no es interactuable
        } catch (Exception e) {
            // Captura cualquier otra excepción inesperada
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void clickJavaScript(WebElement element){ // Metodo para hacer click usando JavaScript sobre un WebElement
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            //return null;
        } catch (NoSuchElementException e) {
            System.err.println("Error: No se pudo encontrar el elemento para hacer clic con JavaScript: " + element);
            e.printStackTrace(); // Retornar null si no se encuentra el elemento
        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM para el uso de JavaScript: " + element);
            e.printStackTrace(); // Manejar cuando el elemento ya no es válido
        } catch (ElementNotInteractableException e) {
            System.err.println("Error: El elemento no es interactuable para el uso de JavaScript: " + element);
            e.printStackTrace(); // Manejar cuando el elemento no es interactuable
        } catch (Exception e) {
            // Captura cualquier otra excepción inesperada
            System.err.println("Error inesperado para el uso de JavaScript: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método genérico para subir un archivo.
     *
     * @param locator El localizador del elemento input[type="file"]
     * @param filePath La ruta absoluta del archivo a subir
     */
    public void uploadFile(By locator, String filePath) {
        try {
            WebElement inputFile = driver.findElement(locator);
            inputFile.sendKeys(filePath);
            System.out.println("Archivo subido correctamente: " + filePath);
        } catch (Exception e) {
            System.err.println("Error al intentar subir el archivo: " + e.getMessage());
        }
    }

}
