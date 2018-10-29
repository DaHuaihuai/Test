package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import cn.itcast.commons.CommonUtils;
import service.UserException;
import service.UserService;


public class LoginServlet extends HttpServlet {

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");//处理响应编码
		request.setCharacterEncoding("UTF-8");
		
		/*
		 * 1.将登录jsp中的数据封装到User中
		 * 2.在数据库中按用户名查询用户，若账号密码正确则登录成功
		 */
		//使用该toBean方法要注意：表单name属性和数据库列名要与javaBean属性命名一致
		//否则会出现java.lang.ClassNotFoundException报错
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		UserService userService = new UserService();
		
		try {
			User user = userService.login(form);
			//登录成功，将user存入session中
			request.getSession().setAttribute("sessionUser", user);
			//重定向到成功页面
			response.sendRedirect(request.getContextPath()+"/JSP/welcome.jsp");
		} catch (UserException e) {
			//若登录失败，回显错误信息
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/JSP/login.jsp").forward(request, response);
		}
	}

}
