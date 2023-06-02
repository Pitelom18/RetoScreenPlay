#language:es

Característica: Agregar un producto
  Como usuario
  quiero agregar un producto a la lista de productos
  Para poder tener un registro de los productos que tengo

  Antecedentes:
    Dado que abro la url y estoy en la pagina de inicio de sesion
    Cuando limpio los campos de usuario y contrasena
    Cuando diligencio el usuario y contrasena y doy click en el boton de iniciar sesion

    @AgregarProducto

    Escenario: Agregar un producto

        Cuando estando en la pagina de dashboard hago click en productos
        Y estando en la pagina de productos hago click en agregar producto
        Cuando diligencio el nombre del producto y demas campos obligatorios
        Y hago click en guardar
        Entonces veo el producto agregado en la lista de productos
