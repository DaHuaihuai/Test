package bean;

public class Option {

	/*
	 * CREATE TABLE `my_vote`.`vote_option` (
	  `oid` INT NOT NULL AUTO_INCREMENT,
	  `vid` INT NULL,
	  `vname` VARCHAR(20) NOT NULL,
	  `vnumber` VARCHAR(45) NOT NULL DEFAULT 0,
	  PRIMARY KEY (`oid`),
	  INDEX `vid_idx` (`vid` ASC),
	  CONSTRAINT `vid`
	    FOREIGN KEY (`vid`)
	    REFERENCES `my_vote`.`vote` (`vid`)
	    ON DELETE CASCADE
	    ON UPDATE CASCADE);
	 */
	private int oid;//该表主键
	private int vid;//外键，引用vote表中主键
	private String oname;//选项名称
	private int onumber;//对应选项票数
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public int getOnumber() {
		return onumber;
	}
	public void setOnumber(int onumber) {
		this.onumber = onumber;
	}
	@Override
	public String toString() {
		return "Option [oid=" + oid + ", vid=" + vid + ", oname=" + oname + ", onumber=" + onumber + "]";
	}
	
}
