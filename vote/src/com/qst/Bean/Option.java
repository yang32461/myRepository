package com.qst.Bean;

public class Option {
	private int id;
	private String optionvalue;
	private int articleid;
	private int num;
	private String per;//计算百分比
	private double percent;
    
	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public Option() {
		super();
	}

	public Option(String optionvalue, int articleid) {
		super();
		this.optionvalue = optionvalue;
		this.articleid = articleid;
	}
    
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOptionvalue() {
		return optionvalue;
	}

	public void setOptionvalue(String optionvalue) {
		this.optionvalue = optionvalue;
	}

	public int getArticleid() {
		return articleid;
	}

	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}

}
