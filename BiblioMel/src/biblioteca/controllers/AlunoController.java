 package biblioteca.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.daos.AlunoDAO;
import biblioteca.models.Aluno;



@Controller
public class AlunoController {
	@RequestMapping ("/aluno/form")
	public String form() {
		System.out.println("Chamou meu método");
		return "aluno/form";
	}
	
	@PostMapping ("/aluno")
	public String adicionar(Aluno aluno) {
		System.out.println("Chamou o método de adicionar");
		System.out.println(aluno);
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.inserir(aluno);
		return "redirect:aluno";
	}
	
	@GetMapping ("/aluno")
	public ModelAndView listar () {
		System.out.println("Chamou método de listagem");
		AlunoDAO AlunoDAO = new AlunoDAO();
		List <Aluno> lista = AlunoDAO.getLista();
		ModelAndView model = new ModelAndView ("aluno/lista");
		model.addObject("aluno", lista);
		return model;
		
	}
	
	@RequestMapping("/aluno/remover")
	public String remover (Aluno aluno) {
		System.out.println("Chamou o método remover ");
		AlunoDAO alunoDAO = new AlunoDAO ();
		alunoDAO.remover(aluno);
		
		return "redirect:/aluno";
		
	}
	

}

