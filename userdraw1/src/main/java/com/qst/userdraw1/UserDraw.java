package com.qst.userdraw1;


import java.math.BigDecimal;



/**
 * 用户画像
 **/
public class UserDraw {
	
	private String statTimeDay;
	private String MDN;
	private double male;//男权重
	private double female;//女权重
	private double age1;//年龄权重
	private double age2;
	private double age3;
	private double age4;
	private double age5;
	
	private double male_sum;
	private double female_sum;
	
	private double age1_sum;
	private double age2_sum;
	private double age3_sum;
	private double age4_sum;
	private double age5_sum;

	// 重写toString
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(statTimeDay).append("|");
		sb.append(MDN).append("|");
		sb.append(new BigDecimal(male).setScale(3, 4).doubleValue()).append("|");
		sb.append(new BigDecimal(female).setScale(3, 4).doubleValue()).append("|");
		sb.append(new BigDecimal(age1).setScale(3, 4).doubleValue()).append("|");
		sb.append(new BigDecimal(age2).setScale(3, 4).doubleValue()).append("|");
		sb.append(new BigDecimal(age3).setScale(3, 4).doubleValue()).append("|");
		sb.append(new BigDecimal(age4).setScale(3, 4).doubleValue()).append("|");
		sb.append(new BigDecimal(age5).setScale(3, 4).doubleValue()).append("|");
		
		
//		sb.append(MDN).append(">>>>");
//		sb.append(new BigDecimal(male_sum).setScale(3, 4).doubleValue()).append("|");
//		sb.append(new BigDecimal(female_sum).setScale(3, 4).doubleValue()).append("|");
//		sb.append(new BigDecimal(age1_sum).setScale(3, 4).doubleValue()).append("|");
//		sb.append(new BigDecimal(age2_sum).setScale(3, 4).doubleValue()).append("|");
//		sb.append(new BigDecimal(age3_sum).setScale(3, 4).doubleValue()).append("|");
//		sb.append(new BigDecimal(age4_sum).setScale(3, 4).doubleValue()).append("|");
//		sb.append(new BigDecimal(age5_sum).setScale(3, 4).doubleValue()).append("|");

		return sb.toString();
	}
	

	// 融合方法
	/** 性别融合 */
//	public void protraitSex(double male2, double female2, long times) {
//		double sum = (this.male + this.female + (male2 + female2) * times);//times为使用时间
//		if(sum != 0){
//			this.male = (this.male + male2 * times) / sum;
//			this.female = (this.female + female2 * times) / sum;
//		}
//			
//	}
	
	public void protraitSex(double male2, double female2, long times){
		this.male_sum=this.male_sum + male2 * times;
		this.female_sum=this.female_sum + female2 * times;
		double sum =this.male_sum + this.female_sum;
		//double sum=this.male_sum+this.female_sum+(male2 + female2) * times;
		
		if(sum != 0){
			this.male=this.male_sum / sum;
			this.female = this.female_sum / sum;
		}
		
	}
	

	/** 年龄段融合 */
	public void protraitAge(double pAge1, double pAge2, double pAge3, double pAge4, double pAge5, long times) {
			this.age1_sum=this.age1_sum + pAge1 * times;
			this.age2_sum=this.age2_sum + pAge2 * times;
			this.age3_sum=this.age3_sum + pAge3 * times;
			this.age4_sum=this.age4_sum + pAge4 * times;
			this.age5_sum=this.age5_sum + pAge5 * times;
			
			double sum = this.age1_sum + this.age2_sum + this.age3_sum + this.age4_sum + this.age5_sum;
			
		//		double sum = (this.age1 + this.age2 + this.age3 + this.age4 + this.age5 ) // 之前的APP的
		//				+ (pAge1 + pAge2 + pAge3 + pAge4 + pAge5 ) * times;// 当前的APP的
		if(sum != 0){
			this.age1 = this.age1_sum / sum;
			this.age2 = this.age2_sum / sum;
			this.age3 = this.age3_sum / sum;
			this.age4 = this.age4_sum / sum;
			this.age5 = this.age5_sum / sum;
		}
	}

	/** 初始化男女概率 */
	public void initSex(float male, float female,long times) {
		this.male_sum=male*times;
		this.female_sum=female*times;
		double sum=this.male_sum+this.female_sum;
		if(sum != 0){
			this.male = this.male_sum / sum;
			this.female = this.female_sum / sum;
		}
	}

	/** 初始化年龄段概率 */
	public void initAge(float pAge1, float pAge2, float pAge3, float pAge4, float pAge5,long times) {
		this.age1_sum = pAge1 * times;
		this.age2_sum = pAge2 * times;
		this.age3_sum = pAge3 * times;
		this.age4_sum = pAge4 * times;
		this.age5_sum = pAge5 * times;
		
		double sum = this.age1_sum + this.age2_sum + this.age3_sum + this.age4_sum + this.age5_sum;
		if(sum != 0){
			this.age1 = this.age1_sum / sum;
			this.age2 = this.age2_sum / sum;
			this.age3 = this.age3_sum / sum;
			this.age4 = this.age4_sum / sum;
			this.age5 = this.age5_sum / sum;
		}
	}


	// setter and getter method
	public String getStatTimeDay() {
		return statTimeDay;
	}

	public void setStatTimeDay(String statTimeDay) {
		this.statTimeDay = statTimeDay;
	}


	public String getMDN() {
		return MDN;
	}

	public void setMDN(String mDN) {
		MDN = mDN;
	}


	public double getMale() {
		return male;
	}

	public double getFemale() {
		return female;
	}

	public double getAge1() {
		return age1;
	}

	public double getAge2() {
		return age2;
	}

	public double getAge3() {
		return age3;
	}

	public double getAge4() {
		return age4;
	}

	public double getAge5() {
		return age5;
	}

	public double getMale_sum() {
		return male_sum;
	}

	public void setMale_sum(double male_sum) {
		this.male_sum = male_sum;
	}

	public double getFemal_sum() {
		return female_sum;
	}

	public void setFemale_sum(double femal_sum) {
		this.female_sum = femal_sum;
	}

	public double getAge1_sum() {
		return age1_sum;
	}

	public void setAge1_sum(double age1_sum) {
		this.age1_sum = age1_sum;
	}

	public double getAge2_sum() {
		return age2_sum;
	}

	public void setAge2_sum(double age2_sum) {
		this.age2_sum = age2_sum;
	}

	public double getAge3_sum() {
		return age3_sum;
	}

	public void setAge3_sum(double age3_sum) {
		this.age3_sum = age3_sum;
	}

	public double getAge4_sum() {
		return age4_sum;
	}

	public void setAge4_sum(double age4_sum) {
		this.age4_sum = age4_sum;
	}

	public double getAge5_sum() {
		return age5_sum;
	}

	public void setAge5_sum(double age5_sum) {
		this.age5_sum = age5_sum;
	}


}
