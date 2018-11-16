package biblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import biblioteca.daos.ConnectionFactory;
import biblioteca.models.Livro;

public class LivroDAO {
	private Connection connection;

	public LivroDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean inserir(Livro livro) {

		String sql = "insert into livro (titulo, autor, editora, datPub, edicao) " + "values (?, ?, ?, ?, ?);";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setDate(4, new java.sql.Date(livro.getDataPublicacao().getTimeInMillis()));
			stmt.setInt(5, livro.getEdicao());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public List<Livro> getLista() {
		List<Livro> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livro");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Livro livro = new Livro();
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
				livro.setEdicao(rs.getInt("edicao"));

				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datPub"));
				livro.setDataPublicacao(data);
				result.add(livro);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Livro getLivroById(long id) {
		Livro livro = new Livro();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livro where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
				livro.setEdicao(rs.getInt("edicao"));

				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datPub"));
				livro.setDataPublicacao(data);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}
	public boolean atualisar (Livro livro) {
		String sql = "update livro set titulo=?, autor=?, "
					+ "editora=?, datPub=?, edicao=? "
					+ "where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setDate(4, new java.sql.Date(livro.getDataPublicacao().getTimeInMillis()));
			stmt.setInt(5, livro.getEdicao());
			stmt.setLong(6, livro.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean remover(Livro livro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from livro where id=?");
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Livro getLivroByTitulo(String titulo) {
		Livro result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livro where titulo = ?;");
			stmt.setString(1, titulo);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Livro();
				result.setId(rs.getInt("id"));
				result.setTitulo(rs.getString("titulo"));
				result.setAutor(rs.getString("autor"));
				result.setEditora(rs.getString("editora"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("DataPublicacao"));
				result.setDataPublicacao(data);
				
				result.setEdicao(rs.getInt("edicao"));
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
}
}

