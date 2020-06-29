package herokuapp.internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {

    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "D:\\Selenium Environment\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
//Create an object 'action'
        Actions action = new Actions(driver);
       
        //navigate to the required url where we could do drag and drop action
        driver.get("https://the-internet.herokuapp.com/");
        
//sempre maximizar a pagina pois pode dar erro ao 
        //usar o comando findBy e o campo não estiver
        //aparecendo na tela
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop')]")).click();

        //WebdriverWait is used to wait for a frame to be available. Once it is availble we switch to the frame to achieve our task 
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@id='content']")));
        //To get source locator
        WebElement sourceLocator = driver.findElement(By.cssSelector("#column-a"));
        //To get target locator
        WebElement targetLocator = driver.findElement(By.cssSelector("#column-b"));
        //dragAndDrop(source, target) method accepts two parameters source and locator. 
        //used dragAndDrop method to drag and drop the source locator to target locator
        action.dragAndDrop(sourceLocator, targetLocator).build().perform();
    }
}
