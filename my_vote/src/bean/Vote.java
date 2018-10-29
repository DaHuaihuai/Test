package bean;

import java.sql.Date;

public class Vote {
	/*
	   CREATE TABLE `my_vote`.`vote` (
	  `vid` INT NOT NULL AUTO_INCREMENT,
	  `vname` VARCHAR(40) NOT NULL,
	  `vchoice` TINYINT NOT NULL,
	  `vtype` TINYINT NOT NULL,
	  `vreport` TINYINT NULL,
	  `deadline` VARCHAR(20) NULL,
	  `uid` INT NULL,
	  PRIMARY KEY (`vid`),
	  INDEX `uid_idx` (`uid` ASC),
	  CONSTRAINT `uid`
	    FOREIGN KEY (`uid`)
	    REFERENCES `my_vote`.`user` (`uid`)
	    ON DELETE CASCADE
	    ON UPDATE CASCADE);
	 */
	private int vid;
	private String vname;
	private int vchoice;
	private int vtype;
	private int vreport;
	private Date deadline;
	private int uid;
	
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public int getVchoice() {
		return vchoice;
	}
	public void setVchoice(int vchoice) {
		this.vchoice = vchoice;
	}
	public int getVtype() {
		return vtype;
	}
	public void setVtype(int vtype) {
		this.vtype = vtype;
	}
	public int getVreport() {
		return vreport;
	}
	public void setVreport(int vreport) {
		this.vreport = vreport;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Vote [vid=" + vid + ", vname=" + vname + ", vchoice=" + vchoice + ", vtype=" + vtype + ", vreport="
				+ vreport + ", deadline=" + deadline + ", uid=" + uid + "]";
	}

}
