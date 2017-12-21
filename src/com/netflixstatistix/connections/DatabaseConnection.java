package com.netflixstatistix.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    final String serverAdres = "multiplicity.softether.net";
    final int serverPort = 6667;
    final String dbUserName = "sa";
    final String dbPassword = "MarlBoroq17";
    final String databaseName = "NetflixStatistix";
    final String connectionUrl = "jdbc:sqlserver://" + serverAdres + ":" + serverPort + ";databaseName=" + databaseName + ";user=" + dbUserName + ";password=" + dbPassword;
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public DatabaseConnection() {

    }

    public ResultSet getData(String SQL) {
        try {
            openConnection();
            stmt = con.createStatement();
            this.rs = this.stmt.executeQuery(SQL);
            return this.rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            while (this.con != null) {
                closeConnection();
            }
        }
    }

    private void openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.con = DriverManager.getConnection(this.connectionUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void closeConnection() {
        if (this.con != null || this.stmt != null || this.con != null) {
            this.stmt = null;
            this.rs = null;
            this.con = null;
        }

    }
    public Connection getCon() {
        return con;
    }
}