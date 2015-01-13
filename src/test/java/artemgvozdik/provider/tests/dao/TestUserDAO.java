package artemgvozdik.provider.tests.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import artemgvozdik.provider.bean.User;
import artemgvozdik.provider.dao.UserDAO;

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
	
	@Test
	public void testNotSame () {
		UserDAO udao = new UserDAO ();
		User user = new User ();
		User user2 = new User ();
		user = udao.get(1);
		user2 = udao.get(2);
		assertNotSame(user, user2);
	}

}
