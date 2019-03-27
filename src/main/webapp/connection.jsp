<%-- 
    Document   : connection
    Created on : 26 mars 2019, 17:02:05
    Author     : infoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/connectioncss.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    </head>
    <body>
        <div>
        <fieldset>
            <form method="post" action="inscription">
                <legend> Connection </legend>
                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
                <br /><br>
                 <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br /><br>
                <input class="bouton" type="button" value="Connecter">
            </form>
        </fieldset>
        </div>
    </body>
</html>
