package com.qst.Bean;

import java.util.Date;

public class Article {
    private int id;
    private String title;
    private String desc;
    private Date createtime;
    private int createrid;
    private int numofOption;//选项的个数
    private int voteNum;
    
	public int getVoteNum() {
		return voteNum;
	}
	public void setVoteNum(int voteNum) {
		this.voteNum = voteNum;
	}
	public int getNumofOption() {
		return numofOption;
	}
	public void setNumofOption(int numofOption) {
		this.numofOption = numofOption;
	}
	public Article() {
		super();
	}
	
	public Article(String title, String desc, int createrid) {
		super();
		this.title = title;
		this.desc = desc;
		this.createrid = createrid;
	}
	public Article(String title, String desc, Date createtime, int createrid) {
		super();
		this.title = title;
		this.desc = desc;
		this.createtime = createtime;
		this.createrid = createrid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getCreaterid() {
		return createrid;
	}
	public void setCreaterid(int createrid) {
		this.createrid = createrid;
	}
    
}
