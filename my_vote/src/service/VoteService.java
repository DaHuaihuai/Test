package service;

import java.sql.SQLException;
import java.util.List;

import bean.Option;
import bean.Vote;
import dao.VoteDao;

public class VoteService {

	private VoteDao voteDao = new VoteDao();
	
	//发起投票时调用，给vote表插入纪录
	public void addVote(Vote newvote) {
		try {
			voteDao.addVote(newvote);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	
	//得到vote表中的最大主键
	public int maxId(){
		try {
			return voteDao.findMaxId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	
	//设置选项时调用，为vote_option表插入数条纪录
	public void addOption(List<Option> list){
		try {
			voteDao.addOption(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
