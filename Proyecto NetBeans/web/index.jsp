<%-- 
    Document   : index
    Created on : Mar 24, 2016, 3:45:50 PM
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
        <h1>TP1 - Simulacion</h1>
        <h2>Punto A</h2>
            <p>Realizar un programa de genere una serie de 20 números aleatorios entre 0 y 9999 (4 dígitos) a partir de un valor numérico indicado como raíz, utilizando los métodos congruenciales mixto y multiplicativo. Las constantes a utilizar por los métodos deben ser ingresadas por  el usuario. 
            Una vez que se listan los 20 números, debe permitir seguir la serie de a un valor por vez. </p>
            <a href="${pageContext.request.contextPath}/puntoA.jsp">
                <button> Probar </button>
            </a>
        <h2>Punto B</h2>
            <p>Realizar un programa que efectúe la prueba de frecuencia (Test de Chi Cuadrado) sobre una serie generada a través del mecanismo provisto por el lenguaje utilizado para generar números pseudo-aleatorios. La cantidad de números a generar y de subintervalos debe ser recibida como parámetro y la salida generada deberá incluir una gráfica que represente las frecuencias observadas y esperadas (la gráfica se aceptará que se genere en base a un archivo de salida del programa, en Excel).</p>
            <a href="${pageContext.request.contextPath}/puntoB.jsp">
                <button> Probar </button>
            </a>
       <h2>Punto C</h2>
            <p>Lo mismo que el punto anterior, pero utilizando el método congruencial mixto.</p>
            <a href="${pageContext.request.contextPath}/puntoC.jsp">
                <button> Probar </button>
            </a>
    </body>
</html>
