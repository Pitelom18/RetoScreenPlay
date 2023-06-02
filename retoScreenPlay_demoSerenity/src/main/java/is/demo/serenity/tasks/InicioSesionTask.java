package is.demo.serenity.tasks;

import is.demo.serenity.utils.excel.ObtenerDataExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static is.demo.serenity.userInterfaces.InicioSesionUI.*;


public class InicioSesionTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        Object[][] credentials = ObtenerDataExcel.getCredentials("src/test/resources/data/ProductList.xlsx", "CredencialesIngreso");

        String usuario = (String) credentials[0][0];
        String contrasena = (String) credentials[0][1];

        actor.attemptsTo(
                Clear.field(TXT_USUARIO),
                Clear.field(TXT_CONTRASENA),
                Enter.theValue(usuario).into(TXT_USUARIO),
                Enter.theValue(contrasena).into(TXT_CONTRASENA),
                Click.on(BTN_INICIOSESION)
        );
    }
        public static Performable InicioSesionTask(){
            return  net.serenitybdd.screenplay.Tasks.instrumented(InicioSesionTask.class);
        }

    }

