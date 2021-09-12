<%@ page import="com.example.web2.model.Point" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table align="center" class="result_table">
    <tr>
        <th class="variable">X</th>
        <th class="variable">Y</th>
        <th class="variable">R</th>
        <th>Result</th>
        <th>Time</th>
    </tr>
    <%
        Object checkObj = getServletConfig().getServletContext().getAttribute("result");
        Point check = (Point) checkObj;
    %>
    <tbody>
    <tr>
        <th class='the_X'><%=check.getX()%>
        </th>
        <th class='the_Y'><%=check.getY()%>
        </th>
        <th class='the_R'><%=check.getR()%>
        </th>
        <th class='the_Result' style='color:<%=(check.isResult() ? "lime" : "red")%>'><%=check.isResult()%>
        </th>
        <th><%=check.getClock().getDateString()%>
        </th>
    </tr>
    </tbody>
</table>