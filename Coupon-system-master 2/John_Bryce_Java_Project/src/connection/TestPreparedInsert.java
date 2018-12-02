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

import java.sql.Connection;

public class TestPreparedInsert {
    public static void main(String[] args) throws Exception {
        AdminFacade adminF = (AdminFacade) CouponSystem.getInstance().login("admin", "1234", ClientType.ADMIN);

        Company company = new Company();
        company.setCompName("FoodliC1212312");
        company.setPassword("77787");
        company.setEmail("el2zadsf@gmail.com");
        adminF.createCompany(company);
        System.out.println("Company Created " + company);
        printItem(adminF.getAllCompanies());



        company.setEmail("el34f89@walla.com");
        company.setPassword("8888");

        adminF.updateCompany(company);

        //System.out.println(adminF.getCompany(22));

        //Error ID find and repair !
       // Company existingCompanyForRemove = new Company();
        // existingCompanyForRemove.setId(16);
        // existingCompanyForRemove.setCompName("Angel");
        //existingCompanyForRemove.setPassword("4444");
       // existingCompanyForRemove.setEmail("angel@ang.comm");
       // adminF.removeCompany(existingCompanyForRemove);


       /* printItem(adminF.getAllCompanies());

        Customer customer = new Customer();
        customer.setCustName("Joert Dar");
        customer.setPassword("6666");

        adminF.createCustomer(customer);

        System.out.println(adminF.getCustomer(1));*/





    }
    private static void printItem(Collection<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
