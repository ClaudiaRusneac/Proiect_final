package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

/*
 * Clasa reprezintă meniul (sidebar) din aplicație,
 * unde utilizatorul poate face logout sau naviga în alte secțiuni.
 */
public class MenuPage {

    private final ElementHelper helper;

    // Selector pentru butonul de deschidere meniu (burger menu)
    private final By menuButton = By.id("react-burger-menu-btn");

    // Selector pentru butonul logout din meniu
    private final By logoutLink = By.id("logout_sidebar_link");

    public MenuPage(WebDriver driver) {
        helper = new ElementHelper(driver);
    }

    // Deschide meniul
    public void openMenu() {
        helper.click(menuButton);
    }

    // Face logout din aplicație
    public void logout() {
        openMenu();
        helper.click(logoutLink);
    }
}