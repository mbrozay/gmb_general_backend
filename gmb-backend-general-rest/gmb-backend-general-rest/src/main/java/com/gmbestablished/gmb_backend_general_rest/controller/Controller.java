package com.gmbestablished.gmb_backend_general_rest.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.gmbestablished.gmb_backend_general_rest.dao.returnStringEntityPrimary;

@CrossOrigin(origins = "*")
@RestController
public class Controller {
	
	@RequestMapping("/greeting1")
	public String thl() {
		return "Hi There";
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/entitySelector")
	public String allEntityPrimaries() throws JsonProcessingException{
		returnStringEntityPrimary rsep =new returnStringEntityPrimary();
		String stringRsep = rsep.EntityPrimaryList();
		
		return stringRsep;
		
	}
	
	@RequestMapping("/entitySelectorWithAddress")
	public String allEntityPrimariesWithAddresses() throws JsonProcessingException{
		returnStringEntityPrimary rsep =new returnStringEntityPrimary();
		String stringRsep = rsep.EntityPrimaryWithAddressList();
		
		return stringRsep;
		
	}

}
