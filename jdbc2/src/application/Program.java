package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DB.getConnection();
			stmt = conn.prepareStatement(
					"INSERT INTO pessoa "
					+ "(Nome, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, "Luciano Brito");
			stmt.setString(2, "lucianobrito.dev@gmail.com");
			stmt.setDate(3, new java.sql.Date(sdf.parse("04/04/1992").getTime()));
			stmt.setDouble(4, 2000.00);
			stmt.setInt(5, 1);
			stmt.setInt(8, 1);
			
			int rowsAffected = stmt.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rsts = stmt.getGeneratedKeys();
				System.out.println("Done!\n" + rowsAffected + " rows affected!");
				while(rsts.next()) {
					int id = rsts.getInt(1);
					System.out.println("Objeto de id: " + id + " foi inserido.");
				}
			} else {
				System.out.println("No rows affected!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(java.text.ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(stmt);
			DB.closeConnection();
		}
	}
}
