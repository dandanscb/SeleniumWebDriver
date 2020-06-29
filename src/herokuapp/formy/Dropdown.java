/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokuapp.formy;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import herokuapp.connection.ChromeConnection;

/**
 *
 * @author vitor
 */
public class Dropdown {

    public void main() throws InterruptedException {
    	ChromeConnection chromeConnection = new ChromeConnection();
		WebDriver driver = chromeConnection.Connection();
        driver.get("http://formy-project.herokuapp.com/");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Dropdown")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("dropdownMenuButton")).click();
        Thread.sleep(1000);

        List<WebElement> dropdownItens = driver.findElements(By.xpath("//div[@class='dropdown show']//*[@class=\"dropdown-item\"]"));
        System.out.println(dropdownItens.size());

        for (int i = 0; i < dropdownItens.size(); i++) {
            dropdownItens.get(i).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.findElement(By.id("dropdownMenuButton")).click();
            Thread.sleep(2000);
            dropdownItens = driver.findElements(By.xpath("//div[@class='dropdown show']//*[@class=\"dropdown-item\"]"));

        }

        Thread.sleep(3000);
        driver.close();

    }
}
