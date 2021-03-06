package connection;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import facade.AdminFacade;
import facade.CompanyFacade;
import facade.CustomerFacade;
import javaBeans.ClientType;
import javaBeans.Company;
import javaBeans.Coupon;
import javaBeans.CouponType;
import javaBeans.Customer;


/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.2 November 11, 2018.
 */
public class Main {

	public static void main(String[] args) throws Exception {



		System.out.println("Starting application");



		/* ADMIN FACADE */

		AdminFacade adminF = (AdminFacade) CouponSystem.getInstance().login("admin", "1234", ClientType.ADMIN);



		/* ADIMIN FACADE - COMPANY METHODS */

		/* CREATE COMPANY */

		Company company = new Company();
		company.setCompName("FoodliC12");
		company.setPassword("77787");
		company.setEmail("el2zadsf@gmail.com");

		adminF.createCompany(company);
		System.out.println("Company Created " + company);
		printItem(adminF.getAllCompanies());


		//* UPDATE COMPANY *//*

		company.setEmail("el34f@walla.com");
		company.setPassword("8888");

		adminF.updateCompany(company);

		//* GET COMPANY BY ID *//*

		System.out.println(adminF.getCompany(20));

		//* REMOVE COMPANY *//*
		//* The Company with the name "Angel" already exists in the DB *//*
		//company.
		/*Company exsistingCompanyForRemove = new Company();
		exsistingCompanyForRemove.setCompName("Angel");
		exsistingCompanyForRemove.setPassword("4444");
		exsistingCompanyForRemove.setEmail("angel@ang.comm");
*/
		Company company1 = new Company();
		company.setCompName("FoodliC12");
		adminF.removeCompany(company1);

		//* GET ALL COMPANIES *//*

		printItem(adminF.getAllCompanies());

		//* ADMIN CUSTOMER METHODS *//

		//* CREATE CUSTOMER *//

		Customer customer = new Customer();
		customer.setCustName("Joe Dar");
		customer.setPassword("666");

		adminF.createCustomer(customer);

		//* UPDATE CUSTOMER *//*

		customer.setPassword("999");
		adminF.updateCustomer(customer);

		//* GET CUSTOMER *//*

		System.out.println(adminF.getCustomer(1));


		 //* REMOVE CUSTOMER *//
		//*
		 // The Customer with the name "Abraham Mozes" already exists in the DB


		Customer exsistingCustomerForRemove = new Customer();
		exsistingCustomerForRemove.setCustName("Abraham Mozes");
		exsistingCustomerForRemove.setPassword("444");

		adminF.removeCustomer(exsistingCustomerForRemove);

		//* GET ALL CUSTOMER *//*

		//printItem(adminF.getAllCustomers());

		//* COMPANY FACADE METHODS *//*

		CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login("Hush Puppies", "1111",
				ClientType.COMPANY);

		//* CREATE COUPON *//*

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse("2018-07-07");
		Date endDate = sdf.parse("2019-04-01");

		Coupon coupon = new Coupon();
		coupon.setTitle("Perks21");
		coupon.setStartDate(startDate);
		coupon.setEndDate(endDate);
		coupon.setAmount(500);
		coupon.setType(CouponType.SPORTS);
		coupon.setMessage("The best coupon1");
		coupon.setPrice(299.0);
		coupon.setImage("sport star1");

		//companyFacade.createCoupon(coupon);

		//* UPDATE COUPON *//*

		/*Date endDateUpdate = sdf.parse("2022-07-07");
		coupon.setEndDate(endDateUpdate);
		coupon.setPrice(1000);

		companyFacade.updateCoupon(coupon);*/

		//* GET COUPON *//*

		//System.out.println(companyFacade.getCoupon(10));

		//* REMOVE COUPON *//*

		//companyFacade.removeCoupon(coupon);

		//* GET ALL COUPONS *//*

//		printItem(companyFacade.getAllCoupons());

		//* GET COUPON BY TYPE *//*

	//	printItem(companyFacade.getCouponsByType(CouponType.HEALTH));

		//* GET COUPON BY PRICE *//

	//	printItem(companyFacade.getCouponsByPrice(150));

		//* GET COUPON BY DATE *//

	//	Date date = sdf.parse("2027-07-07");

	//	printItem(companyFacade.getCouponsByDate(date));

		/* CUSTOMER FACADE METHODS */

	//	CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login("John Day", "111",
			//	ClientType.CUSTOMER);

		//* PURCHASE COUPON *//

	//	customerFacade.purchaseCoupon(companyFacade.getCoupon(30));

		//* GET ALL PURCHASED COUPONS *//

	//	printItem(customerFacade.getAllPurchasedCoupons());

		//* GET ALL PURCHASED COUPONS BY TYPE *//

	//	printItem(customerFacade.getAllPurchasedCouponsByType(CouponType.HEALTH));

		/* GET ALL PURCHASED COUPONS BY PRICE */

	//	printItem(customerFacade.getAllPurchasedCouponsByPrice(150));
	//	CouponSystem.getInstance().shutdown();
	}

	private static void printItem(Collection<?> list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}
}
