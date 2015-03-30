package artemgvozdik.provider_h.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {

	public void doAction (HttpServletRequest req, HttpServletResponse resp);
}
