package controller;

import entity.PhoneInfor;
import model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/phone/edit")
public class EditController extends HttpServlet {
    PhoneModel phoneModel = new PhoneModel();
    PhoneInfor phoneInfor = new PhoneInfor();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("phoneId");
        phoneInfor = phoneModel.findById(id);
        if (phoneInfor != null){
            req.setAttribute("edit-phone",phoneInfor);
            req.getRequestDispatcher("/edit_phone.jsp").forward(req,resp);
        }else {
            req.setAttribute("error-edit","Co loi xay ra ban vui long thu lai sau.");
            req.getRequestDispatcher("/errors.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        phoneInfor.setId(Long.parseLong(req.getParameter("phoneID")));
        phoneInfor.setName(req.getParameter("name"));
        phoneInfor.setBrand(req.getParameter("brand"));
        phoneInfor.setPrice(Double.parseDouble(req.getParameter("brand")));
        phoneInfor.setDescription(req.getParameter("description"));
        if (phoneModel.update(phoneInfor)){
            resp.sendRedirect("/phone");
            //req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        else{
            req.setAttribute("error-edit","Co loi xay ra ban vui long thu lai sau.");
            req.getRequestDispatcher("/errors.jsp").forward(req,resp);
        }

    }
}
