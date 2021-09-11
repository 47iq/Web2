package com.example.web2.model;

public class TableInitializer {
    public static String createTable(Object checkList, TableInitializerMode tim) {
        if(checkList==null){
            System.err.println("ERR " + tim);
            return "";
        }
        if(tim == TableInitializerMode.TABLE_SINGLE)
            return createSingleTable(checkList);
        Results checking=(Results) checkList;
        StringBuilder table = new StringBuilder("<table align=\"center\" class=\"result_table\">\n" +
                "    <tr>\n" +
                "        <th class=\"variable\">X</th>\n" +
                "        <th class=\"variable\">Y</th>\n" +
                "        <th class=\"variable\">R</th>\n" +
                "        <th>Result</th>\n" +
                "        <th>Time</th>\n" +
                "    </tr>");
        for (Point check : checking.getPoints()) {
            table.append("<tbody><tr>");
            table.append("<th class='the_X'>").append(check.getX()).append("</th>");
            table.append("<th class='the_Y'>").append(check.getY()).append("</th>");
            table.append("<th class='the_R'>").append(check.getR()).append("</th>");
            table.append("<th class='the_Result'");
            table.append(check.isResult() ? (" style='color: lime'") : (" style='color: red'"));
            table.append(">");
            table.append(check.isResult()).append("</th>");
            table.append("<th>").append(check.getClock().getDateString()).append("</th>");
            table.append("</tr></tbody>");
        }
        table.append("</table>");
        return table.toString();
    }

    private static String createSingleTable(Object checkObj) {
        Point check = (Point) checkObj;
        return "<table align=\"center\" class=\"result_table\">\n" +
                "    <tr>\n" +
                "        <th class=\"variable\">X</th>\n" +
                "        <th class=\"variable\">Y</th>\n" +
                "        <th class=\"variable\">R</th>\n" +
                "        <th>Result</th>\n" +
                "        <th>Time</th>\n" +
                "    </tr>" + "<tbody><tr>" +
                "<th class='the_X'>" + check.getX() + "</th>" +
                "<th class='the_Y'>" + check.getY() + "</th>" +
                "<th class='the_R'>" + check.getR() + "</th>" +
                "<th class='the_Result'" + (check.isResult() ? " style='color: lime'" : " style='color: red'") +">" + check.isResult() + "</th>" +
                "<th>" + check.getClock().getDateString() + "</th>" +
                "</tr></tbody>" +
                "</table>";
    }
}
