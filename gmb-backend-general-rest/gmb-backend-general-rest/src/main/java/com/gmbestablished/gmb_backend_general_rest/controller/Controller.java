package com.gmbestablished.gmb_backend_general_rest.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.gmbestablished.gmb_backend_general_rest.dao.ContentUpload;
import com.gmbestablished.gmb_backend_general_rest.dao.EpPicker;
import com.gmbestablished.gmb_backend_general_rest.dao.LoginValidate;
import com.gmbestablished.gmb_backend_general_rest.dao.ReturnCategories;
import com.gmbestablished.gmb_backend_general_rest.dao.returnStringEntityPrimary;
import com.gmbestablished.gmb_backend_general_rest.pojo.EntityPrimaryPojo;
import com.gmbestablished.gmb_backend_general_rest.pojo.EpPicker_pojo;
import com.gmbestablished.gmb_backend_general_rest.pojo.LoginPojo;
import com.gmbestablished.gmb_backend_general_rest.pojo.ResponseMessage;

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
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/categories")
	public String allCategories() throws JsonProcessingException{
		ReturnCategories rc =new ReturnCategories();
		String stringRc = rc.categories();
		return stringRc;	
	}
	
	@RequestMapping("/entitySelectorWithAddress")
	public String allEntityPrimariesWithAddresses() throws JsonProcessingException{
		returnStringEntityPrimary rsep =new returnStringEntityPrimary();
		String stringRsep = rsep.EntityPrimaryWithAddressList();
		
		return stringRsep;
		
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/epPicker", method = RequestMethod.POST)	
	public  @ResponseBody String epPicker_JSON( @RequestBody EpPicker_pojo epPicker_pojo ) throws JsonProcessingException   {		
		
		EpPicker epPicker = new EpPicker();
		String result = epPicker.epPick(epPicker_pojo);
		System.out.println("returning eppicker");
		return result;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/epRegister", method = RequestMethod.POST)
	public @ResponseBody String register_JSON ( @RequestBody EntityPrimaryPojo entityPrimaryPojo) throws JsonProcessingException{

		ContentUpload contentUpload = new ContentUpload();
		String result = contentUpload.ContentUploadSave(entityPrimaryPojo);
		List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessages.add(responseMessage);
		responseMessage.setResponse("Success");
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(responseMessages);
		return jsonInString;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/epLogin", method = RequestMethod.POST)
	public @ResponseBody String login_JSON ( @RequestBody LoginPojo loginPojo) throws JsonProcessingException{
		LoginValidate loginValidate = new LoginValidate();
		String result = loginValidate.LoginCheckCreds(loginPojo);
		loginPojo.setSessionToken(result);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(loginPojo);
		
		return jsonInString;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/epByUser", method = RequestMethod.POST)
	public @ResponseBody String epByUser_JSON ( @RequestBody EntityPrimaryPojo entityPrimaryPojo) throws JsonProcessingException{
		
		return null;
	}

}
