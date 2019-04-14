<%-- 
    Document   : afficheCA
    Created on : 13 avr. 2019, 08:21:42
    Author     : infoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="java4.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <title> Administrateur page  </title>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Language', 'Speakers (in millions)'],
          ['Assamese', 13], ['Bengali', 83], ['Bodo', 1.4],
          ['Dogri', 2.3], ['Gujarati', 46], ['Hindi', 300],

        ]);

        var options = {
          title: 'Indian Language Use',
          legend: 'none',
          pieSliceText: 'label',
          slices: {  4: {offset: 0.2},
                    12: {offset: 0.3},
                    14: {offset: 0.4},
                    15: {offset: 0.5},
          },
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
    </script>
    </head>
    <body>
        <fieldset>
            <h1> Chiffres d'affaires </h1>
            <form>
            <label> Chiffres d'affaires <span class="requis">*</span> </label> 
               <select name="CA" id="CA">
                   <option> Chiffres d'affaires </option>
                   <option> Catégorie de produit </option>
                   <option> Zone géographique </option>
                   <option> Client </option>
               </select>
               <br /><br>

            <label> Période <span class="requis">*</span> </label> 
            <input type="date" id="dateD" name="dateD" value="" size="20" maxlength="60" />
            <br /><br>
            </form>
            <input type="submit" class="bouton" value="Rechercher">
            <div id="piechart" style="width: 900px; height: 500px;"></div>
        </fieldset>
    </body>
</html>
