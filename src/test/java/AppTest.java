

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by Harshala on 28/10/2017.
 */

public class AppTest {

    @Test
    public void verifyGoogleAutoComplete() {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "src/test/browserFiles/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.co.uk/");
        //driver.navigate().to("https://www.google.co.uk/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Now, navigated to url: "+driver.getCurrentUrl());

        //Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Google Search'][@type='submit']")).isDisplayed());

        Assert.assertEquals("Google",driver.getTitle());
        System.out.println("Page title also verified by Assert. ");

        WebElement searchBox= driver.findElement(By.xpath("//input[@id='lst-ib']"));
        System.out.println("searchBox.isDisplayed(): "+searchBox.isDisplayed());
        searchBox.sendKeys("Seleni");

        System.out.println("search value: "+searchBox.getAttribute("value"));
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sbqs_c']")));

        List<WebElement> autoTextList = driver.findElements(By.xpath("//div[@class='sbqs_c']"));

        System.out.println("List size: "+autoTextList.size());
        for(WebElement listItem : autoTextList){
            System.out.println("List item: "+listItem.getText());
            if(listItem.getText().equals("selenium webdriver")) {
                listItem.click();
                break;
            }
        }

        driver.close();
    }

}
