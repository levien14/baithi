package controller;

import entity.PhoneInfor;
import model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/phone")
public class PhoneController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PhoneModel phoneModel = new PhoneModel();
        ArrayList<PhoneInfor> phoneInfors = phoneModel.findAll();
        if (phoneInfors == null){
            phoneInfors = new ArrayList<PhoneInfor>();
        }
        HttpSession session = req.getSession();
        session.setAttribute("list-phone",phoneInfors);
        req.getRequestDispatcher("/listphone.jsp").forward(req,resp);
    }
}
