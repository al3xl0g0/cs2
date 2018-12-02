package daoLayer;

import java.sql.SQLException;
import java.util.Collection;

import javaBeans.Coupon;
import javaBeans.CouponType;
import projectExceptions.DataNotExistException;
import projectExceptions.DuplicateDataException;
import projectExceptions.ShutDownException;

/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public interface CouponDAO {

	// - Abstract methods to create, romove and etc coupon related actions.


	void createCoupon(Coupon coupon) throws SQLException, DuplicateDataException, ShutDownException;

	void removeCoupon(Coupon coupon) throws SQLException, DataNotExistException, ShutDownException;

	void updateCoupon(Coupon coupon) throws SQLException, DataNotExistException, ShutDownException;

	// - Abstract methods to get coupon related information such as getting
	// coupon, all coupons or all coupons by type .

	Coupon getCoupon(long id) throws SQLException, DataNotExistException, ShutDownException;

	Collection<Coupon> getAllCoupon() throws SQLException, DataNotExistException, ShutDownException;

	Collection<Coupon> getCouponByType(CouponType couponType)
			throws SQLException, DataNotExistException, ShutDownException;

}
