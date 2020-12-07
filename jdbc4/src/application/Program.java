package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DB.getConnection();
			
			stmt = conn.prepareStatement(
					"DELETE FROM filmes "
					+ "WHERE id_filmes = ?");
			stmt.setInt(1, 1);
			
			int rowsAffected = stmt.executeUpdate();
			
			System.out.println("Done!\n" + rowsAffected + " rows affected!");
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(stmt);
			DB.closeConnection();
		}
	}
}
