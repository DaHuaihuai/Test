package bean;

import java.util.List;

/*
 * 该类中存储分页相关数据
 */
public class Page<T> {
	private int pc;//page code 当前页码
//	private int tp;//total page 总页数
	private int tr;//total record 总记录数
	private int ps;//page size 每页记录数
	private List<T> beanList;//存放页数据的list
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	//通过page size和total record计算得到总页数
	public int getTp() {
		int tp = tr/ps;
		
		return tr%ps==0 ? tp : tp+1;
	}

	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	@Override
	public String toString() {
		return "Page [pc=" + pc +  ", tr=" + tr + ", ps=" + ps + ", beanList=" + beanList + "]";
	}

}
