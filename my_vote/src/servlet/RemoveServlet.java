package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.VoteService;

public class RemoveServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VoteService voteService = new VoteService();
		String vidString = request.getParameter("vid");
		int vid = Integer.parseInt(vidString);
		
		voteService.removeReport(vid);
		request.getRequestDispatcher("AdminServlet").forward(request, response);
	}

}
