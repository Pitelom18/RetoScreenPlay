package is.demo.serenity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import static is.demo.serenity.userInterfaces.DashboardUI.LBL_TITULO;

public class InicioSesionValidacion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        String tituloDashboard = LBL_TITULO.resolveFor(actor).getText();
        return tituloDashboard.equals("Tablero");
    }

    public static InicioSesionValidacion inicioSesionValidacion() {
        return new InicioSesionValidacion();
    }
}
