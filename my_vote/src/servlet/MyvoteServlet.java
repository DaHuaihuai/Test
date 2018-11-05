package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import bean.Vote;
import service.VoteService;

public class MyvoteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VoteService voteService = new VoteService();
		User nowUser = (User) request.getSession().getAttribute("sessionUser");
		
		if(nowUser==null){
			request.setAttribute("msg", "请先登录！");
			request.getRequestDispatcher("/JSP/login.jsp").forward(request, response);
			 return;
		}
		int uid = nowUser.getUid();
		List<Vote> list = new ArrayList<Vote>();
		 
		list = voteService.myVote(uid);
		request.setAttribute("voteList", list);
		request.getRequestDispatcher("JSP/myvote.jsp").forward(request, response);
		
	}

}
