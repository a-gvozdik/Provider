package artemgvozdik.provider.bean;

public class ActiveService {
	private User user;
	private Service service;
	private int ID_order;
	private String status;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public int getID_order() {
		return ID_order;
	}

	public void setID_order(int iD_order) {
		ID_order = iD_order;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
