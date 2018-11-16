package biblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import biblioteca.daos.ConnectionFactory;
import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;
import biblioteca.models.Livro;



public class EmprestimoDAO {
	private Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}
	public boolean inserir(Emprestimo emprestimo) {

		String sql = "insert into emprestimo (aluno, livro, dataEmp) " + "values (?, ?, ?);";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			stmt.setLong(1, emprestimo.getAluno().getId());
			stmt.setLong(2, emprestimo.getLivro().getId());
			stmt.setDate(3, new java.sql.Date(emprestimo.getDataEmp().getTimeInMillis()));
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
public boolean QuantidadeEmprestimos(Aluno aluno) {
		
		String sql =  "select * from emprestimo where aluno = ? and dataDev IS NULL;";
		int cont = 0;
		
		try {
			PreparedStatement stmt = connection
					.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			cont++;
		}
		
		if (cont >= 3) {
			return false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}

	return true;

}

public boolean QuantidadeEmprestimos(Livro livro) {
	
	String sql =  "select * from emprestimo where livro = ? and dataDev IS NULL;";
	int cont = 0;
	
	try {
		PreparedStatement stmt = connection
				.prepareStatement(sql);
	stmt.setLong(1, livro.getId());
	ResultSet rs = stmt.executeQuery();
	
	while (rs.next()) {
		
		cont++;
	}
	
	if (cont >= 1) {
		return false;
	}
} catch (SQLException e) {
	e.printStackTrace();
	return false;
}

return true;

}

public List<Emprestimo> getAcessiveis() {
	List<Emprestimo> emprestimo = new ArrayList<Emprestimo>();
		
		try {
			
		PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo;");
		ResultSet rs = stmt.executeQuery();

		Calendar dataEmp = Calendar.getInstance();
		stmt.setDate(1, new Date(dataEmp.getTimeInMillis()-14 * 24 * 60 * 60 * 1000));
		

		while (rs.next()) {
			 Emprestimo emprestimo1 = new Emprestimo();
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEmp"));
				emprestimo1.setDataEmp(data);
				Aluno aluno = new AlunoDAO().getAlunoById(rs.getLong("aluno"));
				Livro livro = new LivroDAO().getLivroById(rs.getLong("livro"));
				emprestimo1.setAluno(aluno);
				emprestimo1.setLivro(livro);

				emprestimo.add(emprestimo1);

		}
		rs.close();

		stmt.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return emprestimo;
}

public List<Emprestimo> getAtrasados() {

		List<Emprestimo> emprestimo = new ArrayList<Emprestimo>();

		try {
			
		PreparedStatement stmt = this.connection
				.prepareStatement("select * from emprestimo where dataDev is null and dataEmp < ?;");
		

		Calendar dataEmp = Calendar.getInstance();
		stmt.setDate(1, new Date(dataEmp.getTimeInMillis()-14 * 24 * 60 * 60 * 1000));
		ResultSet rs = stmt.executeQuery();
		
	 while (rs.next()){
		 Emprestimo emprestimo1 = new Emprestimo();
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataEmp"));
			emprestimo1.setDataEmp(data);
			Aluno aluno = new AlunoDAO().getAlunoById(rs.getLong("aluno"));
			Livro livro = new LivroDAO().getLivroById(rs.getLong("livro"));
			emprestimo1.setAluno(aluno);
			emprestimo1.setLivro(livro);

			emprestimo.add(emprestimo1);
	 
	 }

		rs.close();
		stmt.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return emprestimo;
}


	public List<Emprestimo> getLista() {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Emprestimo emp = new Emprestimo();
				
				

				
				result.add(emp);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Emprestimo> getListaByAluno(Aluno aluno) {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where aluno=?");
			stmt.setLong(1, aluno.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Emprestimo emp = new Emprestimo();
				
				
				
				
				result.add(emp);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Emprestimo> getListaByLivro(Livro livro) {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where livro=?");
			stmt.setLong(1, livro.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Emprestimo emp = new Emprestimo();
				
				
				
				result.add(emp);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean remover(Emprestimo emprestimo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where livro=?");
			
			stmt.setLong(1, emprestimo.getLivro().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean removerByLivro(Livro livro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where livro=?");
			
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean devolucao(Emprestimo emprestimo) {
		String sql = "update emprestimo set dataDev=? where aluno=? and livro=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(2, emprestimo.getAluno().getId());
			stmt.setLong(2, emprestimo.getLivro().getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Emprestimo getEmprestimoByID(Long id) {
		try {

			Emprestimo emprestimo = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				emprestimo = formacaoEmprestimo(rs);
			}
			rs.close();
			stmt.close();
			return emprestimo;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}
	private Emprestimo formacaoEmprestimo(ResultSet rs) throws SQLException {
		Emprestimo emprestimo = new Emprestimo();

		Aluno aluno = new AlunoDAO().getAlunoById(rs.getLong("aluno"));
		emprestimo.setAluno(aluno);
		Livro livro = new LivroDAO().getLivroById(rs.getLong("livro"));
		emprestimo.setLivro(livro);

		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataEmp"));
		emprestimo.setDataEmp(data);
		

		if (rs.getDate("dataDev") != null) {
			data.setTime(rs.getDate("dataDev"));
			emprestimo.setDataDev(data);
		}else {
			emprestimo.setDataDev(null);
		}

		return emprestimo;
		    }

}
