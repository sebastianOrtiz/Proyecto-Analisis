<%-- 
    Document   : index
    Created on : 1/05/2016, 10:59:43 PM
    Author     : Sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width">
        <title> Collapsable example </title>
        <link rel="stylesheet" href="css/Treant.css">
        <link rel="stylesheet" href="css/index.css">

        <link rel="stylesheet" href="css/perfect-scrollbar.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">

    </head>
    <body style="background-color: #000">
        <div class="container">
            <header class="col-xs-12" style="background-color: #c4e3f3">
                <button id="btn">Mostrar grafico</button>
            </header>
            <section class="col-xs-12" style="background-color: #fff">
                <div class="chart col-xs-5" id="codigo"></div>
                <div class="chart col-xs-6" id="collapsable-example"></div>
            </section>
            <footer class="col-xs-12" style="background-color: #c4e3f3">
                <p style="float: right">Andres Felipe Ososrio Echavarria <br> Sebastian Ortiz Valencia</p>
            </footer>
            
            
        </div>


        <script src="js/raphael.js"></script>
        <script src="js/Treant.js"></script>

        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.easing.js"></script>
        <script src="js/jquery.mousewheel.js"></script>
        <script src="js/perfect-scrollbar.js"></script>
        <script src="js/bootstrap.min.js"></script>


        <script src="js/index.js"></script>
    </body>
</html>