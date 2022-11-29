package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import hitChecker.HitCheck;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "hitChecker", urlPatterns = "hit_checker")
public class HitCheckServlet extends HttpServlet {


    HitCheck hitCheck = new HitCheck();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new SimpleModule());
        resp.getWriter().write(objectMapper.writeValueAsString(String.valueOf(hitCheck.result(req.getParameter("coor_x"),req.getParameter("coor_y"), req.getParameter("value_R")))));

    }
}
