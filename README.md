# Automatizare teste pentru aplicația SauceDemo

Acest proiect conține scripturi automate pentru testarea aplicației web [SauceDemo](https://www.saucedemo.com/), folosind Selenium WebDriver și JUnit 5.

## Descrierea proiectului

Proiectul automatizează testarea funcționalităților de bază ale aplicației SauceDemo, cum ar fi autentificarea, adăugarea produselor în coș și verificarea elementelor importante ale paginii.


## Structura proiectului

- **BasePage** – clasa de bază pentru inițializarea driverului și setările generale
- **ElementHelper** – clasa utilitară pentru interacțiunea cu elementele paginii (click, inserare text, așteptare vizibilitate etc.)
- **BaseTest** – conține configurarea și managementul WebDriver-ului (setup/teardown)
- **Pages** – pachet cu toate clasele Page Object (LoginPage, ProductsPage, CartPage, CheckoutPage, ConfirmationPage, MenuPage)
- **SauceDemoTests** – clasa care conține testele automate JUnit 5

## Ce am testat

Test 1: Logare cu date corecte
Test 2: Verificarea prețului produsului din lista de produse
Test 3: Adăugarea unui produs în coșul de cumpărături
Test 4: Finalizarea comenzii complete
Test 5: Logout și verificarea revenirii pe pagina de autentificare

##  Pași de reproducere

Codul sursă și documentația pot fi accesate la:
👉 https://github.com/username/saucedemo-automation