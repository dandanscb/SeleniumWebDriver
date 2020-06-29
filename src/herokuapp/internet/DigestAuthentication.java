package herokuapp.internet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author vitor
 */
public class DigestAuthentication {

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        WebDriver driver = new ChromeDriver();
        
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitor\\Documents\\NetBeansProjects\\chromedriver.exe"); // set driver path

        //acessando google.com
        driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.close();
    }
}
