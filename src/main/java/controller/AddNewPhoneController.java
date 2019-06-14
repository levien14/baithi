package controller;

import entity.PhoneInfor;
import model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/phone/addnew")
public class AddNewPhoneController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addnewphone.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PhoneModel phoneModel = new PhoneModel();
        PhoneInfor phoneInfor = new PhoneInfor();
        phoneInfor.setName(req.getParameter("name"));
        phoneInfor.setBrand(req.getParameter("brand"));
        phoneInfor.setPrice(Double.valueOf(req.getParameter("price")));
        phoneInfor.setDescription(req.getParameter("description"));

        if (phoneModel.save(phoneInfor)){
            resp.sendRedirect("/phone");
            //req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else{
            req.setAttribute("errorAddNew","Co loi xay ra, ban vui long thu lai sau.");
            req.getRequestDispatcher("/addnewphone.jsp").forward(req,resp);
        }

    }
}
