<%-- 
    Document   : mostrarA
    Created on : Mar 24, 2016, 6:48:41 PM
    Author     : Jose
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <jsp:useBean id="tablaFrecuencias" scope="request"  type="int[]" />
        <h1>Test Chi Cuadrado - Punto B</h1>
    <!--Load the AJAX API-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Intervalo');
        data.addColumn('number', 'Frecuencia');
        data.addRows([
        <% for (int i = 0; i < tablaFrecuencias.length; i++) { 
            double limiteSuperior = ((double) (1+i)/ (double)tablaFrecuencias.length) - 0.01;
            double limiteInferior = ((double) (i)/ (double)tablaFrecuencias.length);
            DecimalFormat formatoDecimal  = new DecimalFormat("0.00");
            String limiteSupTxt = formatoDecimal.format(limiteSuperior);
            String limiteInfTxt = formatoDecimal.format(limiteInferior);
            

            if (i > tablaFrecuencias.length-1){
            
        %>
                        
                ['<%= limiteInfTxt %>-<%= limiteSupTxt %>', <%= tablaFrecuencias[i] %> ]         
            <%break;}%>

          ['<%= limiteInfTxt %>-<%= limiteSupTxt %>', <%= tablaFrecuencias[i] %> ],

        <%}%>
            
        ]);
        

        // Set chart options
        var options = {
           title: 'Histograma de numeros aleatorios generados por el sistema',
           width: 500,
           height: 300,
           legend: 'none',
           bar: {groupWidth: '97%'},
           vAxis: { gridlines: { count: <%= tablaFrecuencias.length %> } }
         };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
  </body>
</html>
