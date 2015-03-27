package artemgvozdik.provider_h.tests.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import artemgvozdik.provider_h.bean.Admin;
import artemgvozdik.provider_h.dao.AdminDAO;

public class TestAdminDAO {
	
	@Test
	public void testGetAll () {
		AdminDAO adao = new AdminDAO ();
		List <Admin> adminslist = new ArrayList <Admin>();
		adminslist = adao.getAll();
		assertFalse(adminslist.isEmpty());
	}
	
	@Test
	public void testGetAdmin (){
		AdminDAO adao = new AdminDAO ();
		Admin admin = new Admin ();
		admin = adao.getAdmin(4);
		assertNotNull(admin);
		
	}
	
	
}
