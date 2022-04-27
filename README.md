# Desarrollo_Software
Ciclo 3 UEB MINTIC Desarrollo de Software (Java y Spring Boot)

**PROYECTO DE SOFTWARE PARA GESTIONAR TRANSACCIONES COMERCIALES DE UNA TIENDA GENÉRICA**

Dentro de los diferentes tipos de negocios que se pueden presentar en la economía de cualquier ciudad o país, existen aquellos que compran a sus proveedores diferentes productos o insumos que, con estos pueden producir los productos que venden a sus clientes a los que se les genera una factura de venta, y estos realizan los pagos de diferentes formas. Este tipo de negocio lo llamaremos en lo sucesivo “tienda genérica”, y en ese sentido, EL EQUIPO realizará el desarrollo de tal forma que pueda implementarse en todos los tipos de negocios que operen bajo esta modalidad, cumpliendo los requerimientos que abajo se detallan.

Se identifica a continuación los requerimientos para la realización del software, consistente en los siguientes módulos y requerimientos por módulo:

**1. MÓDULO DE LOGIN DEL SISTEMA**
EL EQUIPO deberá desarrollar el módulo que permita el ingreso al sistema, una vez se haya realizado la validación por nombre de usuario y contraseña. Deberá tenerse un usuario por defecto con el nombre de admininicial, y contraseña admin123456 para su ingreso la primera vez.

**2. MÓDULO DE GESTIÓN DE USUARIOS**
EL EQUIPO deberá desarrollar el módulo de gestión de los usuarios que trabajen en la tienda para que operen el sistema. Se deberán tener las opciones de crear usuario, actualizar datos de usuario, y borrar usuario. Estos datos se almacenarán en la tabla llamada usuarios, y los datos a gestionar son: cedula, nombre completo, correo electrónico, usuario, y contraseña. En este módulo se desactivará el usuario adminicial.

**3. MÓDULO DE GESTIÓN DE CLIENTES**
EL EQUIPO deberá desarrollar el módulo de gestión de los clientes de la tienda, para lo cual se deberán tener las opciones de crear cliente, leer clientes, actualizar datos de cliente, y borrar cliente. Estos datos se almacenarán en la tabla llamada clientes, y los datos a gestionar son: cedula, nombre completo, dirección, teléfono, y correo electrónico.

**4. MÓDULO DE GESTIÓN DE PROVEEDORES**
EL EQUIPO deberá desarrollar el módulo de gestión de los proveedores de la tienda, para lo cual se deberán tener las opciones de crear proveedor, leer proveedor, actualizar datos de proveedor, y borrar proveedor. Estos datos se almacenarán en una tabla llamada proveedores, y los datos a gestionar son: NIT, nombre proveedor, dirección, teléfono, y ciudad.

**5. MÓDULO DE GESTIÓN DE PRODUCTOS**
EL EQUIPO deberá desarrollar el módulo de gestión de los productos que se venden en la tienda, para lo cual se deberá cargar estos productos de un archivo plano (de texto).

**6. MÓDULO DE GESTIÓN DE VENTAS**
EL EQUIPO deberá desarrollar el módulo de gestión de las ventas que se realicen en la tienda. El sistema, buscará los datos del cliente por cédula. Posteriormente, el sistema permitirá escribir el código del producto, y se visualizará el nombre de este en pantalla. Se digitará la cantidad a vender, y generará el valor total de venta por producto. El sistema permitirá que se realice la misma operación con otros productos hasta que se le dé la opción de totalizar. En ese momento, el sistema calculará el valor del total de IVA para tres (3) productos, según el valor de IVA definido para cada producto, y luego dará el valor total con IVA.
El sistema deberá registrar la venta con los siguientes datos: código de venta – este es un valor consecutivo, cedula del cliente, cedula del usuario, valor total de venta, valor de IVA, y valor total más IVA en una tabla llamada ventas. Deberá, además, guardar en una tabla llamada detalleVentas el detalle de los productos vendidos de esta venta con los siguientes datos: código de producto, cantidad, valor unitario (valor de venta), y valor total, junto con el código de la venta. Finalmente, el sistema deberá mostrar un mensaje de confirmación de la transacción.

**7. MÓDULO DE CONSULTAS Y REPORTES**
EL EQUIPO desarrollará el módulo de consultas del sistema, el cual deberá poder generar las siguientes como mínimo: a) listado de usuarios, b) listado de clientes, y, c) total de ventas por cliente. Las consultas deberán ser por pantalla.
