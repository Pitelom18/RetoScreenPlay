package is.demo.serenity.tasks;


import is.demo.serenity.interactions.ScrollInteractions;
import is.demo.serenity.utils.excel.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import is.demo.serenity.utils.excel.EscribirDataExcel;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.WebElement;


import static is.demo.serenity.userInterfaces.NuevoProductoUI.*;
import static is.demo.serenity.userInterfaces.ProductosUI.TXT_BUSCAR;

public class NuevoProductoTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        String nombreProducto = TXT_NOMBREPRODUCTO.resolveFor(actor).getText();
        int unidadesDisponibles = Integer.parseInt(TXT_UNIDADESDISPONIBLES.resolveFor(actor).getTextValue());
        int unidadesEnOrden = Integer.parseInt(TXT_UNIDADESORDENADAS.resolveFor(actor).getTextValue());
        int nivelReorden = Integer.parseInt(TXT_NIVELREORDENAMIENTO.resolveFor(actor).getTextValue());

        Product producto = new Product(nombreProducto, unidadesDisponibles, unidadesEnOrden, nivelReorden);

        EscribirDataExcel.addNewProduct("src/test/resources/data/ProductList.xlsx", "ListaProductosCopia", producto);
        actor.attemptsTo(
            Enter.theValue(Product.getProductName()).into(TXT_NOMBREPRODUCTO),
            Enter.theValue(String.valueOf(Product.getUnitsInStock())).into(TXT_UNIDADESDISPONIBLES),
            Enter.theValue(String.valueOf(Product.getUnitsOnOrder())).into(TXT_UNIDADESORDENADAS),
            Enter.theValue(String.valueOf(Product.getReorderLevel())).into(TXT_NIVELREORDENAMIENTO),
            Scroll.to(LBL_TITULO),
            ScrollInteractions.scrollToElement((WebElement) LBL_TITULO),
            Click.on(BTN_GUARDAR),
                Enter.theValue(nombreProducto).into(TXT_BUSCAR)


        );


    }
    public static Performable agregarNuevoProducto(){
        return  net.serenitybdd.screenplay.Tasks.instrumented(NuevoProductoTask.class);
    }
}
