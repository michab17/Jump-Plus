package com.app.DAO;

import com.app.JDBC.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDao {

    private static final Connection conn = ConnectionManager.getConnection();

    public boolean checkCredentials(String email, String password) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM account WHERE email = ? AND password = ?");
            st.setString(1, email);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();

            if(rs.next()) {
                rs.close();
                st.close();

                return true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean createAccount(String email, String password) {

        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO account(email, password) values (?, ?)");
            st.setString(1, email);
            st.setString(2, password);

            st.execute();

            st.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
