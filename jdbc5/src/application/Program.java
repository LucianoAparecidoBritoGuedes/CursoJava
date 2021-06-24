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
			
			stmt = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			stmt.setInt(1, 2);
			int rows1 = stmt.executeUpdate();
			System.out.println(rows1 + " rows affected!");
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(stmt);
			DB.closeConnection();
		}
	}
}
