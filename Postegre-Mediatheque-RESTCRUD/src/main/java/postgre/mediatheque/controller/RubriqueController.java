package postgre.mediatheque.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import postgre.mediatheque.entite.RubriqueBean;
import postgre.mediatheque.metier.IRubriqueMetier;
import postgre.mediatheque.util.MediathequeException;

@RestController
public class RubriqueController {

	@Autowired
	private IRubriqueMetier iRubriqueMetier;

	@ResponseBody
	@RequestMapping(value ="/createDossier")
	public Map<String, Object> createRubrique(@RequestParam(required = true) String rub) throws MediathequeException, JsonParseException, JsonMappingException, IOException {
		
		RubriqueBean newdossier = new RubriqueBean();
		
		 // JSON à l'objet Java
        ObjectMapper objectMapper = new ObjectMapper();
        newdossier = objectMapper.readValue(rub, RubriqueBean.class);
		
		return iRubriqueMetier.createRubrique(newdossier);

	}

	@ResponseBody
	@RequestMapping(value = "/addFormulaires", method = RequestMethod.GET)
	public Map<String, Object> addTransaction(HttpServletRequest request) throws MediathequeException {
		String item = request.getParameter("idFils");
		String sCategoryID = request.getParameter("idParent");
		
		System.out.println("************************************************************");


		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sucess", false);

		return map;

	}

	@ResponseBody
	@RequestMapping(value = "/getlistRubrique", method = RequestMethod.GET)
	public List getListRubriqueTable() throws MediathequeException {

		List<RubriqueBean> listRubrique = new ArrayList<RubriqueBean>();
		listRubrique = iRubriqueMetier.getListRubriqueTable();

		return listRubrique;
	}
	
	@RequestMapping("/getlistRubriqueQueDossier")
	@ResponseBody
	public List getlistRubriqueQueDossier(@RequestParam boolean quoi) throws MediathequeException {
		
		List<RubriqueBean> listRubrique = new ArrayList<RubriqueBean>();
		listRubrique = iRubriqueMetier.getListRubriqueDissierOrFormulaire(quoi);
		return listRubrique;
		
	}
	
}
