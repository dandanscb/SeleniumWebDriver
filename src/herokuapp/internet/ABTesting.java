/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokuapp.internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author vitor
 */
public class ABTesting{
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitor\\Documents\\NetBeansProjects\\chromedriver.exe"); // set driver path
        WebElement searchBox;

        //acessando google.com
        driver.get("https://the-internet.herokuapp.com/");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]")).click();
        Thread.sleep(2000);
        driver.close();
    }
}
