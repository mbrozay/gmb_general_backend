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

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.gmbestablished.gmb_backend_general_dataAccess.model.User;
import com.gmbestablished.gmb_backend_general_rest.dao.ContentUpload;
import com.gmbestablished.gmb_backend_general_rest.dao.EpPicker;
import com.gmbestablished.gmb_backend_general_rest.dao.LoginValidate;
import com.gmbestablished.gmb_backend_general_rest.dao.ReturnCategories;
import com.gmbestablished.gmb_backend_general_rest.dao.UserUpdater;
import com.gmbestablished.gmb_backend_general_rest.dao.EntityPrimaryList;
import com.gmbestablished.gmb_backend_general_rest.pojo.EntityPrimaryPojo;
import com.gmbestablished.gmb_backend_general_rest.pojo.EpPicker_pojo;
import com.gmbestablished.gmb_backend_general_rest.pojo.LoginPojo;
import com.gmbestablished.gmb_backend_general_rest.pojo.ResponseMessage;
import com.gmbestablished.gmb_backend_general_rest.pojo.UserPojo;

@CrossOrigin(origins = "*")
@RestController
public class Controller {
	
	//GET all entities
/*	@CrossOrigin(origins = "*")
	@RequestMapping("/entitySelector")
	public String allEntityPrimaries() throws JsonProcessingException{
		ListEntityPrimary listEntityPrimary =new ListEntityPrimary();
		String stringRsep = listEntityPrimary.EntityPrimaryList();
		
		return stringRsep;
		
	}*/
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/entitySelector", method = RequestMethod.POST)	
	public  @ResponseBody String epSelector_JSON( @RequestBody UserPojo userpojo ) throws JsonProcessingException   {		
		
		EntityPrimaryList entityPrimaryList =new EntityPrimaryList();
		String entityList = entityPrimaryList.EntityPrimaryListJson(userpojo);
		
		return entityList;
	}
	
	//GET list of categories
	@CrossOrigin(origins = "*")
	@RequestMapping("/categories")
	public String allCategories() throws JsonProcessingException{
		ReturnCategories rc =new ReturnCategories();
		String stringRc = rc.categories();
		return stringRc;	
	}
	
	
/*	@RequestMapping("/entitySelectorWithAddress")
	public String allEntityPrimariesWithAddresses() throws JsonProcessingException{
		returnStringEntityPrimary rsep =new returnStringEntityPrimary();
		String stringRsep = rsep.EntityPrimaryWithAddressList();
		
		return stringRsep;
		
	}*/
	
	//Getting all details of one entity primary. Used for public listing and selection by logged in user for editing
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/epPicker", method = RequestMethod.POST)	
	public  @ResponseBody String epPicker_JSON( @RequestBody EpPicker_pojo epPicker_pojo ) throws JsonProcessingException   {		
		
		EpPicker epPicker = new EpPicker();
		String result = epPicker.epPick(epPicker_pojo);
		System.out.println("returning eppicker");
		return result;
	}
	
	//Content upload and editing
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
	
	//Signing up and editing user details
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public @ResponseBody String users_JSON ( @RequestBody UserPojo userPojo) throws JsonProcessingException{

		UserUpdater userUpdater = new UserUpdater();
		String result = userUpdater.userUpdate(userPojo);
		userPojo.setSessionToken(result);
		userPojo.setPassword(null);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(userPojo);
		
		return jsonInString;
	}
	
	//Login, generate session token
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/epLogin", method = RequestMethod.POST)
	public @ResponseBody String login_JSON ( @RequestBody UserPojo userPojo) throws JsonProcessingException{
		userPojo.setjWT(false);
		LoginValidate loginValidate = new LoginValidate();
		String result = loginValidate.LoginCheckCreds(userPojo);
		userPojo.setSessionToken(result);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(userPojo);
		
		return jsonInString;
	}
	
	//Login returning JWT Token
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/loginJWT", method = RequestMethod.POST)
	public @ResponseBody String loginJWT (@RequestBody UserPojo userPojo) throws JsonProcessingException {
		userPojo.setjWT(true);
		LoginValidate loginValidate = new LoginValidate();
		String result = loginValidate.LoginCheckCreds(userPojo);
		
		String jsonInString = null;
		if (result != null && !result.isEmpty())
		{
		userPojo.setSessionToken(result);
		

		String jWTToken = null;
		try {
		    Algorithm algorithm = Algorithm.HMAC256("password1");
		    jWTToken = JWT.create()
		        .withIssuer("auth0")
		        .withClaim("email", userPojo.getEmail())
		        .sign(algorithm);
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		
		System.out.println(jWTToken);
		userPojo.setToken(jWTToken);
		ObjectMapper mapper = new ObjectMapper();
		jsonInString = mapper.writeValueAsString(userPojo);
		System.out.println(jsonInString);

	//	return jWTToken;
	}
		 
			
		return jsonInString;
	}
/*	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/epByUser", method = RequestMethod.POST)
	public @ResponseBody String epByUser_JSON ( @RequestBody EntityPrimaryPojo entityPrimaryPojo) throws JsonProcessingException{
		
		return null;
	}*/

}
