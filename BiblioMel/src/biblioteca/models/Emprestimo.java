package biblioteca.models;

import java.util.Calendar;

public class Emprestimo {
	private int id;
	private Calendar dataEmp;
	private Calendar dataDev;
	private Livro livro;
	private Aluno aluno;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataEmp() {
		return dataEmp;
	}

	public void setDataEmp(Calendar dataEmp) {
		this.dataEmp = dataEmp;
	}

	public Calendar getDataDev() {
		return dataDev;
	}

	public void setDataDev(Calendar dataDev) {
		this.dataDev = dataDev;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
