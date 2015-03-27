package artemgvozdik.provider_h.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id = 0;
	
	@Column(name = "First_name")
	private String first_name;
	
	@Column(name = "Last_name")
	private String last_name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phone;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	
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


	@Override
	public String toString() {
		return "Admin [id=" + id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", phone="
				+ phone + ", login=" + login + ", password=" + password + "]";
	}
	
}
