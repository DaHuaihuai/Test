package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.VoteException;
import service.VoteService;

public class ConfirmVoteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VoteService voteService = new VoteService();
		//判断选项内容为单选还是多选
		String vtypeString = request.getParameter("vtype");
		//获取uid和vid,添加纪录到user_vote表中（一人为每个投票只能投一票）
		String uidString = request.getParameter("uid");
		int uid = Integer.parseInt(uidString);
		String vidString = request.getParameter("vid");
		int vid = Integer.parseInt(vidString);
		
		if(vtypeString.equals("1")){
			String[] options = request.getParameterValues("option");
			if(options==null)
				request.getRequestDispatcher("JSP/welcome.jsp").forward(request, response);
			else{
				int length = options.length;
				//遍历option，为每个选项更新票数
				for(int i=0; i < length;i++){
					int oid = Integer.parseInt(options[i]);
					voteService.updateOption(oid);
				}
				try {
					voteService.changeVoted(uid,vid);
					request.getRequestDispatcher("JSP/welcome.jsp").forward(request, response);
				} catch (VoteException e) {
					// TODO Auto-generated catch block
					request.setAttribute("msg", e.getMessage());
					request.getRequestDispatcher("JSP/option.jsp").forward(request, response);
				}
				
			}
		}
		else {
			if(request.getParameter("option")!=null){
				int oid = Integer.parseInt(request.getParameter("option"));
				voteService.updateOption(oid);
				try {
					voteService.changeVoted(uid,vid);
					request.getRequestDispatcher("JSP/welcome.jsp").forward(request, response);
				} catch (VoteException e) {
					request.setAttribute("msg", e.getMessage());
					request.getRequestDispatcher("JSP/option.jsp").forward(request, response);
				}
			}
			else {
				request.getRequestDispatcher("JSP/welcome.jsp").forward(request, response);
			}
		}
	}

}
