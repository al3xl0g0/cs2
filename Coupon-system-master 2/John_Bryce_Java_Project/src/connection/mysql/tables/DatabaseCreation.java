package connection.mysql.tables;


    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

    import utils.ConnectionData;

    public class DatabaseCreation {
        public static void main(String[] args) {

            String sql_companytb = "CREATE TABLE `Company` (\n" +
                    "  `ID` int(20) UNSIGNED NOT NULL,\n" +
                    "  `COMP_NAME` varchar(50) NOT NULL DEFAULT '',\n" +
                    "  `PASSWORD` varchar(50) DEFAULT NULL,\n" +
                    "  `EMAIL` varchar(50) DEFAULT NULL\n" +
                    ")";
            String sql_companydata = "INSERT INTO `Company` (`ID`, `COMP_NAME`, `PASSWORD`, `EMAIL`) VALUES (2, 'Google', '6452341', 'google@gmail.com'), (7, 'PureBeauty', '31234333', 'beautypure@gmail.com'), (16, 'Angel', '4444', 'an@ang.comm'), (17, 'Mr.Backery', '5555', 'foodmarket@gmail.com'), (18, 'Nudels Factory', '6666', 'nudels@gmail.com'), (19, 'BigElectric', '777879', 'electric@gmail.com'), (20, 'BigElectric1', '888098', 'flews@wgmail.com'), (21, 'Tracklin', '8888', 'track@gmail.com'), (22, 'Fast Food', '8888', 'ff@gmail.com'), (23, 'Maps', '8888', 'maps@gmail.com'), (24, 'AmudAnan', '8888', 'amudanan@gmail.com')";

            String sql_company_coupontb = "CREATE TABLE `Company_Coupon` (`COMP_ID` decimal(10,0) NOT NULL, `COUPON_ID` decimal(10,0) NOT NULL)";
            String sql_coupontb = "CREATE TABLE `Coupon` (`ID` int(20) UNSIGNED NOT NULL, `TITLE` varchar(50) NOT NULL DEFAULT '', `START_DATE` date DEFAULT NULL, `END_DATE` date DEFAULT NULL, `AMOUNT` int(20) DEFAULT NULL, `TYPE` varchar(50) DEFAULT '', `MESSAGE` varchar(50) DEFAULT NULL, `PRICE` double DEFAULT NULL, `IMAGE` varchar(50) DEFAULT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1";

            String sql_coupondata = "INSERT INTO `Coupon` (`ID`, `TITLE`, `START_DATE`, `END_DATE`, `AMOUNT`, `TYPE`, `MESSAGE`, `PRICE`, `IMAGE`) VALUES (11, 'Health', '2023-11-04', '2025-11-05', 149, 'HEALTH', 'health service', 150, 'medical'), (107, 'Food', '2019-06-06', '2019-12-12', 298, 'FOOD', 'A food tasting tour', 199, 'food plate'), (108, 'Special vacation', '2020-01-01', '2020-12-31', 498, 'TRAVELLING', 'vacation ', 2000, 'Madrid'), (109, 'Drinks', '2018-03-02', '2018-12-31', 248, 'RESTURANTS', 'Rest', 99, 'coffee'), (117, 'Health Care', '2018-12-01', '2019-01-01', 999, 'HEALTH', 'A Special health care coupon', 300, 'doctor'), (118, 'Camping fun', '2020-12-02', '2020-12-12', 399, 'CAMPING', 'Camping kit', 200, 'fire'), (119, 'Sport star', '2019-04-14', '2021-05-05', 600, 'SPORTS', 'Sport', 400, 'fitness'), (120, 'Dinning', '2025-01-01', '2025-09-09', 300, 'RESTURANTS', 'Dinning', 500, 'food'), (123, 'Breakfast', '2020-03-03', '2022-03-03', 1000, 'RESTURANTS', 'Breakfast', 300, 'nature'), (124,  'TV', '2021-03-04', '2023-03-04', 200, 'ELECTRICITY', 'Get a TV', 2000, 'tv flat'), (125, 'Sport', '2022-01-01', '2022-12-31', 450, 'SPORTS', 'sport kit', 500, 'sport kit'), (126, 'Food2', '2019-01-01', '2019-08-08', 99, 'FOOD', 'big food', 200, 'basket'), (127, 'Beauty', '2021-04-05', '2022-05-05', 349, 'HEALTH', 'health special care', 150, 'woman')";

            String sql_customertb = "CREATE TABLE `Customer` (\n" +
                    "  `ID` int(20) UNSIGNED NOT NULL,\n" +
                    "  `CUST_NAME` varchar(50) NOT NULL DEFAULT '',\n" +
                    "  `PASSWORD` varchar(50) DEFAULT NULL\n" +
                    ")";
            String sql_customerdata = "INSERT INTO `Customer` (`ID`, `CUST_NAME`, `PASSWORD`) VALUES (1, 'User1', '1111'), (3, 'User2', '2222'),(6, 'User3', '3333'),(8, 'User4', '4444'),(9, 'User5', '5555'),(10, 'User6', '6666')";

            String sql_customercoupontb = "CREATE TABLE `Customer_Coupon` (\n" +
                    "  `CUST_ID` decimal(10,0) NOT NULL,\n" +
                    "  `COUPON_ID` decimal(10,0) NOT NULL\n" +
                    ")";
            String sql_customer_coupondata = "INSERT INTO `Customer_Coupon` (`CUST_ID`, `COUPON_ID`) VALUES ('1', '11'), ('1', '107'), ('1', '108'), ('1', '109'), ('3', '117'), ('3', '118'), ('6', '107'), ('6', '127'), ('8', '109')";

            String sql_companysetings = "ALTER TABLE `Company`\n" +
                    "  ADD PRIMARY KEY (`ID`)";
            String sql_company_couponsetings = "ALTER TABLE `Company_Coupon` ADD PRIMARY KEY (`COMP_ID`,`COUPON_ID`)";

            String sql_couponsetings = "ALTER TABLE `Coupon` ADD PRIMARY KEY (`ID`)";

            String sql_customersitings ="ALTER TABLE `Customer`  ADD PRIMARY KEY (`ID`)";

            String sql_customercouponsetings = "ALTER TABLE `Customer_Coupon`\n" +
                    "  ADD PRIMARY KEY (`CUST_ID`,`COUPON_ID`)";
            String  sql_companysettings2 = "ALTER TABLE `Company` MODIFY `ID` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25";

            String  sql_couponsettings2 = "ALTER TABLE `Coupon` MODIFY `ID` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=128";

            String  sql_cutomersettings2 = "ALTER TABLE `Customer` MODIFY `ID` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11";



            try {
                Class.forName(ConnectionData.JDBC_DRIVER);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try (Connection conn = DriverManager.getConnection(ConnectionData.DB_URL, ConnectionData.USER,
                    ConnectionData.PASS);
                   Statement stmt = conn.createStatement();)
            {
                   stmt.executeUpdate(sql_companytb);
                   System.out.println(sql_companytb);
                   stmt.executeUpdate(sql_companydata);
                   System.out.println(sql_companydata);
                   stmt.executeUpdate(sql_company_coupontb);
                   System.out.println(sql_company_coupontb);
                   stmt.executeUpdate(sql_coupontb);
                   System.out.println(sql_coupontb);
                   stmt.executeUpdate(sql_coupondata);
                   System.out.println(sql_coupondata);
                   stmt.executeUpdate(sql_customertb);
                   System.out.println(sql_customertb);
                   stmt.executeUpdate(sql_customerdata);
                   System.out.println(sql_customerdata);
                   stmt.executeUpdate(sql_customercoupontb);
                   System.out.println(sql_customercoupontb);
                   stmt.executeUpdate(sql_companysetings);
                   System.out.println(sql_companysetings);
                   stmt.executeUpdate(sql_company_couponsetings);
                   System.out.println(sql_company_couponsetings);
                   stmt.executeUpdate(sql_couponsetings);
                   System.out.println(sql_couponsetings);
                   stmt.executeUpdate(sql_customer_coupondata);
                   System.out.println(sql_customer_coupondata);
                   stmt.executeUpdate(sql_customersitings);
                   System.out.println(sql_customersitings);
                   stmt.executeUpdate(sql_customercouponsetings);
                   System.out.println(sql_customercouponsetings);
                   stmt.executeUpdate(sql_companysettings2);
                   System.out.println(sql_companysettings2);
                   stmt.executeUpdate(sql_couponsettings2);
                   System.out.println(sql_couponsettings2);
                   stmt.executeUpdate(sql_cutomersettings2);
                   System.out.println(sql_cutomersettings2);

            } catch (SQLException e) {

                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }

