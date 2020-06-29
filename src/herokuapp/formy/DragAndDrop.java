package herokuapp.formy;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import herokuapp.connection.ChromeConnection;

public class DragAndDrop {

    public void main() throws InterruptedException {
    	ChromeConnection chromeConnection = new ChromeConnection();
		WebDriver driver = chromeConnection.Connection();
        driver.get("http://formy-project.herokuapp.com/");

        //sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Drag and Drop")).click();
        Thread.sleep(2000);

        //form-group row
        WebElement image = driver.findElement(By.cssSelector("#image"));

        WebElement box = driver.findElement(By.cssSelector("#box"));

        Thread.sleep(2000);

        // TODO Verify because apparently it is dragging to a position below the target.
        Actions actions = new Actions(driver);

        actions.dragAndDrop(image, box).build().perform();

        Thread.sleep(3000);

        driver.close();
    }
}
