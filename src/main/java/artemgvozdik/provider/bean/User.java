package artemgvozdik.provider.bean;
import java.util.Date;


public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name="
				+ last_name + ", address=" + address + ", balans=" + balans
				+ ", birthday=" + birthday + ", email=" + email + ", phone="
				+ phone + ", login=" + login + ", password=" + password
				+ ", mac=" + mac + "]";
	}

	private int id = 0;
	private String first_name;
	private String last_name;
	private String address;
	private int balans;
	private Date birthday;
	private String email;
	private String phone;
	private String login;
	private String password;
	private String mac;
	private String status;
	private int id_tariff;
	
	
	
	
	public int getId_tariff() {
		return id_tariff;
	}

	public void setId_tariff(int id_tariff) {
		this.id_tariff = id_tariff;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBalans() {
		return balans;
	}

	public void setBalans(int balans) {
		this.balans = balans;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	
	
	
}
