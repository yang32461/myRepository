package electronic.mall;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends User {
	Scanner sc = new Scanner(System.in);
	String username;
	String password;

	List<User> userList = new ArrayList<User>();
	List<Good> goodList = new ArrayList<Good>();

	public static void main(String[] args) {
		Menu shop = new Menu();
		shop.start();
	}

	private void showMainmenu() { // 主菜单
		System.out.println("*******欢迎进入电子商城*********");
		System.out.println("1、注册");
		System.out.println("2、登录");
		System.out.println("3、查看书城");
		System.out.println("4、查看我已购买的书籍");
		System.out.println("5、管理员功能");
		System.out.println("6、退出");
		System.out.println("***************************");
		System.out.println("请选择菜单功能：");
		int choice = sc.nextInt();
		this.choose(choice);
	}

	private boolean choose(int choice) {
		System.out.println("您选择的是：" + choice);
		boolean result = true;
		switch (choice) {
		case 1:
			System.out.println("您选择的功能是：注册");
			this.reg();
			break;
		case 2:
			System.out.println("您选择的功能是：登录");
			this.login();
			break;
		case 3:
			System.out.println("您选择的功能是：查看商城");
			//this.initGoodList();
			this.showGoodList();
			break;
		case 4:
			System.out.println("您选择的功能是：查看我已购买的书籍");
			break;
		case 5:
			System.out.println("您选择的功能是：管理员功能");
			this.adminLogin();
			break;
		case 6:
			System.out.println("您选择的功能是：退出");
			result = false;
			break;
		default:
			System.out.println("您的输入有误！");
			break;
		}
		return result;

	}

	private void adminLogin() { // 管理员登录
		System.out.println("请输入管理员用户名：");
		String username = sc.next();
		while (true) {
			System.out.println("请输入管理员密码:");
			String password = sc.next();
			if (username.equals("admin") && password.equals("admin")) {
				System.out.println("管理员登录成功");
				while (true) {
					int choice = this.showAdminMenu();
					if (choice == 5) {

						break;
					}
					this.chooseAdminMenu(choice);
				}
				break;
			} else {
				System.out.println("登录失败");
			}
		}

	}

	private void addGood() {
		System.out.println("请输入商品编号：");
		int id = sc.nextInt();
		System.out.println("请输入商品的名称：");
		String name = sc.next();
		System.out.println("请输入商品的价格：");
		String price = sc.next();
		System.out.println("请输入商品的数量：");
		int num = sc.nextInt();

		Good good = new Good();
		good.setId(id);
		good.setName(name);
		good.setNum(num);
		good.setPrice(new BigDecimal(price));
		goodList.add(good);

	}

	private void updateGood() {
		System.out.println("请输入需要修改的商品编号：");
		int id = sc.nextInt();
		Good good = this.findGoodById(id);
		if (good == null) {
			System.out.println("未找到该商品");
		} else {
			System.out.println("该商品信息如下：");
			System.out.println("商品ID：" + good.getId());
			System.out.println("商品价格：" + good.getPrice());
			System.out.println("商品数量：" + good.getNum());
		}
		System.out.println("请输入修改后的商品名称：");
		String name = sc.next();
		good.setName(name);
		System.out.println("请输入修改后的商品价格：");
		Double price = sc.nextDouble();
		good.setPrice(new BigDecimal(price));
		System.out.println("请输入修改后的商品数量：");
		int num = sc.nextInt();
		good.setNum(num);
	}

	private void delGood() {
		System.out.println("请输入你需要删除的商品编号：");
		int id = sc.nextInt();
		Good good = this.findGoodById(id);
		goodList.remove(good);
		System.out.println("商品删除成功");
	}

	//
	// private void initGoodList() {
	// List<Good> goosList = new ArrayList<Good>();
	// Good good1 = new Good(1, "冰箱", new BigDecimal("1999"), 90);
	// Good good2 = new Good(2, "电视", new BigDecimal("1499"), 60);
	// Good good3 = new Good(3, "手机", new BigDecimal("999"), 100);
	// goodList.add(good1);
	// goodList.add(good2);
	// goodList.add(good3);
	// }
	//

	private Good findGoodById(int id) {
		Good returnGood = null;
		for (Good good : goodList) {
			if (good.getId() == id) {
				returnGood = good;
				break;
			}
		}
		return returnGood;
	}

	private void chooseAdminMenu(int choice) {
		boolean result = true;
		String is_go_on = "Y";
		switch (choice) {
		case 1:
			System.out.println("您选择的是：添加商品");
			while (is_go_on.equals("Y")) {
				this.addGood();
				System.out.println("您是否继续？Y/N");
				is_go_on = sc.next();
			}
			break;
		case 2:
			System.out.println("您选择的是：商品修改");
			this.updateGood();
			break;
		case 3:
			System.out.println("您选择的是：商品删除");
			this.delGood();
			break;
		case 4:
			System.out.println("您选择的是：商品查询");
			this.initGoodList();
			//this.showGoodList();
			break;

		}

	}

	private int showAdminMenu() { // 管理员菜单
		System.out.println("*******欢迎进入管理员菜单*********");
		System.out.println("1、商品添加");
		System.out.println("2、商品修改");
		System.out.println("3、商品删除");
		System.out.println("4、商品查询");
		System.out.println("5、退出");
		System.out.println("***************************");
		System.out.println("请选择菜单功能：");
		int choice = sc.nextInt();
		return choice;
	}

	private void reg() { // 注册功能
		System.out.println("欢迎注册");
		System.out.println("请输入用户名：");
		username = sc.next();
		while (true) {
			System.out.println("请输入密码：");
			password = sc.next();
			System.out.println("请确认密码：");
			String repassword = sc.next();
			if (password.equals(repassword)) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				userList.add(user);
				break;
			} else {
				System.out.println("密码不一致");
			}
		}
		System.out.println("注册成功");
	}

	private void login() { // 登录功能
		System.out.println("欢迎登录");
		System.out.println("请输入用户名：");
		String login_username = sc.next();
		boolean loginResult = false;
		while (true) {
			System.out.println("请输入密码：");
			String login_password = sc.next();
			for (User user : userList) {
				if (login_username.equals(username) && login_password.equals(password)) {
					System.out.println("登录成功！");
					loginResult = true;
					break;
				}
			}
			if (loginResult == true) {
				break;
			} else {
				System.out.println("登录失败。");
			}
		}
	}

	private void start() {
		//this.initGoodList();
		boolean is_go_on = true;
		while (is_go_on == true) {
			this.showMainmenu();
			int choice = this.sc.nextInt();
			is_go_on = this.choose(choice);
			if (is_go_on == false) {
				break;
			}
		}
		System.out.println(" ");
		System.exit(0);

	}

}
