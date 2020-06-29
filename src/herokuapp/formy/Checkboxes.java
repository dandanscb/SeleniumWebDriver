/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokuapp.formy;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import herokuapp.connection.ChromeConnection;

/**
 *
 * @author vitor
 */
public class Checkboxes {

    public void main() throws InterruptedException {
    	ChromeConnection chromeConnection = new ChromeConnection();
		WebDriver driver = chromeConnection.Connection();
        driver.get("http://formy-project.herokuapp.com/");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Checkbox")).click();

        Thread.sleep(3000);
        
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("Total checkboxes: " + checkBoxList.size());

        for (int i = 0; i < checkBoxList.size(); i++) {
            if (!checkBoxList.get(i).isSelected()) {
                Thread.sleep(2000);
                checkBoxList.get(i).click();
            } else {
                Thread.sleep(2000);
                checkBoxList.get(i).click();
            }
        }

        Thread.sleep(3000);
        driver.close();
    }
}
