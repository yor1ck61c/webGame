package web.servlet;

import domain.PageBean;
import domain.Rank;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByPageServlet")
public class findUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if (currentPage == null || currentPage.equals("")){
            currentPage = "1";
        }
        if(rows == null || rows.equals("")){
            rows = "5";
        }

        UserService service = new UserServiceImpl();
        PageBean<Rank> ranking = service.findUserByPage(currentPage,rows);
        request.setAttribute("ranking",ranking);
        request.getRequestDispatcher("rankingPage.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
