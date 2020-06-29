/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author vitor
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        // TODO code application logic here
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitor\\Documents\\NetBeansProjects\\chromedriver.exe"); // set driver path
        WebElement searchBox;
//
//        //pegando codigo html do site
//        String html = driver.getPageSource();
//        System.out.println(html);

        //acessando google.com
        driver.get("https://google.com");
        
        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        
        //digitando e pesquisando algo no campo de pesquisa
        searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium Web Driver");
        searchBox.submit();
        
        //Mudando para a aba 'Vídeos'
        driver.findElement(By.linkText("Vídeos")).click();
        
        //dormindo a thread antes de mudar para outro site
        Thread.sleep(4000);

        //acessando globoesporte.globo.com
        driver.get("https://globoesporte.globo.com");
        driver.manage().window().maximize();

        //digitando e pesquisando algo no campo de pesquisa
        searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Santos");
        searchBox.submit();
        
        //clicando no link da pagina
        driver.findElement(By.linkText("santos")).click();
        
        //atualizando a pagina
        driver.navigate().refresh();

        //colocando a thread pra dormir 5s antes de fechar
        Thread.sleep(5000);

        driver.quit();
    }
}
