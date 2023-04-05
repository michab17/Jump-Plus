package com.dollarsbank.DAO;

import com.dollarsbank.JDBC.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class AccountDao {
    private final Connection conn = ConnectionManager.getConnection();
    public boolean checkCredentials(String username, String pin) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM account WHERE username = ? AND pin = ?");
            st.setString(1, username);
            st.setString(2, pin);

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

    public boolean createAccount(String username, String pin, Double availableFunds) {

        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO account(username, pin, availableFunds) values (?, ?, ?)");
            st.setString(1, username);
            st.setString(2, pin);
            st.setDouble(3, availableFunds);

            st.execute();

            st.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deposit(int accountId, Double amount)  {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE account SET availableFunds = availableFunds + ? WHERE accountId = ?");
            st.setDouble(1, amount);
            st.setInt(2, accountId);

            st.execute();

            st.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean withdraw(int accountId, Double amount)  {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE account SET availableFunds = availableFunds - ? WHERE accountId = ?");
            st.setDouble(1, amount);
            st.setInt(2, accountId);

            st.execute();

            st.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getAccountId(String username) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT accountId FROM account WHERE username = ?");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return rs.getInt("accountId");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public int getAvailableFunds(int accountId) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT availableFunds FROM account WHERE accountId = ?");
            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return rs.getInt("availableFunds");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public int getPin(int accountId) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT pin FROM account WHERE accountId = ?");
            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return rs.getInt("pin");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public String getUsername(int accountId) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT username FROM account WHERE accountId = ?");
            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return rs.getString("username");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return "";
    }

    public ArrayList<String> getUsernames() {
        ArrayList<String> accountNames = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT username FROM account");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String username = rs.getString(1);
                accountNames.add(username);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return accountNames;
    }
}
