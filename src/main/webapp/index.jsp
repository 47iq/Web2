<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="Web programming second lab" name="description">
    <meta content="Danilov Pavel Iurievich" name="author">
    <title>Web programming - lab 2</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>

<body onload="drawCanvas()">

<jsp:useBean id="results" class="com.example.web2.model.Results" scope="session"/>
<jsp:useBean id="check" class="com.example.web2.model.Point" scope="session"/>

<script src="canvas_handler.js"></script>
<script src="validator.js"></script>

<header>
    <span id="author">
        Danilov Pavel Iurievich, P3210, v. 10109
    </span>
</header>

<table class="page_table" align="center">
    <tr>
        <td>
            <div id="masloo">
                <canvas id="canvas"></canvas>
            </div>
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
                    <p>X=
                        <label>
                            <select id="X" name="X" class="variable">
                                <option value="-2">-2</option>
                                <option value="-1.5">-1.5</option>
                                <option value="-1">-1</option>
                                <option value="-0.5">-0.5</option>
                                <option value="0">0</option>
                                <option value="0.5">0.5</option>
                                <option value="1">1</option>
                                <option value="1.5">1.5</option>
                                <option value="2" selected>2</option>
                            </select>
                        </label>
                    </p>
                    <p class="variable">Y=
                        <label for="y"></label><input id="y" type="text" name="Y" placeholder="Enter y:">
                    </p>
                    <p>R=
                        <label>
                            <select id="R" name="R" class="variable">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5" selected>5</option>
                            </select>
                        </label>
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
                    <div class="R_coordinate">
                        <input name="R_field" id="R_field" type="hidden">
                    </div>
                </form>
            </div>
        </td>
    </tr>
    <tr>
        <td>
            <jsp:include page="all_table.jsp"/>
        </td>
    </tr>
</table>

</body>
</html>
