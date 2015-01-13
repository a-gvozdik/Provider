package artemgvozdik.provider.tests.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import artemgvozdik.provider.bean.Admin;
import artemgvozdik.provider.dao.AdminDAO;

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
		admin = adao.getAdmin(2);
		assertNotNull(admin);
		
	}
	
	@Test
	public void testGetAdminName (){
		AdminDAO adao = new AdminDAO ();
		Admin admin = new Admin ();
		admin = adao.getAdmin(2);
		String aname = "Bob";
		assertEquals(admin.getFirst_name(), aname);
		
	}
	
	@Test
	public void testNotSame (){
		AdminDAO adao = new AdminDAO ();
		Admin admin = new Admin ();
		Admin admin2 = new Admin ();
		admin = adao.getAdmin(2);
		admin2 = adao.getAdmin(4);
		assertNotSame (admin, admin2);
	}

}
