'use strict';

// Register `phoneDetail` component, along with its associated controller and template
angular.
  module('epRegister').
  component('epRegister', {
    templateUrl: 'ep-register/ep-register.template.html',
    
    controller: ['EpRegister','EpCategories',
                 function registerListController(EpRegister,EpCategories){	
    var ctrl = this;
    ctrl.categories = EpCategories.query();
    ctrl.submit = function(){
    			ctrl.serivceArray = [];
    	ctrl.serivceArray.push({"serviceBlockTitle" : ctrl.services.serviceBlockTitle1,
		"serviceBlockBody" : ctrl.services.serviceBlockBody1});    	
    	ctrl.serivceArray.push({"serviceBlockTitle" : ctrl.services.serviceBlockTitle2,
			"serviceBlockBody" : ctrl.services.serviceBlockBody2});
    	   	ctrl.serivceArray.push({"serviceBlockTitle" : ctrl.services.serviceBlockTitle3,
			"serviceBlockBody" : ctrl.services.serviceBlockBody3}); 
    	
    	  	ctrl.testimonialArray = [];
    	ctrl.testimonialArray.push({
    		"testimonialFromName" : ctrl.testimonials.testimonialFromName1,
			"testimonialBody" : ctrl.testimonials.testimonialBody1, 
			"testimonialFromURL" : ctrl.testimonials.testimonialFromURL1
			});    	
    	ctrl.testimonialArray.push({
    		"testimonialFromName" : ctrl.testimonials.testimonialFromName2,
			"testimonialBody" : ctrl.testimonials.testimonialBody2, 
			"testimonialFromURL" : ctrl.testimonials.testimonialFromURL2
			});
    	
    	ctrl.userArray = [];
    	ctrl.userArray.push({
    		"firstName" : ctrl.user.firstName,
    		"lastName" : ctrl.user.lastName,
    		"username" : ctrl.user.username,
    		"password" : ctrl.user.password
    	})
    	
    	ctrl.addressArray = [];
    	ctrl.addressArray.push({
    		"addressLine1" : ctrl.addresses.addressLine1,
    		"addressLine2" : ctrl.address.addressLine2,
    		"addressLine3" : ctrl.address.addressLine3,
    		"city" : ctrl.address.city,
    		"county" : ctrl.address.county,
    		"country" : ctrl.address.country,
    		"postCode" : ctrl.address.postcode,
    		"latitude" : ctrl.address.latitude,
    		"longitude" : ctrl.address.longitude    		
    	}) 
    	
    	var registerData = {
    			
    			"users" : ctrl.userArray,
    			"name" : ctrl.name,
    			"description" : ctrl.description,
    			"category" : ctrl.selectedCategory,
    			"addresses" : ctrl.addressArray,
    			"aboutUs" : ctrl.aboutUs,
    			"services" 	: ctrl.serivceArray,
    			"testimonials" : ctrl.testimonialArray
   			
    	};
    	var jsondataStringify = JSON.stringify(registerData);
    	EpRegister.save(jsondataStringify,function(data){
    		ctrl.message = data;
    	}, function(error) {
    	    ctrl.message = "error";
    	}
    			)
    }           
    }]
    	
  });