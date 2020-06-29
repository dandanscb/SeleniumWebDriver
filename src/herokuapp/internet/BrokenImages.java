/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokuapp.internet;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author vitor
 */
public class BrokenImages {
    
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitor\\Documents\\NetBeansProjects\\chromedriver.exe"); // set driver path

        //acessando google.com
        driver.get("https://the-internet.herokuapp.com/");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//a[contains(text(),'Broken Images')]")).click();
        Thread.sleep(2000);
        
        List<WebElement> links = driver.findElements(By.tagName("img"));
        System.out.println("Total images: " + links.size());
        
        for (int i = 0; i < links.size(); i++) {
            WebElement ele = links.get(i);
            
            if (ele.getAttribute("naturalWidth").equals("0")) {
                System.out.println("The image with url " + ele.getAttribute("src") + " is broken");
            }
        }
        
        driver.close();
    }
}
