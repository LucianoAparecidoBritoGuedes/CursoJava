package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null; // objeto que faz conexão com o DB 
		Statement stmt = null;  // objeto que monta a expressão SQL
		ResultSet rsts = null;  // objeto que recebe a reculperação dos dados do DB
		
		try {
			conn = DB.getConnection(); 							// instanciação do objeto de conexão
			stmt = conn.createStatement();						// instanciação do objeto com o comando SQL
			rsts = stmt.executeQuery("select * from pessoa p join filmes f on p.id_filmes = f.id_filmes");

			System.out.println("ID, NOME, NASCIMENTO, FILME, DURAÇÃO, CLASSIFICAÇÃO");
			while(rsts.next()) {
				System.out.println(
					rsts.getInt("p.id_pessoa") 
					+ ", " 
					+ rsts.getString("p.nome")
					+ ", "
					+ sdf.format(rsts.getDate("p.nascimento")) // data do sql para SimpleDateFormat(dd/MM/yyyy)
					+ ", "
					+ rsts.getString("f.nome")
					+ ", "
					+ rsts.getTime("f.duracao")
					+ ", "
					+ rsts.getString("f.classificacao"));
			}
			
		}
		catch (SQLException e) {
				e.getMessage();
				e.printStackTrace();
			}
		finally {
			DB.closeResultSet(rsts);	//chamando método para fechar o ResultSet
			DB.closeStatement(stmt);	//chamando método para fechar o Statement
			DB.closeConnection();		//chamando método para fechar a Conexão com o DB
		}
	}
}
