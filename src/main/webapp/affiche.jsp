<%-- 
    Document   : affiche
    Created on : 2 avr. 2019, 14:06:27
    Author     : infoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="java3.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <STYLE>A {text-decoration: none; color: black;} </STYLE>
    <body>
        <nav class="barAffiche">
            <ol>
                <li class="a2"><a href=""></a> Accueil </li>
                <li class="a2"><a href=""> Votre compte </a> </li>
                <li class="a2"><a href=""></a> Déconnexion </li>
            </ol>
        </nav>
        <table>
            <caption> Mes commandes </caption>
            <tr>
                <th> Numéro de commande </th>
                <th> Produit </th>
                <th> Quantité </th>
                <th> Prix </th>
                <th> Modifier </th>
                <th> Supprimer </th>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td> <input class="b1" type="button" value="Modifier"> </td>
                <td> <input class="b2" type="button" value="Supprimer"> </td>
            </tr>
            <tr></tr>
        </table>
        <input class="a" type="button" value="Ajouter une commande">
    </body>

</html>