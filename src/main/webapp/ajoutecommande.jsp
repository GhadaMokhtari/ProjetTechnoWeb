<%-- 
    Document   : ajoutecommande
    Created on : 14 avr. 2019, 14:47:54
    Author     : bonneviale clara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- On charge jQuery -->
        <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <!-- On charge le moteur de template mustache https://mustache.github.io/ -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/0.8.1/mustache.min.js"></script>
        <link rel="stylesheet" type="text/css" href="java3.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <script>
        $(document).ready(// Exécuté à la fin du chargement de la page
                    function () {
                        // On montre la liste des codes
                        showProduits();
                    }
            );
    
        function showProduits() {
                // On fait un appel AJAX pour chercher les produits selectionnables
                $.ajax({
                    url: "allProduits",
                    dataType: "json",
                    error: showError,
                    success: // La fonction qui traite les résultats
                            function (result) {
                                // Le code source du template est dans la page
                                var template = $('#produitsTemplate').html();
                                // On combine le template avec le résultat de la requête
                                var processedTemplate = Mustache.to_html(template, result);
                                // On affiche la liste des options dans le select
                                $('#formulaireajout').html(processedTemplate);
                            }
                });
            }
            
            // Ajouter une commande
            function addCommande() {
                $.ajax({
                    url: "addCommande",
                    // serialize() renvoie tous les paramètres saisis dans le formulaire
                    data: $("#commandeForm").serialize(),
                    dataType: "json",
                    success: // La fonction qui traite les résultats
                            function (result) {
                                console.log(result);
                            },
                    error: showError
                });
                return false;
            }
            
            // Fonction qui traite les erreurs de la requête
            function showError(xhr, status, message) {
                alert(JSON.parse(xhr.responseText).message);
            }
        
        </script>
        <title>Ajout d'une commande</title>
    </head>
    <STYLE>A {text-decoration: none; color: black;} </STYLE>
    <body>
        <nav class="barAffiche">
            <ol>
                <li class="a2"><a href="index.html">Accueil</a>  </li>
                <li class="a2"><a href=""> Votre compte </a> </li>
                <li class="a2"><a href="">Déconnexion</a>  </li>
            </ol>
        </nav>
        
        <h1>Formulaire d'ajout d'une commande</h1>
        
        <form id="commandeForm" onsubmit="event.preventDefault(); addCommande();">
            <fieldset><legend>Ajout d'une nouvelle commande</legend>
            Numéro de commande : <input id="ordernum" name="ordernum" required ><br/>
            id produit : <select name="idproduct" id="idproduct">
                            {{! Pour chaque enregistrement }}
                                {{#records}}
                                {{! Une ligne dans la liste déroulante }}
                                    <option>{{idproduct}}</option>
                                {{/records}}
                         </select><br/>
            quantité: <input id="quantity" name="quantity" type="number" required><br/>
            cout de transport: <input id="shippingcost" name="shippingcost" type="number" required><br/>
            date de vente: <input id="salesdate" name="salesdate" required placeholder="yyyy-MM-d"><br/>
            date d'envoi: <input id="shippingdate" name="shippingdate" required placeholder="yyyy-MM-d"><br/>
            Entreprise de transport: <input id="company" name="company" type="text" required><br/>
            <input type="hidden" id="idcustomer" name="idcustomer" value="">
            
            
            <input type="submit" value="Ajouter">
            </fieldset>
        </form>
        
        
        
    </body>
</html>
