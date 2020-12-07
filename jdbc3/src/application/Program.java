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
					"UPDATE pessoa "
					+ "SET nome = ? "
					+ "WHERE id_pessoa = ?");
			stmt.setString(1, "Marcelo Ramos");
			stmt.setInt(2, 14);
			
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
