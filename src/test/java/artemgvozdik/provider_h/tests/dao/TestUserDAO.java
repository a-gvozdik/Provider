package artemgvozdik.provider_h.tests.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import artemgvozdik.provider_h.bean.User;
import artemgvozdik.provider_h.dao.UserDAO;

public class TestUserDAO {
	
	@Test
	public void testGetAll () {
		UserDAO udao = new UserDAO ();
		List <User> userslist = new ArrayList <User>();
		userslist = udao.getAll();
		assertFalse(userslist.isEmpty());
	}
	
	@Test
	public void testGetUser (){
		UserDAO udao = new UserDAO ();
		User user = new User ();
		user = udao.get(1);
		assertNotNull(user);
		
	}
	
	@Test
	public void testGetUserName (){
		UserDAO udao = new UserDAO ();
		User user = new User ();
		user = udao.get(1);
		String uname = "Vasya";
		assertEquals(user.getFirst_name(), uname);
		
	}
	
	
}
