package artemgvozdik.provider.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import artemgvozdik.provider.bean.User;

public class UserPagesFilter implements Filter {
	static Logger logger = Logger.getLogger(UserPagesFilter.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain fc) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null || session == null) {

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/denied.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				logger.error("Exception ", e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("Exception ", e);
			}
		}
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate"); // Preventing User to go
														// back after logout in
														// jsp with BackButton
														// in browser
		fc.doFilter(req, response);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
