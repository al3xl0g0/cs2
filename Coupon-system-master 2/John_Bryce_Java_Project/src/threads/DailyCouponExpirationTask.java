package threads;

import projectExceptions.DataNotExistException;
import projectExceptions.ShutDownException;
import utils.CouponExceptionConstants;
import facade.AdminFacade;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import  daoLayer.CouponDBDAO;
import connection.ConnectionPool;
import javaBeans.Coupon;


public class DailyCouponExpirationTask implements Runnable, Serializable {
    private static final long serialVersionUID = 1L;
    private static LocalDate localDate;
    private static Date currentDate;
    private AdminFacade adminFacade = new AdminFacade();
    private boolean quite = false;


    @Override
    public void run() {
        while (!this.quite) {
            ArrayList<Long> expiredCouponID = new ArrayList<>();
            Coupon coupon = null;
            
            try {
                ConnectionPool pool = ConnectionPool.getInstance();
                Connection conn = pool.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM coupn_db_test2.coupon WHERE END_DATE < current_date()");
                
                while (resultSet.next() && !this.quite) {
                    long coupon_id = resultSet.getLong("ID");
                    expiredCouponID.add(coupon_id);
                }
    
                Iterator deleteCouponID = expiredCouponID.iterator();
                
                while (deleteCouponID.hasNext() && !this.quite) {
                    long couponToDeleteID =(Long)deleteCouponID.next();
                    coupon = this.adminFacade.getCouponDBDAO().getCoupon(couponToDeleteID);
                    this.adminFacade.getCouponDBDAO().removeCoupon(coupon);
                }
                
                ConnectionPool.getInstance().returnConnection(conn);
                System.out.println(" System updated.\n and old coupons had benn removed.");
                Thread.sleep(86400000L);
            } catch (SQLException | InterruptedException | DataNotExistException | ShutDownException dcetE0) {
                dcetE0.getMessage();
            } /*catch (CouponNotFoundException dcetE1) {
                System.out.println(dcetE1.getMessage());
                System.out.println("coupon "+coupon.getTitle()+" failed to be removed.\nIt maybe doesn't exist.");
            }*/
        }
    }
    
    public boolean isQuite() {
        return this.quite;
    }
    
    public void setQuite(boolean quite){
        this.quite=quite;
    }
    
    public static Date getLastDate() {
        return currentDate;
    }
    
    public static Date getCurrentDate() {
        localDate = LocalDate.now();
        currentDate = java.sql.Date.valueOf(localDate);
        return currentDate;
    }


}