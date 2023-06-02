package is.demo.serenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnTarget;

import static is.demo.serenity.userInterfaces.ProductosUI.BTN_AGREGAR;

public class ProductosTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_AGREGAR)
        );
    }

    public static Performable clicAgregar() {
        return net.serenitybdd.screenplay.Tasks.instrumented(ProductosTask.class);
    }
}
