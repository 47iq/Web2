package com.example.web2.servlets;

import com.example.web2.model.Clock;
import com.example.web2.model.Point;
import com.example.web2.model.Results;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Clock clock = new Clock();
        clock.start();
        double x = Double.parseDouble(req.getParameter("X_field"));
        double y = Double.parseDouble(req.getParameter("Y_field"));
        double r = Double.parseDouble(req.getParameter("R_field"));
        if (!checking(x, y, r)){
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        Point check = new Point(x, y, r);
        check.setResult(checkingTheArea(x, y, r));
        clock.finish();
        check.setClock(clock);
        Results answerList = (Results) getServletContext().getAttribute("answerList");
        if (answerList == null) {
            getServletContext().setAttribute("answerList", new Results());
            answerList = (Results) getServletContext().getAttribute("answerList");
        }
        answerList.add(check);
        getServletContext().setAttribute("answerList", answerList);
        //PrintWriter writer = resp.getWriter();
        //writer.write(answerPage(check));
        //writer.close();
        resp.setContentType("text/html; charset=UTF-8");
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/table.jsp");
        getServletContext().setAttribute("result", check);
        rd.include(req, resp);
    }

    public boolean checkingTheArea(double x, double y, double r) {
        return ((x >= -r) && (x <= 0) && (y >= 0) && (y <= r) && (x * x + y * y <= r * r)) ||
                ((x >= -r / 2) && (x <= 0) && (y >= -r) && (y <= 0)) ||
                ((x >= 0) && (x <= r) && (y >= -r) && (y <= 0) && (y >= x - r));
    }

    public boolean checking(double x, double y, double r) {
        return (x >= -4) && (x <= 4) && (y > -3) && (y < 5) && (r >= -1) && (r <= 5);
    }
}
