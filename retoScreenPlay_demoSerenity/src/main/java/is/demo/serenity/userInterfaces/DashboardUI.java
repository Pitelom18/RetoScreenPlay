package is.demo.serenity.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

public class DashboardUI {

    public static final Target LBL_TITULO = Target.the("Titulo de la pagina")
            .locatedBy("//h1")
            .waitingForNoMoreThan(Duration.ofSeconds(10))
            ;

    public static final Target BTN_PRODUCTOS= Target.the("Boton de productos")
            .locatedBy("//a[@href='/Northwind/Product' and contains(@class, 'card-footer')]");
}
