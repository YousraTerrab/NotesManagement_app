package com.gsnotes.web.controllers;

import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.IInscriptionAnnuelleDao;
import com.gsnotes.services.impl.NiveauImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//Ce controleur affiche la page index 
@Controller
public class InitiController {

	@Autowired
	IInscriptionAnnuelleDao inscriptionAnnuelle;
    @Autowired
    NiveauImpl niveau;
	/*@RequestMapping("/")
	public String index(Model model) {

		return "index";
	}
	@RequestMapping("/k")
	public void ff(Model model) {


			System.out.println(" Hello World");


	}*/

	@RequestMapping("/kkkk")
	public void fff(Model model) {
	List<Niveau> l = niveau.getAllNiveau();
	System.out.println(l);
	//InscriptionAnnuelle l = inscriptionAnnuelle.getById(Long.valueOf("1"));


	for (Niveau q:l) {

		System.out.println(" titre:" + q.getTitre() );
	}

	}





}
