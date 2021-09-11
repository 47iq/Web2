<%@ page import="com.example.web2.model.TableInitializer" %>
<%@ page import="com.example.web2.model.TableInitializerMode" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="Web programming second lab" name="description">
    <meta content="Danilov Pavel Iurievich" name="author">
    <title>Web programming - lab 2</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>

<body onload="drawCanvas()">

<script src="canvas.js"></script>
<script src="validation.js"></script>

<header>
    <span id="author">
        Danilov Pavel Iurievich, P3210, v. 10109
    </span>
</header>

<table class="page_table" align="center">
    <tr >
        <td>
            <div id="masloo">
                <canvas id="canvas" ></canvas></div>
        </td>
    </tr>
    <tr>
        <td>
            <p id="enter-text">Enter values:</p>
        </td>
    </tr>
    <tr>
        <td>
            <div class="vars_table">
                <form id="form" method="post" action="controllerServlet">
                    <p class="variable">X=
                        <label>
                            <input type="checkbox" value="-4" name="X" onclick="changeX(this)">
                        </label>-4
                        <label>
                            <input type="checkbox" value="-3" name="X" onclick="changeX(this)">
                        </label>-3
                        <label>
                            <input type="checkbox" value="-2" name="X" onclick="changeX(this)">
                        </label>-2
                        <label>
                            <input type="checkbox" value="-1" name="X" onclick="changeX(this)">
                        </label>-1
                        <label>
                            <input type="checkbox" value="0" name="X" onclick="changeX(this)">
                        </label>0
                        <label>
                            <input type="checkbox" value="1" name="X" onclick="changeX(this)">
                        </label>1
                        <label>
                            <input type="checkbox" value="2" name="X" onclick="changeX(this)">
                        </label>2
                        <label>
                            <input type="checkbox" value="3" name="X" onclick="changeX(this)">
                        </label>3
                        <label>
                            <input type="checkbox" value="4" name="X" onclick="changeX(this)">
                        </label>4
                    </p>
                    <p class="variable">Y=
                        <label for="y"></label><input id="y" type="text" name="Y" placeholder="Enter y:">
                    </p>
                    <p class="variable">R=
                        <label>
                            <input type="radio" value="1" name="R_field">
                        </label>1
                        <label>
                            <input type="radio" value="1.5" name="R_field">
                        </label>1.5
                        <label>
                            <input type="radio" value="2" name="R_field">
                        </label>2
                        <label>
                            <input type="radio" value="2.5" name="R_field">
                        </label>2.5
                        <label>
                            <input type="radio" value="3" checked name="R_field">
                        </label>3
                    </p>
                    <p>
                        <button id="button" type="submit">Submit</button>
                    </p>
                    <div class="X_coordinate">
                        <input name="X_field" id="X_field" type="hidden">
                    </div>
                    <div class="Y_coordinate">
                        <input name="Y_field" id="Y_field" type="hidden">
                    </div>
                </form>
            </div>
        </td>
    </tr>
    <tr>
        <td>
            <%=TableInitializer.createTable(getServletConfig().getServletContext().getAttribute("answerList"), TableInitializerMode.TABLE_FULL)%>
        </td>
    </tr>
</table>

</body>
</html>
