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

@WebServlet("/gamingTimeServlet")
public class gamingTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uploadTime = request.getParameter("gamingTime");

        User user =(User) request.getSession().getAttribute("userInfo");
        int id = user.getId();
        UserService service = new UserServiceImpl();
        try {
            service.uploadGamingTime(uploadTime,id);
        }catch (Exception e){
            e.printStackTrace();
        }

        request.getRequestDispatcher("gamingPage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
