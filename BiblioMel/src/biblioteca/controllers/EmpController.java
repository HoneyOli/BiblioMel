package biblioteca.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.daos.EmprestimoDAO;
import biblioteca.models.Emprestimo;

@Controller
public class EmpController {
	@RequestMapping ("/emprestimo/form")
	public String form() {
		System.out.println("Chamou meu método");
		return "emprestimo/form";
	}
	
	@PostMapping ("/emprestimo")
	public String adicionar(Emprestimo emprestimo) {
		System.out.println("Chamou o método de adicionar");
		System.out.println(emprestimo);
		EmprestimoDAO EmprestimoDAO = new EmprestimoDAO();
		EmprestimoDAO.inserir(emprestimo);
		return "redirect:emprestimo";
	}
	
	@GetMapping ("/emprestimo")
	public ModelAndView listar () {
		System.out.println("Chamou método de listagem");
		EmprestimoDAO EmprestimoDAO = new EmprestimoDAO();
		List <Emprestimo> lista = EmprestimoDAO.getLista();
		ModelAndView model = new ModelAndView ("emprestimo/lista");
		model.addObject("emprestimo", lista);
		return model;
		
	}
	
	@RequestMapping("/emprestimo/remover")
	public String remover (Emprestimo emprestimo) {
		System.out.println("Chamou o método remover ");
		EmprestimoDAO EmprestimoDAO = new EmprestimoDAO ();
		EmprestimoDAO.remover(emprestimo);
		
		return "redirect:/emprestimo";
		
	}
}