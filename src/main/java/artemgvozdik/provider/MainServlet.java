package artemgvozdik.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider.handler.EmailValid;
import artemgvozdik.provider.handler.Handler;
import artemgvozdik.provider.handler.LoginUserHandler;
import artemgvozdik.provider.handler.LoginValid;
import artemgvozdik.provider.handler.LogoutHandler;
import artemgvozdik.provider.handler.admin.AddAdminHandler;
import artemgvozdik.provider.handler.admin.AdminPassReHandler;
import artemgvozdik.provider.handler.admin.AllAdminsHandler;
import artemgvozdik.provider.handler.admin.DeleteAdminHandler;
import artemgvozdik.provider.handler.admin.GetAdminHandler;
import artemgvozdik.provider.handler.admin.GetAdminPassHandler;
import artemgvozdik.provider.handler.admin.UpdateAdminHandler;
import artemgvozdik.provider.handler.service.ActiveServiceChangeStatusHandler;
import artemgvozdik.provider.handler.service.AddServiceHandler;
import artemgvozdik.provider.handler.service.AllActiveServiceHandler;
import artemgvozdik.provider.handler.service.AllServHandler;
import artemgvozdik.provider.handler.service.AllServiceHandler;
import artemgvozdik.provider.handler.service.DeleteActiveServiceHandler;
import artemgvozdik.provider.handler.service.DeleteServiceHandler;
import artemgvozdik.provider.handler.service.GetServiceHandler;
import artemgvozdik.provider.handler.service.UpdateServiceHandler;
import artemgvozdik.provider.handler.tariff.AddTariffHandler;
import artemgvozdik.provider.handler.tariff.AllTarHandler;
import artemgvozdik.provider.handler.tariff.AllTariffsHandler;
import artemgvozdik.provider.handler.tariff.ChangeTarHandler;
import artemgvozdik.provider.handler.tariff.DeleteTariffHandler;
import artemgvozdik.provider.handler.tariff.GetTarHandler;
import artemgvozdik.provider.handler.tariff.UpdateTariffHandler;
import artemgvozdik.provider.handler.user.AddUserHandler;
import artemgvozdik.provider.handler.user.AddUserServiceHandler;
import artemgvozdik.provider.handler.user.AllUsersHandler;
import artemgvozdik.provider.handler.user.DeleteUserHandler;
import artemgvozdik.provider.handler.user.GetUserHandler;
import artemgvozdik.provider.handler.user.GetUserOrdersHandler;
import artemgvozdik.provider.handler.user.GetUserPassHandler;
import artemgvozdik.provider.handler.user.UpdateUserHandler;
import artemgvozdik.provider.handler.user.UserPassReHandler;

public class MainServlet extends HttpServlet {
	static Logger logger = Logger.getLogger(MainServlet.class);
	Map<String, Handler> urls;
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		logger.info("init() method started");
		super.init();
		urls = new HashMap<String, Handler>();
		urls.put("/MainServlet/addUser", new AddUserHandler());
		urls.put("/MainServlet/deleteUser", new DeleteUserHandler());
		urls.put("/MainServlet/login", new LoginUserHandler());
		urls.put("/MainServlet/alluserlist", new AllUsersHandler());
		urls.put("/MainServlet/getuser", new GetUserHandler());
		urls.put("/MainServlet/getuserpass", new GetUserPassHandler());
		urls.put("/MainServlet/updateUser", new UpdateUserHandler());
		urls.put("/MainServlet/addAdmin", new AddAdminHandler());
		urls.put("/MainServlet/alladmins", new AllAdminsHandler());
		urls.put("/MainServlet/updateUserPass", new UserPassReHandler());
		urls.put("/MainServlet/checkLogin", new LoginValid());
		urls.put("/MainServlet/checkMail", new EmailValid());
		urls.put("/MainServlet/getadmin", new GetAdminHandler());
		urls.put("/MainServlet/updateAdmin", new UpdateAdminHandler());
		urls.put("/MainServlet/deleteAdmin", new DeleteAdminHandler());
		urls.put("/MainServlet/logout", new LogoutHandler());
		urls.put("/MainServlet/getadminpass", new GetAdminPassHandler());
		urls.put("/MainServlet/updateAdminPass", new AdminPassReHandler());
		urls.put("/MainServlet/alltariffs", new AllTariffsHandler());
		urls.put("/MainServlet/addTariff", new AddTariffHandler());
		urls.put("/MainServlet/updateTariff", new UpdateTariffHandler());
		urls.put("/MainServlet/gettariff", new GetTarHandler());
		urls.put("/MainServlet/deleteTariff", new DeleteTariffHandler());
		urls.put("/MainServlet/alltar", new AllTarHandler());
		urls.put("/MainServlet/changeUserTar", new ChangeTarHandler());
		urls.put("/MainServlet/allservice", new AllServiceHandler());
		urls.put("/MainServlet/addService", new AddServiceHandler());
		urls.put("/MainServlet/updateService", new UpdateServiceHandler());
		urls.put("/MainServlet/getservice", new GetServiceHandler());
		urls.put("/MainServlet/deleteService", new DeleteServiceHandler());
		urls.put("/MainServlet/allserv", new AllServHandler());
		urls.put("/MainServlet/orderUserServ", new AddUserServiceHandler());
		urls.put("/MainServlet/userorders", new GetUserOrdersHandler());
		urls.put("/MainServlet/activeservice", new AllActiveServiceHandler());
		urls.put("/MainServlet/changeServiceStatus", new ActiveServiceChangeStatusHandler());
		urls.put("/MainServlet/deleteActiveService", new DeleteActiveServiceHandler());
		
		logger.info("init() method finished");
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		urls.get(req.getRequestURI()).doAction(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
