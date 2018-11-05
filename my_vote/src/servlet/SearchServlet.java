package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.VoteService;

public class SearchServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");//中文编码问题
		
		String	search = request.getParameter("search");
		
		VoteService voteService = new VoteService();
		List<Map<String, Object>> list = voteService.searchByName(search);
		
		request.setAttribute("queryList", list);
		
		request.getRequestDispatcher("JSP/searchvote.jsp").forward(request, response);
	}

}
