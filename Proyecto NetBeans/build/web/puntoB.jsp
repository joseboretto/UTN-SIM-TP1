<%-- 
    Document   : puntoA
    Created on : Mar 24, 2016, 4:16:57 PM
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PuntoB</h1>
        <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            
        <form method="post" action="${pageContext.request.contextPath}/TestGenernadorLenguaje" name="datos">
        
        Cantidad de Numeros a Generar:
        <input name="cantidadNumeros" value="" type="number">
        <br>
        Cantidad de intervalos:
        <input name="cantidadIntervalos" value="" type="number">
        <br>
        <button type="submit">Enviar</button>
        </form>
    </body>
</html>
