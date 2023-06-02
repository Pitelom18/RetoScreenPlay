package is.demo.serenity.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollInteractions implements Interaction {

    private WebElement element;

    public ScrollInteractions(WebElement element) {
        this.element = element;
    }

    public static ScrollInteractions scrollToElement(WebElement element) {
        return Tasks.instrumented(ScrollInteractions.class, element);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static Performable scroll(WebElement element){
        return Tasks.instrumented(ScrollInteractions.class, element);
    }
}
