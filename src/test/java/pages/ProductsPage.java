package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Clasa reprezintă pagina cu lista de produse
public class ProductsPage {

    // driver-ul WebDriver folosit pentru interacțiunea cu browserul
    private final WebDriver driver;

    // WebDriverWait pentru așteptări explicite
    private final WebDriverWait wait;

    // Selector pentru butoanele "Add to Cart" de pe pagina produselor
    private final By addToCartButtons = By.cssSelector(".btn_inventory");

    // Selector pentru link-ul coșului de cumpărături
    private final By cartLink = By.cssSelector(".shopping_cart_link");

    // Selector pentru prețurile produselor afișate pe pagina de produse
    private final By productPrices = By.cssSelector(".inventory_item_price");

    // Constructorul primește driver-ul și inițializează obiectul de wait
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Metodă pentru a adăuga un produs în coș pe baza indexului (0-based)
    public void addProductToCart(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons));
        driver.findElements(addToCartButtons).get(index).click();
    }

    // Metodă pentru navigarea către pagina coșului de cumpărături
    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    // Metodă pentru a obține prețul produsului de pe listă, pe baza indexului (0-based)
    public String getProductPrice(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPrices));
        return driver.findElements(productPrices).get(index).getText();
    }
}