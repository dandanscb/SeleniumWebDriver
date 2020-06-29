/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokuapp.formy;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import herokuapp.connection.ChromeConnection;

/**
 *
 * @author vitor
 */
public class Datepicker {

    public void main() throws InterruptedException {
    	ChromeConnection chromeConnection = new ChromeConnection();
		WebDriver driver = chromeConnection.Connection();
        driver.get("http://formy-project.herokuapp.com/");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Datepicker")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='text']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//th[@class='next']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//th[@class='next']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//td[contains(text(),'6')]")).click();

        Thread.sleep(3000);
        driver.close();

    }
}
