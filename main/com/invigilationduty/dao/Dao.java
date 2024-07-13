package main.com.invigilationduty.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class Dao {
    private final static String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
    private final static String CONNECTION_URL="jdbc:mysql://localhost:3306/miniproject";
    private final static String USERNAME="root";
    private final static String PASSWORD="AdharshReddy@150603";

    static {
        try {
            Class.forName( DRIVER_CLASS );
        } catch( ClassNotFoundException cnfEx ) {
            cnfEx.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection( CONNECTION_URL, USERNAME, PASSWORD );
        } catch( SQLException sqlEx ) {
            sqlEx.printStackTrace();
        }
        return conn;
    }
    public void closeConnection( Connection conn ) {
        try {
            if( conn != null ) {
                conn.close();
            }
        } catch( SQLException sqlEx ) {
            sqlEx.printStackTrace();
        }
    }

    public Statement getStatement(Connection conn ) {
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
        } catch( SQLException sqlEx ) {
            sqlEx.printStackTrace();
        }
        return stmt;
    }
    public void closeStatement( Statement stmt ) {
        try {
            if( stmt != null ) {
                stmt.close();
            }
        } catch( SQLException sqlEx ) {
            sqlEx.printStackTrace();
        }
    }
    public PreparedStatement getPreparedStatement(Connection con, String sql) {
        PreparedStatement pStmt = null;

        try {
            pStmt = con.prepareStatement(sql);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return pStmt;
    }

    public void closePreparedStatement(PreparedStatement pStmt) {
        try {
            if (pStmt != null) {
                pStmt.close();
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public ResultSet getResultSet(PreparedStatement pStmt) {
        ResultSet rs = null;

        try {
            rs = pStmt.executeQuery();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return rs;
    }
    public ResultSet getResultSet(Statement stmt, String sql) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return rs;
    }
    public void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}
