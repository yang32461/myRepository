package electronic.mall;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Good {
	private int id;
	private String name;
	private BigDecimal price;
	private int num;

	List<Good> goodList = new ArrayList<Good>();

	public Good(int id, String name, BigDecimal price, int num) {
		this.id = id;
		this.name = name;
		this.num = num;
		this.price = price;
	}

	void initGoodList() {
		System.out.println("商品列表如下：");
		Good good1 = new Good(1, "冰箱", new BigDecimal("1999"), 90);
		Good good2 = new Good(2, "电视", new BigDecimal("1499"), 60);
		Good good3 = new Good(3, "手机", new BigDecimal("999"), 100);

		goodList.add(good1);
		goodList.add(good2);
		goodList.add(good3);

		for (Good good : goodList) {
			System.out.println(good);
		}

	}

	public Good() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String toString() {
		return "id=" + id + ",name=" + name + ",price=" + price + ",num=" + num;
	}

}
