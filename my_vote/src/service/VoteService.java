package service;

import java.sql.SQLException;

import bean.Vote;
import dao.VoteDao;

public class VoteService {

	private VoteDao voteDao = new VoteDao();
	
	public void addVote(Vote newvote) {
		try {
			voteDao.addVote(newvote);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	
	public int maxId(){
		try {
			return voteDao.findMaxId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}
