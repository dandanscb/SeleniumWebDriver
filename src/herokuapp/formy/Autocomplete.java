/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokuapp.formy;

import java.io.File;

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
public class Autocomplete {

	public void main() throws InterruptedException {

		ChromeConnection chromeConnection = new ChromeConnection();
		WebDriver driver = chromeConnection.Connection();
        driver.get("http://formy-project.herokuapp.com/");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Autocomplete")).click();

        Thread.sleep(3000);

        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("Rua Adolfo Engel");
        
        Thread.sleep(2000);
        autocomplete.sendKeys(Keys.DOWN);
        autocomplete.sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        driver.close();
    }
}
