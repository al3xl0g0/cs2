package daoLayer;

import java.sql.SQLException;
import java.util.Collection;

import javaBeans.Company;
import javaBeans.Coupon;
import projectExceptions.DataNotExistException;
import projectExceptions.DuplicateDataException;
import projectExceptions.LogInFailureException;
import projectExceptions.ShutDownException;

/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public interface CompanyDAO {

	// - Abstract methods to create, romove and etc company related actions.

	 void createCompany(Company company) throws SQLException, DuplicateDataException, ShutDownException;

	 void removeCompany(Company Company) throws SQLException, DataNotExistException, ShutDownException;

	 void updateCompany(Company Company) throws SQLException, DataNotExistException, ShutDownException;

	// - Abstract methods to get company related information such as getting
	// company, all companies or all company coupons.

	 Company getCompany(long id) throws SQLException, DataNotExistException, ShutDownException;

	 Collection<Company> getAllCompanies() throws SQLException, DataNotExistException, ShutDownException;

	 Collection<Coupon> getCoupons() throws SQLException, DataNotExistException, ShutDownException;

	// Abstarct login method, for login later use.

	 boolean login(String compName, String password)
			throws SQLException, LogInFailureException, ShutDownException;
}
