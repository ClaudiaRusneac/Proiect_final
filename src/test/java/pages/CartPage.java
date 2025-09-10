package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;


  //Clasa reprezintă pagina de coș (Cart) unde utilizatorul poate vedea produsele adăugate și poate continua procesul de cumpărare.

public class CartPage {

    private final ElementHelper helper;

    // Selector pentru butonul "Checkout" din pagina Cart
    private final By checkoutBtn = By.id("checkout");


     // Constructor care primește instanța WebDriver și initializează helper-ul pentru elemente.
    public CartPage(WebDriver driver) {
        helper = new ElementHelper(driver);
    }


     // Apasă butonul "Checkout" pentru a începe procesul de finalizare a comenzii.

    public void proceedToCheckout() {
        helper.click(checkoutBtn);
    }
}