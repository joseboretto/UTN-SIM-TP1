<%-- 
    Document   : mostrarA
    Created on : Mar 24, 2016, 6:48:41 PM
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
        <!No es aconsejable comentar aca, ya que lo vee el usuario, 
        la variable numerosGenerados, es a nivel de session.
        Ojo que el tipo no es int, sino integer>
        <jsp:useBean id="numerosGenerados" scope="session"  type="float[]" />        
        
        <h1>Lista de Numero Aleatorios</h1>
        <form method="post" action="${pageContext.request.contextPath}/ContinuarSerie" name="datos">
            <!En este caso para enviar la variable atravez de distintos formularios, 
                utilizamos otra tecnica en vez de esta a nivel de estar en la session, esta en el request 
                y luuego la agregamos al formulariuo con un campo oculto>                         
            <input type="submit" name="button" value="Generar Proximo" />
        </form>
            
            
        
            
        <table  class="table" border="1" style="width:100% ; text-align: center">
            <thead style="background-color: #D8D8D8" >
            <th>Iteracion</th>
                <th>Numero</th> 
            </thead>    
        <%
            for (int i = 0; i < numerosGenerados.length; i++) {
        %>
        <tbody>
                                <td> <%= i %> </td>
                                <td> <%= numerosGenerados[i] %> </td>
        </tbody>                        
        <%          
            }
        %>
        </table>
    </body>
</html>
