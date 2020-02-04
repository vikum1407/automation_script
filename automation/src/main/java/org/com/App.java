package org.com;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.lang.System;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


public class App
{
    //	define variabls and vales....
    private static String URL = "http://automationpractice.com/index.php";

    private static String signInButton = "//a[@title='Log in to your customer account']";
    private static String emailTxtBox = "//*[@id=\"email_create\"]";
    private static String creatAccButton = "//button[@id='SubmitCreate']//span";
    private static String createAccPageHeader = "//h1[@class='page-heading']";


    // signup page elements Xpath
    private static String titleRadioBtn = "//input[@id='id_gender1']";
    private static String fnameTxtBox = "//input[@id='customer_firstname']";
    private static String lnameTxtBox = "//input[@id='customer_lastname']";
    private static String signupEmailTxtBox = "//input[@id='email']";
    private static String passwordTxtBox = "//input[@id='passwd']";
    private static String daysDropdown = "//select[@id='days']";
    private static String montsDropdown = "//select[@id='months']";
    private static String yearsDropdown = "//select[@id='years']";
    private static String newsletterCheckBox = "//input[@id='newsletter']";
    private static String compeneyTxtBox ="//input[@id='company']";
    private static String addressTxtBox = "//input[@id='address1']";
    private static String cityTxtBox = "//input[@id='city']";
    private static String stateDropdown = "//select[@id='id_state']";
    private static String postalTxtBox = "//input[@id='postcode']";
    private static String countryDropdown = "//select[@id='id_country']";
    private static String mobilePhoneTxtbox = "//input[@id='phone_mobile']";
    private static String addressAlias = " //input[@id='alias']";
    private static String registerButton = "//button[@id='submitAccount']//span";

    private static String accountNameverify ="/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span";


    private static FirefoxDriver driver;
    private static ChromeDriver  chromeDriver;
    private static OperaDriver  operaDriver;


    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "/opt/selenium/driver/geckodriver");
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //this meth is for withing to open browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void launchAndNavigateSignUP() {

        try {
            driver.get(URL);
            driver.findElement(By.xpath(signInButton)).click();
            Assert.assertEquals("AUTHENTICATION",
                    driver.findElement(By.xpath("//h1[@class='page-heading']")).getText());

            Assert.assertEquals("AUTHENTICATION",
                    driver.findElement(By.xpath("//h1[@class='page-heading']")).getText());
            clickandNavigetAcountCreate();
            enterSignUpDetails();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void clickandNavigetAcountCreate() {
        try {
            driver.findElement(By.xpath(emailTxtBox)).sendKeys("test"+System.currentTimeMillis()+"@gmail.com");
            driver.findElement(By.xpath(creatAccButton)).click();
            Thread.sleep(2000);
            Assert.assertEquals("CREATE AN ACCOUNT", driver.findElement(By.xpath(createAccPageHeader)).getText());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }


    public void enterSignUpDetails() throws Exception {
        driver.findElement(By.xpath(titleRadioBtn)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(fnameTxtBox)).sendKeys("Uva Wellassa University");
        Thread.sleep(3000);
        driver.findElement(By.xpath(lnameTxtBox)).sendKeys("Studens");
        //driver.findElement(By.xpath(signupEmailTxtBox)).sendKeys("test"+System.currentTimeMillis()+"@gmail.com");
        driver.findElement(By.xpath(passwordTxtBox)).sendKeys("testPassword");
        Thread.sleep(3000);
        Select date = new Select(driver.findElement(By.xpath(daysDropdown)));
        date.selectByValue("20");

        Select month = new Select(driver.findElement(By.xpath(montsDropdown)));
        //driver.findElement(By.xpath(montsDropdown)).click();
        month.selectByIndex(6);

        Select year = new Select(driver.findElement(By.xpath(yearsDropdown)));
        year.selectByValue("2000");

        driver.findElement(By.xpath(newsletterCheckBox)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(compeneyTxtBox)).sendKeys("WSO2.Telco");
        Thread.sleep(3000);
        driver.findElement(By.xpath(addressTxtBox)).sendKeys("00020 Mandadiyawaththa Bombuwala");
        Thread.sleep(3000);
        driver.findElement(By.xpath(cityTxtBox)).sendKeys("Kalutara");

        Thread.sleep(3000);
        Select state = new Select(driver.findElement(By.xpath(stateDropdown)));
        state.selectByIndex(10);

        driver.findElement(By.xpath(postalTxtBox)).sendKeys("10000");
        Thread.sleep(3000);
        Select country = new Select(driver.findElement(By.xpath(countryDropdown)));
        country.selectByIndex(1);

        driver.findElement(By.xpath(mobilePhoneTxtbox)).sendKeys("1234567890");
        Thread.sleep(3000);
        driver.findElement(By.xpath(addressAlias)).sendKeys("Wacanda forEver");
        Thread.sleep(3000);
        driver.findElement(By.xpath(registerButton)).click();
        Thread.sleep(3000);
        Assert.assertEquals("Uva Wellassa University Studens", driver.findElement(By.xpath(accountNameverify)).getText());
    }



    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }














}
