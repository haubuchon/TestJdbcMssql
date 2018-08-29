package com.concerti.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TestJdbc {
  public static void main(String[] args) throws Exception {
    Connection conn = getSQLConnection();
    Statement st = conn.createStatement();
    st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT company.* FROM erp.company for browse");
   
    ResultSetMetaData rsMetaData = rs.getMetaData();

    int numberOfColumns = rsMetaData.getColumnCount();
    System.out.println("resultSet MetaData column Count=" + numberOfColumns);
    for (int i = 1; i <= numberOfColumns; i++) {
    	System.out.println("Column: " + rsMetaData.getSchemaName(i) + "." + rsMetaData.getTableName(i) + "." + rsMetaData.getColumnName(i));
    }

    rs.close();
    st.close();
    conn.close();
  }

  private static Connection getSQLConnection() throws Exception {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String url = "jdbc:sqlserver://sv-sql2016;databaseName=ERP10.2.200_Training";
    return DriverManager.getConnection(url, "sa", "Dsic0nseil!");
  }
}