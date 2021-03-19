package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/changeUserInfoServlet2")
public class changeUserInfoServlet2 extends HttpServlet {   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        UserService service = new UserServiceImpl();
        try {
            BeanUtils.populate(user,parameterMap);
            service.changeUserInfoById(user,Integer.parseInt(id));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        service.quit(Integer.parseInt(id));
        request.getSession().removeAttribute("userInfo");
        request.getRequestDispatcher("changeStatus.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
