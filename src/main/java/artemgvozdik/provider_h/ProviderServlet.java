package artemgvozdik.provider_h;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.handler.EmailValid;
import artemgvozdik.provider_h.handler.EmailValidAdmin;
import artemgvozdik.provider_h.handler.Handler;
import artemgvozdik.provider_h.handler.LoginUserHandler;
import artemgvozdik.provider_h.handler.LoginValid;
import artemgvozdik.provider_h.handler.LoginValidAdmin;
import artemgvozdik.provider_h.handler.LogoutHandler;
import artemgvozdik.provider_h.handler.admin.AddAdminHandler;
import artemgvozdik.provider_h.handler.admin.AdminPassReHandler;
import artemgvozdik.provider_h.handler.admin.AllAdminsHandler;
import artemgvozdik.provider_h.handler.admin.DeleteAdminHandler;
import artemgvozdik.provider_h.handler.admin.GetAdminHandler;
import artemgvozdik.provider_h.handler.admin.GetAdminPassHandler;
import artemgvozdik.provider_h.handler.admin.UpdateAdminHandler;
import artemgvozdik.provider_h.handler.service.ActiveServiceChangeStatusHandler;
import artemgvozdik.provider_h.handler.service.AddServiceHandler;
import artemgvozdik.provider_h.handler.service.AllActiveServiceHandler;
import artemgvozdik.provider_h.handler.service.AllServHandler;
import artemgvozdik.provider_h.handler.service.AllServiceHandler;
import artemgvozdik.provider_h.handler.service.DeleteActiveServiceHandler;
import artemgvozdik.provider_h.handler.service.DeleteServiceHandler;
import artemgvozdik.provider_h.handler.service.GetServiceHandler;
import artemgvozdik.provider_h.handler.service.UpdateServiceHandler;
import artemgvozdik.provider_h.handler.tariff.AddTariffHandler;
import artemgvozdik.provider_h.handler.tariff.AllTarHandler;
import artemgvozdik.provider_h.handler.tariff.AllTariffsHandler;
import artemgvozdik.provider_h.handler.tariff.DeleteTariffHandler;
import artemgvozdik.provider_h.handler.tariff.GetTarHandler;
import artemgvozdik.provider_h.handler.tariff.UpdateTariffHandler;
import artemgvozdik.provider_h.handler.user.AddUserHandler;
import artemgvozdik.provider_h.handler.user.AddUserServiceHandler;
import artemgvozdik.provider_h.handler.user.AllUsersHandler;
import artemgvozdik.provider_h.handler.user.ChangeTarHandler;
import artemgvozdik.provider_h.handler.user.DeleteUserHandler;
import artemgvozdik.provider_h.handler.user.GetUserHandler;
import artemgvozdik.provider_h.handler.user.GetUserOrdersHandler;
import artemgvozdik.provider_h.handler.user.GetUserPassHandler;
import artemgvozdik.provider_h.handler.user.UpdateUserHandler;
import artemgvozdik.provider_h.handler.user.UserPassReHandler;

public class ProviderServlet extends HttpServlet {
	static Logger logger = Logger.getLogger(ProviderServlet.class);
	Map<String, Handler> urls;
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		logger.info("init() method started");
		super.init();
		urls = new HashMap<String, Handler>();
		urls.put("/ProviderServlet/addUser", new AddUserHandler());
		urls.put("/ProviderServlet/deleteUser", new DeleteUserHandler());
		urls.put("/ProviderServlet/login", new LoginUserHandler());
		urls.put("/ProviderServlet/alluserlist", new AllUsersHandler());
		urls.put("/ProviderServlet/getuser", new GetUserHandler());
		urls.put("/ProviderServlet/getuserpass", new GetUserPassHandler());
		urls.put("/ProviderServlet/updateUser", new UpdateUserHandler());
		urls.put("/ProviderServlet/addAdmin", new AddAdminHandler());
		urls.put("/ProviderServlet/alladmins", new AllAdminsHandler());
		urls.put("/ProviderServlet/updateUserPass", new UserPassReHandler());
		urls.put("/ProviderServlet/checkLogin", new LoginValid());
		urls.put("/ProviderServlet/checkMail", new EmailValid());
		urls.put("/ProviderServlet/checkLoginAdmin", new LoginValidAdmin());
		urls.put("/ProviderServlet/checkMailAdmin", new EmailValidAdmin());
		urls.put("/ProviderServlet/getadmin", new GetAdminHandler());
		urls.put("/ProviderServlet/updateAdmin", new UpdateAdminHandler());
		urls.put("/ProviderServlet/deleteAdmin", new DeleteAdminHandler());
		urls.put("/ProviderServlet/logout", new LogoutHandler());
		urls.put("/ProviderServlet/getadminpass", new GetAdminPassHandler());
		urls.put("/ProviderServlet/updateAdminPass", new AdminPassReHandler());
		urls.put("/ProviderServlet/alltariffs", new AllTariffsHandler());
		urls.put("/ProviderServlet/addTariff", new AddTariffHandler());
		urls.put("/ProviderServlet/updateTariff", new UpdateTariffHandler());
		urls.put("/ProviderServlet/gettariff", new GetTarHandler());
		urls.put("/ProviderServlet/deleteTariff", new DeleteTariffHandler());
		urls.put("/ProviderServlet/alltar", new AllTarHandler());
		urls.put("/ProviderServlet/changeUserTar", new ChangeTarHandler());
		urls.put("/ProviderServlet/allservice", new AllServiceHandler());
		urls.put("/ProviderServlet/addService", new AddServiceHandler());
		urls.put("/ProviderServlet/updateService", new UpdateServiceHandler());
		urls.put("/ProviderServlet/getservice", new GetServiceHandler());
		urls.put("/ProviderServlet/deleteService", new DeleteServiceHandler());
		urls.put("/ProviderServlet/allserv", new AllServHandler());
		urls.put("/ProviderServlet/orderUserServ", new AddUserServiceHandler());
		urls.put("/ProviderServlet/userorders", new GetUserOrdersHandler());
		urls.put("/ProviderServlet/activeservice", new AllActiveServiceHandler());
		urls.put("/ProviderServlet/changeServiceStatus", new ActiveServiceChangeStatusHandler());
		urls.put("/ProviderServlet/deleteActiveService", new DeleteActiveServiceHandler());
		
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
