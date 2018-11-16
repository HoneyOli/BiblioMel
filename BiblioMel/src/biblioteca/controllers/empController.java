package biblioteca.controllers;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.daos.AlunoDAO;
import biblioteca.daos.EmprestimoDAO;
import biblioteca.daos.LivroDAO;
import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;
import biblioteca.models.Livro;

@Controller
public class empController {
	@RequestMapping ("/emprestimo/form")
	public ModelAndView form() {
		System.out.println("Chamou meu método");
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> listaA = alunoDAO.getAluno();
		LivroDAO livroDAO = new LivroDAO();
		List<Livro> listaL = livroDAO.getLista();

		ModelAndView model = new ModelAndView("emprestimo/form");

		model.addObject("aluno", listaA);
		model.addObject("livro", listaL);

		return model;
	}
	
	@PostMapping ("/emprestimo")
	public String adicionar(Emprestimo emprestimo) {
		System.out.println("Chamou o método de adicionar");
		System.out.println(emprestimo);
		EmprestimoDAO EmprestimoDAO = new EmprestimoDAO();
		EmprestimoDAO.inserir(emprestimo);
		return "redirect:/emprestimo";
	}
	



	@GetMapping("/emprestimo/")
	public ModelAndView listar() {
		System.out.println("Chamou o metódo de listagem");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDAO.getLista();
		ModelAndView model = new ModelAndView("emprestimo/list");
		model.addObject("emprestimo", lista);
		return model;
	}

	@GetMapping("/emprestimo/EmpAbertos")
	public ModelAndView listarAbertos() {
		System.out.println("Chamou o metódo de listagem de emprestimos abertos");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDAO.getAcessiveis();
		ModelAndView model = new ModelAndView("emprestimo/list");
		model.addObject("emprestimo", lista);
		return model;
	}

	@GetMapping("/emprestimo/EmpAtrasados")
	public ModelAndView listarAtrasado() {
		System.out.println("Chamou o metódo de listagem");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDAO.getAtrasados();
		ModelAndView model = new ModelAndView("emprestimo/EmpAtrasados");
		model.addObject("emprestimo", lista);
		return model;
	}
		@RequestMapping("/emprestimo/devolucao")
		public String devolucao(Long aluno, Long livro ) {
			System.out.println("Chamou o método devolução");
			Aluno aluno1 = new Aluno();
			Livro livro1 = new Livro();
			Emprestimo emprestimo = new Emprestimo();
			AlunoDAO alunoDAO = new AlunoDAO();
			LivroDAO livroDAO = new LivroDAO();
			EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
			aluno1 = alunoDAO.getAlunoById(aluno);
			emprestimo.setAluno(aluno1);		
			livro1 = livroDAO.getLivroById(livro);
			emprestimo.setLivro(livro1);
			
			emprestimoDAO.devolucao(emprestimo);
			
			return "redirect:../emprestimo/EmpAbertos";

		}
}