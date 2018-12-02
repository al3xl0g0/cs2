package facade;

import java.sql.SQLException;

import javaBeans.ClientType;

/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public interface CouponClientFacade {

	CouponClientFacade login(String name, String password, ClientType clientType) throws SQLException;
}
