package bean;


public class option {
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
	private String vname;//选项名称
	private int vnumber;//对应选项票数
	
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
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public int getVnumber() {
		return vnumber;
	}
	public void setVnumber(int vnumber) {
		this.vnumber = vnumber;
	}
	@Override
	public String toString() {
		return "option [oid=" + oid + ", vid=" + vid + ", vname=" + vname + ", vnumber=" + vnumber + "]";
	}

}
