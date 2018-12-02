package connection;

import java.sql.SQLException;

import facade.AdminFacade;
import facade.CompanyFacade;
import facade.CouponClientFacade;
import facade.CustomerFacade;
import javaBeans.ClientType;
import threads.DailyCouponExpirationTask;
import java.util.Scanner;

/**
 * This is the singleton pattern coupon system of the project, that returns the
 * right facade object if the login attempt is successful. And by that the user
 * can check or make actions in the program. Also starts the Daily task thread
 * for deleting unnecessary coupons. And is able to shut down the system.
 /**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public final class CouponSystem {

	// task - the daily coupon task thread.
	private DailyCouponExpirationTask task;

	// instance - the coupon system instance.
	private static CouponSystem instance = null;

	/**
	 * Constructs the coupon system while starting the daily task thread (which
	 * is daemon).
	 */
	private CouponSystem() {
		task = new DailyCouponExpirationTask();
		Thread taskThread = new Thread(task);
		taskThread.setDaemon(true);
		taskThread.start();
	}

	/**
	 * Instantiating the coupon system or getting it's instance (if it's already
	 * have been instantiated). Enabling the user to attempt login to the
	 * program.
	 * 
	 * @return instance - the coupon system instance.
	 */
	public synchronized static CouponSystem getInstance() {

		if (instance == null) {

			instance = new CouponSystem();
		}
		return instance;
	}

	/**
	 * The login method that receives parameters and according to the client
	 * type, attempts login at the specific facade, while returning a facade
	 * object if the login was successful.
	 * 
	 * @param name
	 *            - the user's name.
	 * @param password
	 *            - the user's password.
	 * @param clientType
	 *            - the client type of the user.
	 * @return - result.login - the facade if the login was successful, or null
	 *         if not.
	 * @throws SQLException
	 *             - when sql related errors accur.
	 */
	public CouponClientFacade login(String name, String password, ClientType clientType) throws SQLException {

		// result is an object CouponClientFacade type, in start value null. For
		// later facade use.
		CouponClientFacade result = null;

		// Test UCI

		//

		switch (clientType) {
		case ADMIN:
			result = new AdminFacade();
			break;

		case COMPANY:
			result = new CompanyFacade();
			break;

		case CUSTOMER:
			result = new CustomerFacade();
			break;
		}

		return result.login(name, password, clientType);
	}

	/**
	 * To activate the shut down of the system. Starting at stopping the daily
	 * task thread, and after that, closing all connections and exiting.
	 *
	 */


	public void shutdown() {

		task.setQuite(true);
		try {
			ConnectionPool.getInstance().closeAllConnections();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		System.exit(0);
	}
}
