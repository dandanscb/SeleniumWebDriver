/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokuapp.formy;

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
public class PageScroll {
    
    public void main() throws InterruptedException {
    	ChromeConnection chromeConnection = new ChromeConnection();
		WebDriver driver = chromeConnection.Connection();
        driver.get("http://formy-project.herokuapp.com/");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 650);");
        Thread.sleep(3000);
        
        driver.findElement(By.linkText("Page Scroll")).click();
        Thread.sleep(3000);
        
        jse.executeScript("scroll(0, 1000);");
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Daniel doentao");
        Thread.sleep(2000);
        name = driver.findElement(By.id("date"));
        Thread.sleep(1000);
        name.sendKeys("27/05/2019");
        
        Thread.sleep(3000);
        driver.close();
    }
}
