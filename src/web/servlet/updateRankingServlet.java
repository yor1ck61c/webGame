package web.servlet;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateRankingServlet")
public class updateRankingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User oldInfo = (User) request.getSession().getAttribute("userInfo");
        request.getSession().removeAttribute("userInfo");
        int id = oldInfo.getId();
        UserService service = new UserServiceImpl();
        User userInfo = service.findUserById(id);
        request.getSession().setAttribute("userInfo",userInfo);
        request.getRequestDispatcher("UserSuccessLogin.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
