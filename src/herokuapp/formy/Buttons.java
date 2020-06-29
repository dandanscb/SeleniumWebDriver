/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokuapp.formy;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import herokuapp.connection.ChromeConnection;

/**
 *
 * @author vitor
 */
public class Buttons {

    public void main() throws InterruptedException {
    	ChromeConnection chromeConnection = new ChromeConnection();
		WebDriver driver = chromeConnection.Connection();
        driver.get("http://formy-project.herokuapp.com/");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Buttons")).click();
        Thread.sleep(2000);

        List<WebElement> buttonList = driver.findElements(By.xpath("//button[@type='button']"));
        System.out.println("Total buttons: " + buttonList.size());

        for (int i = 1; i < buttonList.size(); i++) {
            buttonList.get(i).click();
            Thread.sleep(1000);
            if (i == buttonList.size() - 1) {
                buttonList.get(i).sendKeys(Keys.TAB);
                buttonList.get(i).sendKeys(Keys.TAB);
                Thread.sleep(2000);
                buttonList.get(i).sendKeys(Keys.ENTER);

                Thread.sleep(1000);
                buttonList.get(i).click();
                buttonList.get(i).sendKeys(Keys.TAB);
                Thread.sleep(2000);
                buttonList.get(i).sendKeys(Keys.ENTER);
            }
        }

        Thread.sleep(3000);
        driver.close();
    }
}
