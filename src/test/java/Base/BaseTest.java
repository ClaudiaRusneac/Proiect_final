package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/*
 - Clasa de bază pentru teste
 - Aceasta inițializeaza și închide  browserul,
  -moștenită de toate clasele de test.
 */
public class BaseTest {

    // Driver-ul WebDriver este static și accesibil din clasele de test care extind BaseTest
    protected static WebDriver driver;

    /*
     - Metoda se execută o singură dată, înainte de toate testele din clasă.
      -Inițializează driverul Chrome in incognito,
      -maximizează fereastra și setează timpul de așteptare implicit la 0 secunde.
     */
    @BeforeAll
    public static void setup() {
        // Configurează automat WebDriver pentru Chrome (fără descărcare manuală a driverului)
        WebDriverManager.chromedriver().setup();

        //  mod incognito
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");


        driver = new ChromeDriver(options);

        // Maximizează fereastra browserului
        driver.manage().window().maximize();

        // Setează timpul de așteptare implicit la 0 secunde
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }


     // Metoda se execută o singură dată, după terminarea tuturor testelor din clasă.
     // Închide browserul

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            // Închide toate ferestrele browserului și oprește sesiunea WebDriver
            driver.quit();
        }
    }
}