package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Vote;
import cn.itcast.commons.CommonUtils;
import service.VoteService;

public class NewvoteServlet extends HttpServlet {

 	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		VoteService voteService = new VoteService();
		
		int maxId=voteService.maxId();//得到当前数据库中vid最大值
		
		//maxId+1便是本次添加的纪录的vid
		request.setAttribute("vid", maxId+1);
		request.setAttribute("options", request.getParameter("vchoice"));
			
		Vote newVote = CommonUtils.toBean(request.getParameterMap(), Vote.class);
		
		voteService.addVote(newVote);
		
		request.getRequestDispatcher("JSP/addoption.jsp").forward(request, response);
	}

}
