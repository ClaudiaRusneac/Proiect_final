package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

/*
 * Clasa reprezintă pagina de checkout de pe SauceDemo,
 * unde se introduc detaliile de livrare și se finalizează comanda.
 */
public class CheckoutPage {

    private final ElementHelper helper;

    // câmp pentru prenume
    private final By firstNameField = By.id("first-name");
    // câmp pentru nume
    private final By lastNameField = By.id("last-name");
    // câmp pentru cod poștal
    private final By zipCodeField = By.id("postal-code");

    // buton pentru continuare
    private final By continueButton = By.id("continue");
    // buton pentru finalizare comandă
    private final By finishButton = By.id("finish");

    public CheckoutPage(WebDriver driver) {
        helper = new ElementHelper(driver);
    }
     //Metode :
    // completează câmpurile cu detaliile de livrare
    public void enterShippingDetails(String firstName, String lastName, String zipCode) {
        helper.insertText(firstNameField, firstName);
        helper.insertText(lastNameField, lastName);
        helper.insertText(zipCodeField, zipCode);
    }

    // apasă butonul continue pentru pasul următor
    public void continueToNextStep() {
        helper.click(continueButton);
    }

    // apasă butonul finish pentru a finaliza comanda
    public void finishOrder() {
        helper.click(finishButton);
    }
}
