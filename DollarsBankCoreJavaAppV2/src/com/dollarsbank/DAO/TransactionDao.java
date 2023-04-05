package com.dollarsbank.DAO;

import com.dollarsbank.JDBC.ConnectionManager;
import com.dollarsbank.model.Transaction;

import java.sql.*;
import java.util.ArrayList;

public class TransactionDao {
    Connection conn = ConnectionManager.getConnection();
    public void createTransaction(String type, String description, int accountId) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO transaction(transactionType, transactionDescription, accountId) values (?, ?, ?)");
            st.setString(1, type);
            st.setString(2, description);
            st.setInt(3, accountId);

            st.execute();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public ArrayList<Transaction> getTransactions(int activeAccountId){

        ArrayList<Transaction> transactions = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM transaction where accountId = ? order by transactionTimestamp desc limit 5");
            ps.setInt(1, activeAccountId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Integer id = rs.getInt(1);
                String type = rs.getString(2);
                String description = rs.getString(3);
                Timestamp timestamp = rs.getTimestamp(4);
                Integer accountId = rs.getInt(5);

                transactions.add(new Transaction(type, description, timestamp, accountId));
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return transactions;

    }
}
