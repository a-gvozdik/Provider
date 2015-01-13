package artemgvozdik.provider.handler;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artemgvozdik.provider.ConnectionFactory;

public class EmailValid extends Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html;charset=UTF-8");  
        try (Connection con = ConnectionFactory.getConnection(); PrintWriter out = resp.getWriter()) { 
        	
        	String email = req.getParameter("mail");
        	PreparedStatement st = con
					.prepareStatement("SELECT * FROM users WHERE email = ?");
			st.setString(1, email);
            ResultSet rs = st.executeQuery();  
               
            if (!rs.next()) {  
                out.println("<font color=\"green\"><b>"+email+"</b> is avaliable</font>");  
            }  
            else{  
            out.println("<font color=\"red\"><b>"+email+"</b> is already in use</font>");  
            }  
            out.println();  
  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        } 

	}

}
