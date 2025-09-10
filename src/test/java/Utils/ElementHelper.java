package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// Clasa ajută la lucrul cu elementele de pe pagină
public class ElementHelper {

    // driverul care controlează browserul
    private final WebDriver driver;

    // așteaptă până când elementele sunt vizibile sau clicabile (maxim 15 secunde)
    private final WebDriverWait wait;

    // constructorul care primește driverul și creează obiectul wait
    public ElementHelper(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // așteaptă până când elementul e vizibil
    public WebElement waitVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // așteaptă până când elementul e clicabil
    public WebElement waitClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // face click pe element
    public void click(By locator){
        waitClickable(locator).click();
    }

    // scrie text într-un câmp
    public void insertText(By locator, String text){
        WebElement el = waitVisible(locator);
        el.clear(); // șterge ce e deja în câmp
        el.sendKeys(text); // scrie textul nou
    }

    // verifică dacă elementul există în pagină
    public boolean isPresent(By locator){
        return !driver.findElements(locator).isEmpty();
    }
}