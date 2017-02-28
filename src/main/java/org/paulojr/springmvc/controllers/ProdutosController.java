package org.paulojr.springmvc.controllers;

import org.paulojr.springmvc.daos.ProdutoDAO;
import org.paulojr.springmvc.models.Produto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/produtos")
public class ProdutosController {
	
	private Logger log = LoggerFactory.getLogger(ProdutosController.class);

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/form")
	public String form(Produto produto) {
		return "produtos/form";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("produtos/listar");
		modelAndView.addObject("produtos", produtoDAO.listar());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(Produto produto, RedirectAttributes redirectAttributes) {
		produtoDAO.salvar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		
		return "redirect:produtos";
	}
	
	@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED)
	@ExceptionHandler(BindException.class)
	public String tratadorDeException(BindException e) {
		System.out.println("Erro de conversão captado " + e.getMessage());
		return "tratei";
	}
	
}




