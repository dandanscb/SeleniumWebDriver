/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokuapp.internet;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author vitor
 */
public class MultipleWindows {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
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

        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        Iterator<String> iter = set.iterator();

        while (iter.hasNext()) {
            String childWindow = iter.next();

            if (!mainWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);

                Thread.sleep(3000);

                System.out.println(driver.switchTo().window(childWindow).getTitle());

                System.out.println("Closing Child Tab");
                driver.close();
            }
        }
        Thread.sleep(2000);
        driver.close();
    }
}
