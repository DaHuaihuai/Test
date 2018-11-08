package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Page;
import service.VoteService;

public class AdminServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");//中文编码问题
		
		VoteService voteService = new VoteService();

		 //1.从jsp中得到pc
		 // 若存在pc，转换为int，否则置为1
		String pagecode = request.getParameter("pc");
		int pc;
		if(pagecode==null || pagecode.trim().isEmpty()){
			pc = 1;
		}
		else {
			pc = Integer.parseInt(pagecode);
		}
		//2.定义page size
		int ps = 10;
		//3.获取到Page对象
		Page<Map<String, Object>> page = voteService.adminSearch(pc,ps);
		//4.保存在request域中
		request.setAttribute("pageList", page);
		
		request.getRequestDispatcher("JSP/admin.jsp").forward(request, response);
	}

}
