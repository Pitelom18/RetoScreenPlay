package is.demo.serenity.tasks;

import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static is.demo.serenity.userInterfaces.DashboardUI.BTN_PRODUCTOS;

public class DashboardTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_PRODUCTOS)
        );

    }

    public static Performable clicProductos() {
        return net.serenitybdd.screenplay.Tasks.instrumented(DashboardTask.class);

    }
}