package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
		conn = DB.getConnection();
		
		st =conn.createStatement();
		
		rs = st.executeQuery("select * from funcionario");
		
		
		while (rs.next()) {
			System.out.println(rs.getInt("Id") + ", " + (rs.getString("Nome") + ",  " +  rs.getDate("date") + ", R$" +  rs.getDouble("salario") ) );
		}
			
		}
		catch (SQLException e ) {
			e.printStackTrace();
		}
		
		finally {
			 DB.closeStatement(st);
			 DB.closeResultset(rs);
			 DB.closeConnection();
		}
		
		
	}

}
