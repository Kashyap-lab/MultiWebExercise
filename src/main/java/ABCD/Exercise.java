package ABCD;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.wait.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class Exercise {
    static protected WebDriver driver;

    @Test
    public void AsdaWebRegisterSuccessfully() //User should able to register successfully on Asda Grocery.com
    {
        //public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\WebDrivers\\chromedriver.exe"); //source path for chromedriver
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizing the browser window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Time to wait to load the homepage
        driver.get("https://www.asda.com/register?redirect_uri=https://groceries.asda.com/?cmpid=ahc-_-ghs-_-asdacom-_-hp-_-nav-_-ghs&request_origin=gi");
        //driver.findElement(By.linkText("btnRegister")).click();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kashyup.shah999@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Kashyap123");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("HA9 0AB");
        driver.findElement(By.xpath("//label[@class='regCheckTnC check-box']//span[@class='checkmark']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click(); //able to login successfully but cannot automate the capcha
    }

    @Test
    public void OcadoRegistration()//User should able to register successfully on Ocado website
    {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ocado.com/webshop/startWebshop.do");
        driver.findElement(By.id("quickReg")).click();
        WebDriverWait wait = new WebDriverWait(driver, 40);
        // wait.until(ExpectedConditions.elementToBeClickable(By.id("registration-submit-button")));
        Select select = new Select(driver.findElement(By.tagName("select")));
        select.selectByVisibleText("Mr");
        driver.findElement(By.id("firstName")).sendKeys("Kashyap");
        driver.findElement(By.id("lastName")).sendKeys("shah");
        driver.findElement(By.id("login")).sendKeys("kashyup.shah999@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123Kashyap");
        driver.findElement(By.id("postcode")).sendKeys("HA9 0AB");
        driver.findElement(By.id("registration-submit-button")).click(); //able to login successfully
    }

    @Test
    public void OrangeHrm() //User should able to register successfully on OrangeHRM website
    {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\WebDrivers\\chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin"); // Data Provided by customer
        driver.findElement(By.id("txtPassword")).sendKeys("admin123"); // Data provided by customer
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click(); //User is able to login successfully
    }

    @Test
    public void Uber() //User should able to register successfully on Uber Rider website
    {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\WebDrivers\\chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.uber.com/gb/en/");
        try {
            Thread.sleep(2000); // System will go on sleep mode to allow loading the homepage(very Slow)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"/signup/\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/header/div[2]/div/div/div/div/div[7]/div/div[2]/a")).click();
        driver.findElement(By.id("firstName")).sendKeys("Uber");
        driver.findElement(By.id("lastName")).sendKeys("Rider");
        driver.findElement(By.id("mobile")).sendKeys("012345678999");
        driver.findElement(By.id("email")).sendKeys("uber@rider.com");
        driver.findElement(By.id("addPassword")).sendKeys("uber123");
        driver.findElement(By.xpath("//button[@type='submit']")).click(); //User is able to Register successfully
    }

    @Test
    public void MockPlus() //User should able to register successfully on MuckPlus
    {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mockplus.com/");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.className("user-btn")).click();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("password")).sendKeys("test123");
        driver.findElement(By.id("cofPassword")).sendKeys("test123");
        driver.findElement(By.id("agree")).click();
        driver.findElement(By.id("register")).click(); //Register Successfully
    }

}

