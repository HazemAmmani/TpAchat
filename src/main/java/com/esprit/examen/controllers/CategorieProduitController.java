package com.esprit.examen.controllers ;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.dto.DtoCategorieProduit;
import com.esprit.examen.services.ICategorieProduitService;

import java.util.List;

@RestController
@Api(tags = "Gestion des categories Produit")
@RequestMapping("/categorieProduit")
public class CategorieProduitController {

	@Autowired
	ICategorieProduitService categorieProduitService;
	
	// http://localhost:8089/SpringMVC/categorieProduit/retrieve-all-categorieProduit
	@GetMapping("/retrieve-all-categorieProduit")
	@ResponseBody
	public List<CategorieProduit> getCategorieProduit() {
		List<CategorieProduit> list = categorieProduitService.retrieveAllCategorieProduits();
		return list;
	}

	// http://localhost:8089/SpringMVC/categorieProduit/retrieve-categorieProduit/8
	@GetMapping("/retrieve-categorieProduit/{categorieProduit-id}")
	@ResponseBody
	public CategorieProduit retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		return categorieProduitService.retrieveCategorieProduit(categorieProduitId);
	}

	// http://localhost:8089/SpringMVC/categorieProduit/add-categorieProduit
	@PostMapping("/add-categorieProduit")
	@ResponseBody
	public CategorieProduit addCategorieProduit(@RequestBody DtoCategorieProduit cp) {
		CategorieProduit categorieProduit = new CategorieProduit(cp.getCodeCategorie(),cp.getLibelleCategorie());
		return	categorieProduitService.addCategorieProduit(categorieProduit);
	}

	// http://localhost:8089/SpringMVC/categorieProduit/remove-categorieProduit/{categorieProduit-id}
	@DeleteMapping("/remove-categorieProduit/{categorieProduit-id}")
	@ResponseBody
	public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		categorieProduitService.deleteCategorieProduit(categorieProduitId);
	}

	// http://localhost:8089/SpringMVC/categorieProduit/modify-categorieProduit
	@PutMapping("/modify-categorieProduit")
	@ResponseBody

	public CategorieProduit modifyCategorieProduit(@RequestBody DtoCategorieProduit categorieProduit) {
		CategorieProduit categorieP = new CategorieProduit(categorieProduit.getCodeCategorie(),categorieProduit.getLibelleCategorie());
		return categorieProduitService.updateCategorieProduit(categorieP);

	}

	
}
