#language:es

  Característica: Iniciar Sesion
    Como usuario
    quiero iniciar sesion en la aplicacion
    para acceder a los recursos protegidos


    @InicioSesion

    Escenario: Iniciar sesion con datos correctos
      Dado que abro la url y estoy en la pagina de inicio de sesion
      Cuando limpio los campos de usuario y contrasena
      Cuando diligencio el usuario y contrasena y doy click en el boton de iniciar sesion
      Entonces debo ver la pagina de dashboard