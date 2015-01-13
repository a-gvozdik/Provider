package artemgvozdik.provider.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class Handler {

	
	abstract public void doAction (HttpServletRequest req, HttpServletResponse resp);
}
