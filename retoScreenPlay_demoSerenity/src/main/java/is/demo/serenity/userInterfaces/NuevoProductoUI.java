package is.demo.serenity.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class NuevoProductoUI {
    public static final Target LBL_TITULO = Target.the("Titulo de la pagina")
            .locatedBy("#ui-id-1");

    public static final Target TXT_NOMBREPRODUCTO = Target.the("Nombre del producto")
            .locatedBy("//input[@id='Serenity_Demo_Northwind_ProductDialog9_ProductName']");

    public static final Target TXT_UNIDADESDISPONIBLES = Target.the("Unidades disponibles")
            .locatedBy("#Serenity_Demo_Northwind_ProductDialog9_UnitsInStock");

    public static final Target TXT_UNIDADESORDENADAS = Target.the("Unidades ordenadas")
            .locatedBy("#Serenity_Demo_Northwind_ProductDialog9_UnitsOnOrder");

    public static final Target TXT_NIVELREORDENAMIENTO = Target.the("Nivel de reordenamiento")
            .locatedBy("#Serenity_Demo_Northwind_ProductDialog9_ReorderLevel");

    public static final Target BTN_GUARDAR = Target.the("Boton de guardar")
            .locatedBy("//div[@class='tool-button save-and-close-button icon-tool-button']");
}
