package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = DB.getConnection();
			
			
			/** Inserção de dados na tabela Department
			 *	
			 *	stmt = conn.prepareStatement(
					"UPDATE department "
					+ "SET name = ? "
					+ "WHERE id = ?");
			*	stmt.setString(1, "Vehicle");
			*	stmt.setInt(2, 3);
			*
			*/
			
			/** Inserção de dados na tabela Seller
			 */
			stmt = conn.prepareStatement(
						"INSERT INTO seller "
						+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
						+ "VALUES "
						+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, "Luiza Brito");
			stmt.setString(2, "luizabrito@gmail.com");
			stmt.setDate(3, new java.sql.Date(sdf.parse("31/08/2019").getTime()));
			stmt.setDouble(4, 5000.0);
			stmt.setInt(5, 2);
			
			int rowsAffected = stmt.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				System.out.println("Done!\n" + rowsAffected + " rows affected!");
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Data entered with id: " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}
			
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(stmt);
			DB.closeConnection();
		}
	}
}
