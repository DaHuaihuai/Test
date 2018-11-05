package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.Option;
import bean.Page;
import bean.Vote;
import cn.itcast.jdbc.TxQueryRunner;

public class VoteDao {

	private QueryRunner qRunner = new TxQueryRunner();
	//为数据库vote表添加纪录
	public void addVote(Vote newvote) throws SQLException{

		String sql = "insert into vote values(null,?,?,?,0,?,?)";
		
		Object[] params = {newvote.getVname(),newvote.getVchoice(),newvote.getVtype(),newvote.getDeadline(),newvote.getUid()};
		
		qRunner.update(sql, params);
	}
	
	//查找vote表中的最大id，为之后的添加做准备
	public int findMaxId() throws SQLException{

		String sql = "select MAX(vid) from vote";
		
		Number i = (Number)qRunner.query(sql, new ScalarHandler<Object>());
		int max = (int) i;
		return max;
	}

	public void addOption(List<Option> list) throws SQLException {

		String sql = "insert into vote_option values(null,?,?,0)";
		
		for(int i = 0 ; i < list.size() ; i++) {
			  Object[] params = {list.get(i).getVid(),list.get(i).getOname()};
			  qRunner.update(sql, params);
			  //System.out.println("插入成功"+i);
			}
	}

	//条件查询，给出vote表中对应的内容
	public List<Map<String, Object>> searchByName(String search) throws SQLException {

		String sql = "select vid,vote.uid,vname,username,deadline from vote left join user on vote.uid=user.uid where 1=1 ";
		List<String> sqlList = new ArrayList<String>();
		
		//如果search中内容不为空,加入查询条件
		if(!search.trim().equals("")){
			sql+="and vname like ?";
			sqlList.add("%"+search+"%");
			Object[] params = sqlList.toArray();
			return qRunner.query(sql, new MapListHandler(),params);
		}
		else {
			return qRunner.query(sql, new MapListHandler());
		}	
	}
	
	//查询vote表中的所有纪录
	public Page<Map<String, Object>> searchAll(int pc, int ps) throws SQLException {
		Page<Map<String, Object>> page = new Page<Map<String, Object>>();

		
		page.setPc(pc);
		page.setPs(ps);
		String sql = "select count(*) from vote";
		
		Number tatol = (Number)qRunner.query(sql, new ScalarHandler<Object>());
		int tr = tatol.intValue();
		page.setTr(tr);
		sql = "select vid,vote.uid,vname,username,deadline from vote left join user on vote.uid=user.uid order by vid desc limit ?,?";

		Object[] params = {(pc-1)*ps,ps};
		List<Map<String, Object>> list = qRunner.query(sql, new MapListHandler() , params);
		page.setBeanList(list);
		
		return page ;

	}

	//查询我的投票
	public List<Vote> myVote(int uid) throws SQLException {

		String sql = "select * from vote where uid=?";
		
		List<Vote> list = qRunner.query(sql, new BeanListHandler<Vote>(Vote.class), uid);
		return list;
	}

	//查询某个投票对应的所有选项
	public List<Option> getOptions(int vid) throws SQLException {

		String sql = "select * from vote_option where vid=?";
		
		List<Option> optionList = qRunner.query(sql, new BeanListHandler<Option>(Option.class), vid);
		return optionList;
	}
	
	//通过vid查询对应投票的类型
	public int getVoteType(int vid) throws SQLException{

		String sql = "select vtype from vote where vid=?";
		
		Number type =(Number)qRunner.query(sql, new ScalarHandler<Object>(),vid);
		int vtype = type.intValue();
		return vtype;
	}

	public void updateOption(int oid) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update vote_option set onumber=onumber+1 where oid=?";
		
		qRunner.update(sql, oid);
	}

	public void changeVoted(int uid, int vid) throws SQLException {
		String sql = "insert into user_vote value(?,?)";
		qRunner.update(sql, vid,uid);
		
	}
}
