package is.demo.serenity.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;

public class ElementoNoClickable implements Interaction {
    private Target target;

    public void ElementoNoClickable(Target target) {
        this.target = target;
    }

    public static ElementoNoClickable on(Target target) {
        return Tasks.instrumented(ElementoNoClickable.class, target);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MoveMouse.to(target),
                Click.on(target)
        );
    }
    public static Performable elementoNoClickable(Target target){
        return Tasks.instrumented(ElementoNoClickable.class, target);
    }
}
