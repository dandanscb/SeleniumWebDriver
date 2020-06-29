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
public class DisappearingElements {

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
        driver.findElement(By.xpath("//a[contains(text(),'Disappearing Elements')]")).click();

        List<WebElement> menus = driver.findElements(By.tagName("a"));
        System.out.println("Total checkboxes: " + menus.size());

        for (int i = 2; i < menus.size()-1; i++) {
            menus.get(i).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

            List<WebElement> menus2 = driver.findElements(By.tagName("a"));
            if (menus2.size() < menus.size()) {
                System.out.println("A menu disappeared");
                driver.close();
            }
        }
        driver.close();
    }
}
