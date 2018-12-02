package utils;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import daoLayer.CouponDBDAO;
import javaBeans.Coupon;
import projectExceptions.DataNotExistException;
import projectExceptions.ShutDownException;

/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public class DailyCouponExpirationTask implements Runnable {

	private CouponDBDAO couponDBDAO;
	// flag to indicate if system running.
	private boolean runningFlag = true;

	/**
	 * constructs the DailyCouponExpirationTask and creating a new couponDBDAO
	 * object for the thread's use.
	 */
	public DailyCouponExpirationTask() {
		couponDBDAO = new CouponDBDAO();
	}

	/**
	 * the run method that the DailyCouponExpirationTask runs in after it is
	 * started. in this method it runs in a loop on all the coupons in the
	 * system and checks if it's expired. if so, it deletes them. After it
	 * finishes it goes to sleep for 24 hour and than it repeats the process.
	 * While it's checking and deleting coupons it verifies that the running
	 * flag is true. if not (Because the stop task has been activated), it
	 * returns from the method.
	 */
	@Override
	public void run() {
		// current calender objct.
		Calendar cal = Calendar.getInstance();
		// current date object.
		Date currentDate = null;
		currentDate = (Date) cal.getTime();
		try {
			while (runningFlag) {
				// list of all coupons.
				Collection<Coupon> allCoupons = couponDBDAO.getAllCoupon();

				for (Coupon coupon : allCoupons) {
					if (runningFlag) {
						if (coupon.getEndDate().before(currentDate)) {
							couponDBDAO.removeCoupon(coupon);
							System.out.println("Test Daily CouponExpiration task");
						}
					} else {
						return;
					}
				}
				TimeUnit.DAYS.sleep(1);
			}

		} catch (SQLException | DataNotExistException | InterruptedException | ShutDownException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This method is called from the shutDown method in the coupon system class
	 * and sets the runnigFlag boolean to false, indicating to the thread, that
	 * it should not continue and return from the method (if he is not
	 * sleeping).
	 */
	public void stopTask() {
		runningFlag = false;
	}
}
