package is.demo.serenity.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InicioSesionUI {
    public static final Target TXT_USUARIO = Target.the("Usuario")
            .locatedBy("#LoginPanel0_Username");

    public static final Target TXT_CONTRASENA = Target.the("Contrasena")
            .locatedBy("#LoginPanel0_Password");

    public static final Target BTN_INICIOSESION = Target.the("Boton de inicio de sesion")
            .locatedBy("#LoginPanel0_LoginButton");
}
