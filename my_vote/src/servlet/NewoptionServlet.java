package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Option;
import cn.itcast.commons.CommonUtils;
import service.VoteService;

public class NewoptionServlet extends HttpServlet {

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

		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");//中文编码问题
		
		VoteService voteService = new VoteService();

		int options = Integer.parseInt(request.getParameter("options"));
		int vid = Integer.parseInt(request.getParameter("vid"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Option> list = new ArrayList<Option>();
				
		for (int i = 1; i <= options ; i++) {
			map.put("vid", vid);
			String oname = "option"+i;
			map.put("oname", request.getParameter(oname));
			Option form = CommonUtils.toBean(map, Option.class);
			
			list.add(form);
			
		}
		//System.out.println(list);
		//调用service中的
		voteService.addOption(list);
		request.getRequestDispatcher("JSP/welcome.jsp").forward(request, response);
	}

}
