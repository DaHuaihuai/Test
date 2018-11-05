package utils;

import java.sql.SQLException;

import dao.VoteDao;

public class Test {
	
	public void main(String[] args){
		VoteDao voteDao = new VoteDao();
		int i = 100;
		try {
			i = voteDao.getVoteType(25);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("dao层传来的vtype为"+i);
	}

}
