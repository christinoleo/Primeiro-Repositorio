package br.sienaidea.leonardo.helloworld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicJDBCDemo {

	Connection conn;

	public BasicJDBCDemo() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			String url = "jdbc:postgresql://localhost/postgres";
			conn = DriverManager.getConnection(url, "postgres", "1234554321");
			doTests();
			conn.close();
		} catch (ClassNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IllegalAccessException ex) {
			System.err.println(ex.getMessage());
		} catch (InstantiationException ex) {
			System.err.println(ex.getMessage());
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doCreate() {
		System.out.print("\n[Performing CREATE] ... ");
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("CREATE TABLE COFFEES (COF_NAME VARCHAR(30), QNT INTEGER, PRICE FLOAT, VAR1 INTEGER, VAR2 INTEGER)");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doDeleteTest() {
		System.out.print("\n[Performing DELETE] ... ");
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM COFFEES WHERE COF_NAME='BREAKFAST BLEND'");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doInsertTest() {
		System.out.print("\n[Performing INSERT] ... ");
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO COFFEES "
					+ "VALUES ('BREAKFAST BLEND', 200, 7.99, 0, 0)");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doSelectTest() {
		System.out.println("[OUTPUT FROM SELECT]");
		String query = "SELECT COF_NAME, PRICE FROM COFFEES";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String s = rs.getString("COF_NAME");
				float n = rs.getFloat("PRICE");
				System.out.println(s + "   " + n);
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doTests() {
	
	doCreate();

    doSelectTest();

    doInsertTest();  doSelectTest();
    doUpdateTest();  doSelectTest();
    doDeleteTest();  doSelectTest();
  }

	private void doUpdateTest()
  {
    System.out.print("\n[Performing UPDATE] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("UPDATE COFFEES SET PRICE=4.99 WHERE COF_NAME='BREAKFAST BLEND'");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }
}
