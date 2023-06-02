package is.demo.serenity.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductosUI {
    public static final Target BTN_AGREGAR = Target.the("Boton de agregar")
            .locatedBy("//div[@class='tool-button add-button icon-tool-button']");

    public static final Target TXT_BUSCAR = Target.the("Campo de busqueda")
            .locatedBy("//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']");

    public static final Target LST_PRODUCTOS = Target.the("Lista de productos")
            .locatedBy("//div[@class='slick-cell l1 r1']/a");
}
