/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokuapp.formy;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import herokuapp.connection.ChromeConnection;

/**
 *
 * @author vitor
 */
public class RadioButtons {

    public void main() throws InterruptedException {
    	ChromeConnection chromeConnection = new ChromeConnection();
		WebDriver driver = chromeConnection.Connection();
        driver.get("http://formy-project.herokuapp.com/");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 1000);");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Radio Button")).click();
        Thread.sleep(2000);

        List<WebElement> radioButtons = driver.findElements(By.xpath("//div//input[@class='form-check-input']"));
        System.out.println("Total Radio Buttons: " + radioButtons.size());

        for (int i = 0; i < radioButtons.size(); i++) {
            radioButtons.get(i).click();
            Thread.sleep(2000);
        }

        Thread.sleep(3000);
        driver.close();
    }
}
