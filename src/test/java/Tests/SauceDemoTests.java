package Tests;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.*;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Clasa conține 5 teste separate pentru simularea unui flux complet de cumpărare
 * pe site-ul https://www.saucedemo.com, inclusiv verificarea prețului produsului și logout.
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SauceDemoTests extends BaseTest {

    // obiectele pentru paginile folosite în test
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;
    private MenuPage menuPage;  // pentru logout

    // username, parola, date personale
    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String FIRST_NAME = "Ion";
    private static final String LAST_NAME = "Popescu";
    private static final String ZIP_CODE = "12345";

    @BeforeAll
    public void initPages() {
        // deschide site-ul
        driver.get("https://www.saucedemo.com/");

        // inițializează toate paginile
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        confirmationPage = new ConfirmationPage(driver);
        menuPage = new MenuPage(driver);  // inițializare meniu
    }

    // Testul 1: logare cu date corecte
    @Test
    @Order(1)
    public void testLogin() {
        // face login
        loginPage.login(USERNAME, PASSWORD);

        // verifică dacă NU apare mesaj de eroare
        assertFalse(loginPage.isLoginErrorDisplayed(), "Login-ul a eșuat!");
    }


    // Testul 2: verifică prețul produsului din listă
    @Test
    @Order(2)
    public void testVerifyProductPrice() {
        // obține prețul primului produs
        String price = productsPage.getProductPrice(0);

        // verifică dacă prețul nu este null și conține simbolul dolarului
        assertNotNull(price, "Prețul produsului este null!");
        assertTrue(price.contains("$"), "Prețul produsului nu conține simbolul $!");
    }

    // Testul 3: adaugă un produs în coș și intră în coș
    @Test
    @Order(3)
    public void testAddProductToCart() {
        // adaugă primul produs în coș
        productsPage.addProductToCart(0);

        // intră în pagina coșului
        productsPage.goToCart();
    }


    // Testul 4: finalizează comanda completă
    @Test
    @Order(4)
    public void testCheckoutAndConfirmOrder() {
        // merge la checkout
        cartPage.proceedToCheckout();

        // introduce detaliile de livrare
        checkoutPage.enterShippingDetails(FIRST_NAME, LAST_NAME, ZIP_CODE);

        // merge mai departe
        checkoutPage.continueToNextStep();

        // finalizează comanda
        checkoutPage.finishOrder();

        // verifică dacă apare mesajul de confirmare
        assertTrue(confirmationPage.isOrderConfirmed(), "Comanda nu a fost confirmată!");
    }

    // Testul 5: face logout și verifică revenirea pe pagina de login
    @Test
    @Order(5)
    public void testLogout() {
        // face logout folosind meniul
        menuPage.logout();

        // verifică dacă URL-ul conține pagina de login după logout
        assertTrue(driver.getCurrentUrl().contains("saucedemo.com"), "Nu s-a revenit pe pagina de login după logout!");
    }
}