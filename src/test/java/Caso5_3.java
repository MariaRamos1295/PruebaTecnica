import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Caso5_3 {
    public static void  main(String [] args ) {
        System.setProperty("webdriver.chrome.driver", "src\\Driver\\chromedriver.exe");

        //Iniciar el webdriver
        WebDriver driver = new ChromeDriver();

        //Abrir el sitio web
        driver.get("http://automationpractice.com/index.php");

        //Maximizar ventana
        driver.manage().window().maximize();

        //Colocar el cursor en el producto
        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,650)");

        WebElement cursor =driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(cursor).perform();
        cursor.click();
    }
}
