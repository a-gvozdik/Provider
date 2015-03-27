package artemgvozdik.provider_h.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Users")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id = 0;
	
	

	@Column(name = "First_name")
	private String first_name;
	
	@Column(name = "Last_name")
	private String last_name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "balans")
	private double balans;
	
	@Column(name = "birthday")
	@Temporal (TemporalType.DATE)
	private Date birthday;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phone;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "MAC")
	private String mac;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
    @JoinColumn(name = "id_tariff")
	private Tariff tariff;

	public Tariff getTariff() {
		return tariff;
	}

	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
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

	public double getBalans() {
		return balans;
	}

	public void setBalans(double balans) {
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name="
				+ last_name + ", address=" + address + ", balans=" + balans
				+ ", birthday=" + birthday + ", email=" + email + ", phone="
				+ phone + ", login=" + login + ", password=" + password
				+ ", mac=" + mac + ", status=" + status + ", tariff=" + tariff.getName()
				+ ", tariff.price=" + tariff.getPrice() + "]";
	}

}
