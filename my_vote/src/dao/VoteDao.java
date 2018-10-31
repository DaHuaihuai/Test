package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.Option;
import bean.Vote;
import cn.itcast.jdbc.TxQueryRunner;

public class VoteDao {

	//为数据库vote表添加纪录
	public void addVote(Vote newvote) throws SQLException{
		QueryRunner qRunner = new TxQueryRunner();
		String sql = "insert into vote values(null,?,?,?,0,?,?)";
		
		Object[] params = {newvote.getVname(),newvote.getVchoice(),newvote.getVtype(),newvote.getDeadline(),newvote.getUid()};
		
		qRunner.update(sql, params);
	}
	
	//查找vote表中的最大id，为之后的添加做准备
	public int findMaxId() throws SQLException{
		QueryRunner qRunner = new TxQueryRunner();
		String sql = "select MAX(vid) from vote";
		
		Number i = (Number)qRunner.query(sql, new ScalarHandler<Object>());
		int max = (int) i;
		return max;
	}

	public void addOption(List<Option> list) throws SQLException {
		QueryRunner qRunner = new TxQueryRunner();
		String sql = "insert into vote_option values(null,?,?,0)";
		
		for(int i = 0 ; i < list.size() ; i++) {
			  Object[] params = {list.get(i).getVid(),list.get(i).getOname()};
			  qRunner.update(sql, params);
			  //System.out.println("插入成功"+i);
			}
	}
}
