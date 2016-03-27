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
        <h1>PuntoA</h1>
        <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            
        <form method="post" action="${pageContext.request.contextPath}/generarNumeros" name="datos">
        
        Raiz:
        <input name="raiz" value="" type="number">
        <br>
        Metodos: 
        <br>
        <input type="radio" name="metodo" value="congru"> Congruenciales mixto <br>
        <input type="radio" name="metodo" value="multi"> Multiplicativo<br>
        <br>
        Valor de A:
        <input name="valorA" value="" type="number">
        <br>
        Valor de C:
        <input name="valorC" value="" type="number">
        <br>
        Valor de M:
        <input name="valorM" value="" type="number">
        <br>
        <input type="submit" name="01_button" value="Generar de 0 a 1" />
        <input type="submit" name="09_button" value="Generar de 0 a 9999" />
        </form>
        
        <p>
        Cuando se quiere construir un generador de números aleatorios para simular los
        valores de una variable aleatoria, se deben elegir los parámetros de tal manera
        que se garantice un periodo largo para que se puedan hacer todos los ensayos de
        simulación, por lo tanto se deben tener en cuenta las siguientes condiciones:
        </p>
        <p>• a debe ser un número impar, no divisible ni por 3 ni por 5.</p>
        <p>• c usualmente puede ser cualquier constante, sin embargo, para asegurar
        buenos resultados, se debe seleccionar a de tal forma que, a mod 8 = 5 para
        una computadora binaria, o a mod 200 = 21 para computadora decimal</p>
        <p>• m debe ser el número entero más grande que la computadora acepte.
        De acuerdo con Hull y Dobell, los mejores resultados para un generador
        congruencial mixto en una computadora binaria son:</p>
        <p>• c = 8*a±3</p>
        <p>• X0 = Cualquier entero impar.</p>
        <p>• M = 2b
         , donde b >2 y que m sea aceptado por la computadora.</p>
        
                
        </div>
    </body>
</html>
