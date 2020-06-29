package herokuapp.formy;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import herokuapp.connection.ChromeConnection;

public class SwitchWindow {

    public void main() throws InterruptedException {
    	ChromeConnection chromeConnection = new ChromeConnection();
		WebDriver driver = chromeConnection.Connection();
        driver.get("http://formy-project.herokuapp.com/");

        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 1000);");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Switch Window")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"new-tab-button\"]")).click();
        Thread.sleep(2000);

        String mainWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        Iterator<String> iter = set.iterator();

        while (iter.hasNext()) {
            String childWindow = iter.next();

            if (!mainWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                Thread.sleep(3000);

                jse.executeScript("scroll(0, 1100);");
                Thread.sleep(2000);
                driver.close();
            }
        }

        Thread.sleep(5000);
        driver.switchTo().window(mainWindow);

        driver.findElement(By.xpath("//*[@id=\"alert-button\"]")).click();
        Thread.sleep(2000);

        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.close();

    }
}
