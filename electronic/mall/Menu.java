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

	private void showMainmenu() { // ���˵�
		System.out.println("*******��ӭ��������̳�*********");
		System.out.println("1��ע��");
		System.out.println("2����¼");
		System.out.println("3���鿴���");
		System.out.println("4���鿴���ѹ�����鼮");
		System.out.println("5������Ա����");
		System.out.println("6���˳�");
		System.out.println("***************************");
		System.out.println("��ѡ��˵����ܣ�");
		int choice = sc.nextInt();
		this.choose(choice);
	}

	private boolean choose(int choice) {
		System.out.println("��ѡ����ǣ�" + choice);
		boolean result = true;
		switch (choice) {
		case 1:
			System.out.println("��ѡ��Ĺ����ǣ�ע��");
			this.reg();
			break;
		case 2:
			System.out.println("��ѡ��Ĺ����ǣ���¼");
			this.login();
			break;
		case 3:
			System.out.println("��ѡ��Ĺ����ǣ��鿴�̳�");
			//this.initGoodList();
			this.showGoodList();
			break;
		case 4:
			System.out.println("��ѡ��Ĺ����ǣ��鿴���ѹ�����鼮");
			break;
		case 5:
			System.out.println("��ѡ��Ĺ����ǣ�����Ա����");
			this.adminLogin();
			break;
		case 6:
			System.out.println("��ѡ��Ĺ����ǣ��˳�");
			result = false;
			break;
		default:
			System.out.println("������������");
			break;
		}
		return result;

	}

	private void adminLogin() { // ����Ա��¼
		System.out.println("���������Ա�û�����");
		String username = sc.next();
		while (true) {
			System.out.println("���������Ա����:");
			String password = sc.next();
			if (username.equals("admin") && password.equals("admin")) {
				System.out.println("����Ա��¼�ɹ�");
				while (true) {
					int choice = this.showAdminMenu();
					if (choice == 5) {

						break;
					}
					this.chooseAdminMenu(choice);
				}
				break;
			} else {
				System.out.println("��¼ʧ��");
			}
		}

	}

	private void addGood() {
		System.out.println("��������Ʒ��ţ�");
		int id = sc.nextInt();
		System.out.println("��������Ʒ�����ƣ�");
		String name = sc.next();
		System.out.println("��������Ʒ�ļ۸�");
		String price = sc.next();
		System.out.println("��������Ʒ��������");
		int num = sc.nextInt();

		Good good = new Good();
		good.setId(id);
		good.setName(name);
		good.setNum(num);
		good.setPrice(new BigDecimal(price));
		goodList.add(good);

	}

	private void updateGood() {
		System.out.println("��������Ҫ�޸ĵ���Ʒ��ţ�");
		int id = sc.nextInt();
		Good good = this.findGoodById(id);
		if (good == null) {
			System.out.println("δ�ҵ�����Ʒ");
		} else {
			System.out.println("����Ʒ��Ϣ���£�");
			System.out.println("��ƷID��" + good.getId());
			System.out.println("��Ʒ�۸�" + good.getPrice());
			System.out.println("��Ʒ������" + good.getNum());
		}
		System.out.println("�������޸ĺ����Ʒ���ƣ�");
		String name = sc.next();
		good.setName(name);
		System.out.println("�������޸ĺ����Ʒ�۸�");
		Double price = sc.nextDouble();
		good.setPrice(new BigDecimal(price));
		System.out.println("�������޸ĺ����Ʒ������");
		int num = sc.nextInt();
		good.setNum(num);
	}

	private void delGood() {
		System.out.println("����������Ҫɾ������Ʒ��ţ�");
		int id = sc.nextInt();
		Good good = this.findGoodById(id);
		goodList.remove(good);
		System.out.println("��Ʒɾ���ɹ�");
	}

	//
	// private void initGoodList() {
	// List<Good> goosList = new ArrayList<Good>();
	// Good good1 = new Good(1, "����", new BigDecimal("1999"), 90);
	// Good good2 = new Good(2, "����", new BigDecimal("1499"), 60);
	// Good good3 = new Good(3, "�ֻ�", new BigDecimal("999"), 100);
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
			System.out.println("��ѡ����ǣ������Ʒ");
			while (is_go_on.equals("Y")) {
				this.addGood();
				System.out.println("���Ƿ������Y/N");
				is_go_on = sc.next();
			}
			break;
		case 2:
			System.out.println("��ѡ����ǣ���Ʒ�޸�");
			this.updateGood();
			break;
		case 3:
			System.out.println("��ѡ����ǣ���Ʒɾ��");
			this.delGood();
			break;
		case 4:
			System.out.println("��ѡ����ǣ���Ʒ��ѯ");
			this.initGoodList();
			//this.showGoodList();
			break;

		}

	}

	private int showAdminMenu() { // ����Ա�˵�
		System.out.println("*******��ӭ�������Ա�˵�*********");
		System.out.println("1����Ʒ���");
		System.out.println("2����Ʒ�޸�");
		System.out.println("3����Ʒɾ��");
		System.out.println("4����Ʒ��ѯ");
		System.out.println("5���˳�");
		System.out.println("***************************");
		System.out.println("��ѡ��˵����ܣ�");
		int choice = sc.nextInt();
		return choice;
	}

	private void reg() { // ע�Ṧ��
		System.out.println("��ӭע��");
		System.out.println("�������û�����");
		username = sc.next();
		while (true) {
			System.out.println("���������룺");
			password = sc.next();
			System.out.println("��ȷ�����룺");
			String repassword = sc.next();
			if (password.equals(repassword)) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				userList.add(user);
				break;
			} else {
				System.out.println("���벻һ��");
			}
		}
		System.out.println("ע��ɹ�");
	}

	private void login() { // ��¼����
		System.out.println("��ӭ��¼");
		System.out.println("�������û�����");
		String login_username = sc.next();
		boolean loginResult = false;
		while (true) {
			System.out.println("���������룺");
			String login_password = sc.next();
			for (User user : userList) {
				if (login_username.equals(username) && login_password.equals(password)) {
					System.out.println("��¼�ɹ���");
					loginResult = true;
					break;
				}
			}
			if (loginResult == true) {
				break;
			} else {
				System.out.println("��¼ʧ�ܡ�");
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
