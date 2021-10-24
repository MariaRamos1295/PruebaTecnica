import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Caso4_6 {
    public static void  main(String [] args ) {
        System.setProperty("webdriver.chrome.driver", "src\\Driver\\chromedriver.exe");

        //Iniciar el webdriver
        WebDriver driver = new ChromeDriver();

        //Abrir el sitio web
        driver.get("http://automationpractice.com/index.php");

        //Maximizar ventana
        driver.manage().window().maximize();

        //Credenciales
        String username = "mariabramos95@gmail.com";
        String password = "123456789";

        //Dar clic en el boton Sign In
        WebElement SignInBoton = driver.findElement(By.className("login"));
        SignInBoton.click();

        //Ingresar Credenciales De Inicio Sesion
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement SignBoton = driver.findElement(By.id("SubmitLogin"));

        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        SignBoton.click();

        //-----------Proceso de compra--------------------//

        //ir pagina de inicio
        WebElement logo = driver.findElement(By.id("header_logo"));
        logo.click();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,525)");

        //Colocar el cursor en el producto
        WebElement cursor =driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div"));

        Actions action = new Actions(driver);
        action.moveToElement(cursor).perform();

        //Agregar al Carro de compras
        WebElement addtocart = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[2]"));
        addtocart.click();

        //continuar con la compra
        js.executeScript("window.scrollBy(0,150)");
        WebElement layer = driver.findElement(By.name("Submit"));
        layer.click();
        driver.navigate().refresh();

        WebElement carro = driver.findElement(By.className("shopping_cart"));
        carro.click();



    }
}
