package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.VoteService;

public class ReportServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VoteService voteService = new VoteService();
		String vidString = request.getParameter("vid");
		int vid = Integer.parseInt(vidString);
		
		voteService.reportVote(vid);
		request.getRequestDispatcher("JSP/welcome.jsp").forward(request, response);
	}

}
