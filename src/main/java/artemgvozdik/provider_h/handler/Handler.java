package artemgvozdik.provider_h.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class Handler {

	
	abstract public void doAction (HttpServletRequest req, HttpServletResponse resp);
}
