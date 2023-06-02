package is.demo.serenity.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

        features = "src/test/resources/features/",
        glue = "is.demo.serenity.stepDefinitions",
        tags = "@AgregarProducto",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
    private static WebDriver driver;

    @Before
    public static void setup() {
        // Crear y configurar el objeto WebDriver
        driver = new ChromeDriver();

        // Ejecutar JavaScript para establecer el idioma en inglés
        ((JavascriptExecutor) driver).executeScript("document.documentElement.setAttribute('lang', 'en');");
    }
}
