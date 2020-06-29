/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokuapp.internet;

import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author vitor
 */
public class AddRemoveButtons {

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitor\\Documents\\NetBeansProjects\\chromedriver.exe"); // set driver path
        WebElement searchBox;
        Scanner input = new Scanner(System.in);
        System.out.print("How many buttons do you want to add? ");
        int buttons = input.nextInt();

        //acessando google.com
        driver.get("https://the-internet.herokuapp.com/");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),'Add/Remove Elements')]")).click();
        Thread.sleep(2000);

        for (int i = 0; i < buttons; i++) {
            driver.findElement(By.xpath("//button[contains(text(),'Add Element')]")).click();
            Thread.sleep(1000);
        }

        for (int i = 0; i < buttons; i++) {
            driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
            Thread.sleep(1000);
        }

        driver.close();
    }
}
