package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import bean.Option;
import bean.Page;
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

	//条件查询
	public List<Map<String, Object>> searchByName(String search) {
		List<Map<String, Object>> list = null;
		try {
			list = voteDao.searchByName(search);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//查询全部记录
	public Page<Map<String, Object>> searchAll(int pc, int ps) {
		Page<Map<String, Object>> page = null;
		try {
			page = voteDao.searchAll(pc,ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return page;
	}

	//按uid在vote表中查找所有纪录
	public List<Vote> myVote(int uid) {
		List<Vote> list = null;
		try {
			list = voteDao.myVote(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Option> getOptions(int vid) {
		// TODO Auto-generated method stub
		List<Option> optionList = null;
		try {
			optionList = voteDao.getOptions(vid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return optionList;
	}
	
	public int getVoteType(int vid){
		int vtype = 0;
		try {
			vtype = voteDao.getVoteType(vid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vtype;
	}

	public void updateOption(int oid) {
		// TODO Auto-generated method stub
		try {
			voteDao.updateOption(oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeVoted(int uid, int vid) throws VoteException {
		try {
			voteDao.changeVoted(uid, vid);
		} catch (SQLException e) {
			throw new VoteException("请不要重复投票！");
		}
		
	}
}
