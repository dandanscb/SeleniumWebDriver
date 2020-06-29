package herokuapp.formy;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import herokuapp.connection.ChromeConnection;

public class CompleteWebForm {

    public void main() throws InterruptedException {
    	ChromeConnection chromeConnection = new ChromeConnection();
		WebDriver driver = chromeConnection.Connection();
        driver.get("http://formy-project.herokuapp.com/");

        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 1000);");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Complete Web Form")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Daniel");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Escobar");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"job-title\"]")).sendKeys("Estudante");
        Thread.sleep(500);

        /*for(int i = 1; i < 4; i++) {
        	WebElement radioButtons = driver.findElement(By.xpath("//*[@id=\"radio-button-"+i+"\"]"));
            radioButtons.click();
            Thread.sleep(500);	
        }*/
        driver.findElement(By.xpath("//*[@id=\"radio-button-2\"]")).click();
        Thread.sleep(500);

        jse.executeScript("scroll(0, 300);");

        Thread.sleep(2500);

        for (int i = 1; i < 6; i++) {
            if (i > 3) {
                WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"checkbox-" + (i - 3) + "\"]"));
                checkbox.click();
                Thread.sleep(1000);
            } else {
                WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"checkbox-" + i + "\"]"));
                checkbox.click();
                Thread.sleep(1000);
            }
        }

        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"select-menu\"]")));
        select.selectByVisibleText("5-9");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
        Thread.sleep(3000);

        /*for(int i = 0; i < 3; i++) {
        	driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[2]/th[2]")).click();
            Thread.sleep(3000);
        }*/
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[2]/th[2]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/thead/tr[2]/th[2]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/div[4]/table/tbody/tr/td/span[1]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr/td/span[8]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[4]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[3]/td[4]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();
        Thread.sleep(3000);

        driver.close();

    }

}
