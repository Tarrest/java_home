package com.chisw.work.addressbook.test;

import com.chisw.work.addressbook.Data.GroupData;
import com.chisw.work.addressbook.Data.Groups;
import org.testng.annotations.Test;

import java.sql.*;

public class DbConnectionTest {

    @Test
    public void checkDbConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=&serverTimezone=UTC");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
            Groups groups = new Groups();
            while (rs.next()) {
                groups.add(new GroupData().withId(rs.getInt("group_id")).withGroupName(rs.getString("group_name"))
                        .withGroupLogo(rs.getString("group_header")).withGroupComment(rs.getString("group_footer")));
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println(groups);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
}
