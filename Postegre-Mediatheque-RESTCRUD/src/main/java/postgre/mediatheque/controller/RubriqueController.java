package postgre.mediatheque.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import postgre.mediatheque.entite.RubriqueBean;
import postgre.mediatheque.metier.IRubriqueMetier;
import postgre.mediatheque.util.MediathequeException;

@RestController
public class RubriqueController {

	@Autowired
	private IRubriqueMetier iRubriqueMetier;

	@RequestMapping("/CreateRubrique")
	@ResponseBody
	public Map<String, Object> createRubrique(@RequestParam RubriqueBean rub) throws MediathequeException {

		return iRubriqueMetier.createRubrique(rub);

	}

}
