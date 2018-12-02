package daoLayer;

import java.sql.SQLException;
import java.util.Collection;

import javaBeans.Coupon;
import javaBeans.Customer;
import projectExceptions.DataNotExistException;
import projectExceptions.DuplicateDataException;
import projectExceptions.LogInFailureException;
import projectExceptions.ShutDownException;

/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public interface CustomerDAO {

	// - Abstract methods to create, romove and etc customer related actions.

	public void createCustomer(Customer customer) throws SQLException, DuplicateDataException, ShutDownException;

	public void removeCustomer(Customer customer) throws SQLException, DataNotExistException, ShutDownException;

	public void updateCustomer(Customer customer) throws SQLException, DataNotExistException, ShutDownException;

	// - Abstract methods to get customer related information such as getting
	// customer, all customers or all customer coupons.
	public Customer getCustomer(long id) throws SQLException, DataNotExistException, ShutDownException;

	public Collection<Customer> getAllCustomers() throws SQLException, DataNotExistException, ShutDownException;

	public Collection<Coupon> getCoupons() throws SQLException, DataNotExistException, ShutDownException;

	// Abstarct login method, for login later use.

	public boolean login(String custName, String password)
			throws SQLException, LogInFailureException, ShutDownException;

}
