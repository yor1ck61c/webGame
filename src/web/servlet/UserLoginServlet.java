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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*1.设置编码*/
        request.setCharacterEncoding("utf-8");
        /*2.获取数据*/
        /*2.1.验证码校验*/

        Map<String, String[]> userMap = request.getParameterMap();
        User user = new User();

        /*for (Map.Entry<String, String[]> entry : userMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
        }*/
        /*3.封装User对象*/
        try {
            BeanUtils.populate(user,userMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        /*4.调用Service方法查询*/
        UserService service = new UserServiceImpl();
        User userInfo = service.loginCheck(user);


        /*5.判断是否登录成功*/
        if (userInfo != null){
            service.addOnline(userInfo.getId());
            int onlinePlayers = service.findOnlinePlayers();
            request.getSession().setAttribute("onlinePlayers",onlinePlayers);//查询在线玩家
            request.getSession().setAttribute("userInfo",userInfo);
            System.out.println(userInfo);//打印
            int time = new Date().getHours();
            if (time >= 6 && time <= 8){//根据当前时间显示问候语
                request.getSession().setAttribute("time", "早上好");
            }
            if (time >= 9 && time <= 11){
                request.getSession().setAttribute("time", "上午好");
            }
            if (time >= 12 && time <= 14){
                request.getSession().setAttribute("time", "中午好");
            }
            if (time >= 15 && time <= 18){
                request.getSession().setAttribute("time", "下午好");
            }
            if (time >= 19 && time <= 24){
                request.getSession().setAttribute("time", "晚上好");
            }
            if (time >= 0 && time <= 5){
                request.getSession().setAttribute("time", "夜深了");
            }

            request.getRequestDispatcher("UserSuccessLogin.jsp").forward(request,response);
        }else {
            request.setAttribute("loginMsg","登录失败，用户名或密码错误。");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
