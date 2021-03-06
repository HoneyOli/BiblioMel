package biblioteca.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Livro {

	private int id;
	private String titulo;
	private String autor;
	private String editora;
	@DateTimeFormat (pattern="dd/MM/yyyy")
	private Calendar dataPublicacao;
	private int edicao;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Calendar datPub) {
		this.dataPublicacao = datPub;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
