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
			conn.setAutoCommit(false); // não deixa o banco ser atualizado de imediato
			
			stmt = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			stmt.setInt(1, 5);
			
			int rows1 = stmt.executeUpdate();
				
			System.out.println(rows1 + " rows affected!");
			conn.commit(); // confirma as mudanças e atualiza o banco
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbIntegrityException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbIntegrityException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		} finally {
			DB.closeStatement(stmt);
			DB.closeConnection();
		}
	}
}
