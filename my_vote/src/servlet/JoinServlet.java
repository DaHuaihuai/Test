package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Option;
import service.VoteService;

public class JoinServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VoteService voteService = new VoteService();
		if(request.getSession().getAttribute("sessionUser")==null){
			request.setAttribute("msg", "投票前请先登录！");
			request.getRequestDispatcher("JSP/login.jsp").forward(request, response);
			return;
		}
		//得到vid
		String vidString = request.getParameter("vid");
		int vid = Integer.parseInt(vidString);
		request.setAttribute("vid", vid);
		//通过vid获取到该投票的所有选项
		List<Option> optionList = new ArrayList<Option>();
		optionList = voteService.getOptions(vid);
		//返回的list为空，无选项设置
		if(optionList==null){
			request.setAttribute("msg", "该投票未设置选项！");
			request.getRequestDispatcher("JSP/option.jsp").forward(request, response);
			return;
		}
		//得到该投票的类型，并保存在request域中
		int vtype = voteService.getVoteType(vid);
		request.setAttribute("vtype", vtype);
		//得到该投票的截止日期，为下步投票确认做判断
		String deadLine = request.getParameter("deadline");
		request.setAttribute("deadline", deadLine);
		
		request.setAttribute("optionList", optionList);
		request.getRequestDispatcher("JSP/option.jsp").forward(request, response);
	}

}
