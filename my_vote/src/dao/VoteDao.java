package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.Vote;
import cn.itcast.jdbc.TxQueryRunner;

public class VoteDao {

	//为数据库添加纪录
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
}
