package is.demo.serenity.stepDefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import is.demo.serenity.questions.InicioSesionValidacion;
import is.demo.serenity.utils.excel.ObtenerDataExcel;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;


import static is.demo.serenity.userInterfaces.InicioSesionUI.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;


public class InicioSesionStepDefinitions {

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());

    }

    @Dado("que abro la url y estoy en la pagina de inicio de sesion")
    public void queAbroLaUrlYEstoyEnLaPaginaDeInicioDeSesion() {
        theActorCalled("Usuario").wasAbleTo(
                Open.url("https://demo.serenity.is/")
        );

    }
    @Cuando("limpio los campos de usuario y contrasena")
    public void limpioLosCamposDeUsuarioYContrasena() {
        theActorInTheSpotlight().attemptsTo(
                Clear.field(TXT_USUARIO),
                Clear.field(TXT_CONTRASENA)
        );

    }
    @Cuando("diligencio el usuario y contrasena y doy click en el boton de iniciar sesion")
    public void diligencioElUsuarioYContrasenaYDoyClickEnElBotonDeIniciarSesion() {
        Object[][] credentials = ObtenerDataExcel.getCredentials("src/test/resources/data/ProductList.xlsx", "CredencialesIngreso");

        String usuario = (String) credentials[0][0];
        String contrasena = (String) credentials[0][1];
        theActorInTheSpotlight().attemptsTo(

                Enter.theValue(usuario).into(TXT_USUARIO),
                Enter.theValue(contrasena).into(TXT_CONTRASENA),
                Click.on(BTN_INICIOSESION)
        );


    }
    @Entonces("debo ver la pagina de dashboard")
    public void deboVerLaPaginaDeDashboard() {
        theActorInTheSpotlight().should(seeThat(InicioSesionValidacion.inicioSesionValidacion(),
                Matchers.equalTo(true)));

    }


}
