package com.example.web2.servlets;

import com.example.web2.model.Clock;
import com.example.web2.model.Point;
import com.example.web2.model.Results;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AreaCheckServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Point point = getPoint(req, resp);
        Results answerList = getResultsAddPoint(point, session);
        session.setAttribute("results", answerList);
        headToTablePage(req, resp, point, session);
    }

    private Results getResultsAddPoint(Point check, HttpSession session) {
        Results answerList = (Results) session.getAttribute("results");
        if(answerList == null)
            answerList = new Results();
        answerList.add(check);
        return answerList;
    }

    private void headToTablePage(HttpServletRequest req, HttpServletResponse resp, Point check, HttpSession session) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/res_page.jsp");
        session.setAttribute("check", check);
        rd.include(req, resp);
    }

    private Point getPoint(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Clock clock = new Clock();
        clock.start();
        double x = Double.parseDouble(req.getParameter("X_field"));
        double y = Double.parseDouble(req.getParameter("Y_field"));
        double r = Double.parseDouble(req.getParameter("R_field"));
        if (!isValid(x, y, r)){
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        Point point = new Point(x, y, r);
        point.setResult(isAreaHit(x, y, r));
        clock.finish();
        point.setClock(clock);
        return point;
    }

    public boolean isAreaHit(double x, double y, double r) {
        return ((x >= -r) && (x <= 0) && (y >= 0) && (y <= r) && (x * x + y * y <= r * r)) ||
                ((x <= r) && (x >= 0) && (y >= 0) && (y <= r)) ||
                ((x >= -r/2) && (x <= 0) && (y >= -r) && (y <= 0) && (y >= 2 * x + r));
    }

    public boolean isValid(double x, double y, double r) {
        return (x >= -2) && (x <= 2) && (y > -3) && (y < 5) && (r >= 1) && (r <= 5);
    }
}
