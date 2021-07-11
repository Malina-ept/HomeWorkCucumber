package cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class HomeTestStep {

//Checking the page title otus.ru
    @Given("Page otus.ru")
    public void pageOtusRu() {
        System.out.println("Page otus.ru");

    }

    @When("The page is open otus.ru")
    public void thePageIsOpenOtusRu() {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://otus.ru");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        assertEquals(expectedTitle, actualTitle);
        if (driver!=null)
            driver.quit();
    }

    @Then("The page has the expected title")
    public void thePageHasTheExpectedTitle() {
        System.out.println("The page has the expected title");

    }

//Checking address in Contacts
    @Given("Page otus.ru\\/contacts")
    public void pageOtusRuContacts() {
        System.out.println("Page otus.ru/contacts");
    }

    @When("Сhecking the contacts")
    public void сheckingTheContacts() {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://otus.ru/contacts");
        String expectedContactsText = "125167, г. Москва, Нарышкинская аллея., д. 5, стр. 2, тел. +7 499 938-92-02";
        assertEquals( "Адрес не соответствует ожидаемому",expectedContactsText, driver.findElement(By.xpath("//div[text()='Адрес']/../div[2]")).getText());

        if (driver!=null)
            driver.quit();
    }

    @Then("The address does not match the expected one")
    public void theAddressDoesNotMatchTheExpectedOne() {
        System.out.println("The address does not match the expected one");

    }

//Checking text in FAQ
    @Given("FAQ on page otus.ru")
    public void faqOnPageOtusRu() {
        System.out.println("FAQ on page otus.ru");
    }

    @When("Checking text in FAQ")
    public void checkingTextInFAQ() {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://otus.ru");
        driver.findElement(By.xpath("//header//a[@href='/faq/']")).click();
        driver.findElement(By.cssSelector("body > div.body-wrapper > div > div.container.container-padding-bottom.js-faq > div.container__row.js-tabs > div:nth-child(2) > div:nth-child(4) > div.faq-question__question.js-faq-question-question")).click();
        String expectedProgram = "Программу курса в сжатом виде можно увидеть на странице курса после блока с преподавателями. Подробную программу курса можно скачать кликнув на “Скачать подробную программу курса”";
        assertEquals("Текст не соответствует ожидаемому", expectedProgram, driver.findElement(By.cssSelector("body > div.body-wrapper > div > div.container.container-padding-bottom.js-faq > div.container__row.js-tabs > div:nth-child(2) > div:nth-child(4) > div.faq-question__answer.js-faq-answer")).getText());

        if (driver!=null)
            driver.quit();

    }

    @Then("The FAQ text corresponds to the expected")
    public void theFAQTextCorrespondsToTheExpected() {
        System.out.println("The FAQ text corresponds to the expected");
    }
}
