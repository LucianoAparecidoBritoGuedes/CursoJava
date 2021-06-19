package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DB.getConnection();
			
			stmt = conn.prepareStatement(
					"UPDATE department "
					+ "SET name = ? "
					+ "WHERE id = ?");
			stmt.setString(1, "Vehicle");
			stmt.setInt(2, 3);
			
			int rowsAffected = stmt.executeUpdate();
			
			System.out.println("Done!\n" + rowsAffected + " rows affected!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(stmt);
			DB.closeConnection();
		}
	}
}
