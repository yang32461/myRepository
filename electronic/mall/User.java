package electronic.mall;

public class User extends Good {

	public void showGoodList() {
		System.out.println("商品列表如下:");
		for (Good good : goodList) {
			System.out.println(good);
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String username;
	private String password;
	private boolean isLogin;
	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	} 

}
