package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import bean.User;
import service.UserException;
import service.UserService;


public class RegistServlet extends HttpServlet {

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

		/*
		 * 1.将表单数据封装到User中
		 * 2.将封装好的user传递到service
		 * 3.service调用dao层方法，将User添加到数据库中
		 */
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		UserService userService = new UserService();
		
		
		//toBean函数会自动将表单中String类型按照Bean中定义类型进行类型转换
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		/*
		 * 表单校验
		 * 创建map装载错误信息
		 */
		Map<String, String> errorMap= new HashMap<String, String>();
		String username=form.getUsername();
		if(username==null|| username.trim().isEmpty()){
			errorMap.put("username", "用户名不能为空！");
		}
		String password=form.getPassword();
		if(password==null|| password.trim().isEmpty()){
			errorMap.put("password", "密码不能为空！");
		}
		String realVerifyCode = (String)request.getSession().getAttribute("session_code");
		String verifyCode = form.getVerifyCode();
		if(verifyCode==null){
			errorMap.put("verifyCode", "验证码不能为空！");
		}else if( ! realVerifyCode.equalsIgnoreCase(verifyCode)){
			errorMap.put("verifyCode", "验证码错误！");
		}
		
		if(errorMap!=null && errorMap.size() > 0){
			request.setAttribute("errors", errorMap);
			request.setAttribute("user", form);
			request.getRequestDispatcher("/JSP/register.jsp").forward(request, response);
			return;
		}
		
		try {
			userService.regist(form);
			response.getWriter().print("<h1>注册成功</h1>");
		} catch (UserException e) {
			
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/JSP/register.jsp").forward(request, response);
		}
	}

}
