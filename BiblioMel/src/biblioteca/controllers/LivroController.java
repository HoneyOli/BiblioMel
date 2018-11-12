package biblioteca.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.daos.LivroDAO;
import biblioteca.models.Livro;

@Controller
public class LivroController {
	@RequestMapping ("/livro/form")
	public String form() {
		System.out.println("Chamou meu método");
		return "livro/form";
	}
	
	@PostMapping ("/livro")
	public String adicionar(Livro livro) {
		System.out.println("Chamou o método de adicionar");
		System.out.println(livro);
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.inserir(livro);
		return "redirect:livro";
	}
	
	@GetMapping ("/livro")
	public ModelAndView listar () {
		System.out.println("Chamou método de listagem");
		LivroDAO LivroDAO = new LivroDAO();
		List <Livro> lista = LivroDAO.getLista();
		ModelAndView model = new ModelAndView ("livro/lista");
		model.addObject("livro", lista);
		return model;
		
	}
	
	@RequestMapping("/livro/remover")
	public String remover (Livro livro) {
		System.out.println("Chamou o método remover ");
		LivroDAO livroDAO = new LivroDAO ();
		livroDAO.remover(livro);
		
		return "redirect:/livro";
		
	}
}
