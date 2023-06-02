package is.demo.serenity.stepDefinitions;

import io.cucumber.java.es.*;

import is.demo.serenity.questions.AgregarProductoValidacion;
import is.demo.serenity.tasks.DashboardTask;
import is.demo.serenity.tasks.ProductosTask;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import org.hamcrest.Matchers;

import static is.demo.serenity.userInterfaces.NuevoProductoUI.*;
import static is.demo.serenity.userInterfaces.NuevoProductoUI.TXT_NIVELREORDENAMIENTO;
import static is.demo.serenity.userInterfaces.ProductosUI.TXT_BUSCAR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class AgregarProductoStepDefinitions {
    private String nombreProducto;
    @Cuando("estando en la pagina de dashboard hago click en productos")
    public void estandoEnLaPaginaDeDashboardHagoClickEnProductos() {
        theActorInTheSpotlight().attemptsTo(
                DashboardTask.clicProductos()
        );

    }
    @Cuando("estando en la pagina de productos hago click en agregar producto")
    public void estandoEnLaPaginaDeProductosHagoClickEnAgregarProducto() {
        theActorInTheSpotlight().attemptsTo(
                ProductosTask.clicAgregar()
        );

    }
    @Cuando("diligencio el nombre del producto y demas campos obligatorios")
    public void diligencioElNombreDelProductoYDemasCamposObligatorios() {
        nombreProducto = "producto Natalia Tellez";
        theActorInTheSpotlight().attemptsTo(

            Enter.theValue(nombreProducto).into(TXT_NOMBREPRODUCTO),
            Enter.theValue(String.valueOf(1)).into(TXT_UNIDADESDISPONIBLES),
            Enter.theValue(String.valueOf(1)).into(TXT_UNIDADESORDENADAS),
            Enter.theValue(String.valueOf(1)).into(TXT_NIVELREORDENAMIENTO));

    }
    @Cuando("hago click en guardar")
    public void hagoClickEnGuardar() {
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(LBL_TITULO),
                Click.on(BTN_GUARDAR),
                Enter.theValue(nombreProducto).into(TXT_BUSCAR)
        );
    }
    @Entonces("veo el producto agregado en la lista de productos")
    public void veoElProductoAgregadoEnLaListaDeProductos() {
        theActorInTheSpotlight().should(
                seeThat("El producto fue agregado",
                        AgregarProductoValidacion.validacionProducto(nombreProducto),
                        Matchers.equalTo(true))
        );
    }

}
