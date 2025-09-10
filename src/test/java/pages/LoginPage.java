package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

/*
 * Clasa reprezintă pagina de autentificare a utilizatorului.
 * Conține metode pentru completarea formularului de login și verificarea mesajelor de eroare.
 */
public class LoginPage {

    // helper pentru scris text, click, verificări
    private final ElementHelper helper;

    // selector câmp username
    private final By usernameField = By.id("user-name");
    // selector câmp parola
    private final By passwordField = By.id("password");
    // selector buton login
    private final By loginButton = By.id("login-button");
    // selector mesaj eroare login
    private final By errorMessage = By.cssSelector("[data-test='error']");

    // constructor primește driverul și creează helperul
    public LoginPage(WebDriver driver) {
        helper = new ElementHelper(driver);
    }

    // completează username și parola și apasă butonul login
    public void login(String username, String password) {
        helper.insertText(usernameField, username);
        helper.insertText(passwordField, password);
        helper.click(loginButton);
    }

    // verifică dacă mesajul de eroare de la login este afișat
    public boolean isLoginErrorDisplayed() {
        return helper.isPresent(errorMessage);
    }
}