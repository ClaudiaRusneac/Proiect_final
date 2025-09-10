package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

/*
 * Clasa reprezintă pagina de confirmare după finalizarea comenzii.
 * Verifică dacă mesajul de confirmare este afișat corect.
 */
public class ConfirmationPage {

    // helper pentru lucrul cu elementele din pagină
    private final ElementHelper helper;
    // selector pentru titlul mesajului de confirmare
    private final By confirmationHeader = By.cssSelector(".complete-header");

    // constructor primește driverul și creează helperul
    public ConfirmationPage(WebDriver driver) {
        this.helper = new ElementHelper(driver);
    }

    // verifică dacă mesajul de confirmare este afișat corect
    public boolean isOrderConfirmed() {
        try {
            String text = helper.waitVisible(confirmationHeader).getText();
            return text.contains("Thank you for your order!");
        } catch (Exception e) {
            return false;
        }
    }
}