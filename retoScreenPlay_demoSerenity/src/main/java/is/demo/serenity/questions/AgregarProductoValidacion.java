package is.demo.serenity.questions;

import is.demo.serenity.userInterfaces.ProductosUI;
import is.demo.serenity.utils.excel.EsperaImplicita;
import is.demo.serenity.utils.excel.ObtenerDataExcel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.util.List;



public class AgregarProductoValidacion implements Question<Boolean> {
    private String nombreProducto;

    public AgregarProductoValidacion(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        EsperaImplicita.esperaImplicita(5);
        List<WebElementFacade> productosUI = ProductosUI.LST_PRODUCTOS.resolveAllFor(actor);
        for(WebElementFacade productos : productosUI){
            System.out.println("Nombre productos : " + productos.getText());
            System.out.println("Nombre excel :" +nombreProducto);
            if(productos.getText().equals(nombreProducto))
                return true;
        }

        return false;
    }

    private boolean validarProductoEnExcel(Object[][] productosExcel, String nombreProducto) {
        DataFormatter formatter = new DataFormatter();
        for (Object[] fila : productosExcel) {
            for (Object dato : fila) {
                String valor = String.valueOf(dato);
                if (valor.equalsIgnoreCase(nombreProducto)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean validarProductoEnUI(List<WebElementFacade> productosUI, String nombreProducto) {
        for (WebElementFacade producto : productosUI) {
            String nombre = producto.getText();
            if (nombre.equalsIgnoreCase(nombreProducto)) {
                return true;
            }
        }
        return false;
    }

    public static AgregarProductoValidacion validacionProducto(String nombreProducto) {
        return new AgregarProductoValidacion(nombreProducto);
    }
}
