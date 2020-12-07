package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Statement;

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
					+ "(cpf, rg, nome, nascimento, sexo, telefone, email, id_filmes) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, "62154468537");
			stmt.setString(2, "698531");
			stmt.setString(3, "Jessica Felix");
			stmt.setDate(4, new java.sql.Date(sdf.parse("04/04/1992").getTime()));
			stmt.setString(5, "F");
			stmt.setString(6, "61985647891");
			stmt.setString(7, "jessicafelix@gmail.com");
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
