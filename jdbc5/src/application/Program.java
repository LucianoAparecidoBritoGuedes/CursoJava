package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			int rows1 = stmt.executeUpdate("UPDATE filmes SET nome = 'Teste' WHERE id_filmes = 7");
			
			/*
			int i = 1;
			if (i>0) {
				throw new SQLException("Fake Error");
			}
			*/
			
			int rows2 = stmt.executeUpdate("UPDATE filmes SET nome = 'Filme Bom' WHERE id_filmes = 8");
			
			conn.commit();
			
			System.out.println(rows1 + " rows affected!");
			System.out.println(rows2 + " rows affected!");
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		} finally {
			DB.closeStatement(stmt);
			DB.closeConnection();
		}
	}
}
