'use strict';

// Register `phoneDetail` component, along with its associated controller and template
angular.
  module('epRegister').
  component('epRegister', {
    templateUrl: 'ep-register/ep-register.template.html',
    
    controller: [function registerListController(){	
    	
    var ctrl = this;
    
    var firstN	= ctrl.firstName="";
    
    ctrl.submit = function(){
    	
    	ctrl.serivcesArray = [];
    	ctrl.serivces1 = [];
    	ctrl.serivces2 = [];
    	ctrl.serivces3 = [];
    	
    	var sT1var = ctrl.services.serviceTitle1;
    	var sB1var = ctrl.services.serviceBlurb1;
    	
    	ctrl.serivcesArray.push({"serviceTitle" : sT1var,
    			"serviceBlurb" : sB1var});
    	
    	ctrl.serivcesArray.push({"serviceTitle" : ctrl.services.serviceTitle2,
			"serviceBlurb" : ctrl.services.serviceBlurb2});
    	
/*    	ctrl.serivcesArray.push({"services" : ctrl.serivces1});
    	ctrl.serivcesArray.push({"services" : ctrl.serivces2});*/
    	
/*    	var service1 = {
    			"serviceTitle" : ctrl.services.serviceTitle1,
    			"serviceBlurb" : ctrl.services.serviceBlurb1
    	}
    	
    	var service2 = {
    			"serviceTitle" : ctrl.services.serviceTitle2,
    			"serviceBlurb" : ctrl.services.serviceBlurb2
    	}
    	
    	ctrl.addServicesIndivdual = function(){
    		ctrl.serivcesArray.push(ctrl.service1);
    		ctrl.serivcesArray.push(ctrl.service2);
    		return servicesArrayComplete;
    }*/
    	
    	var registerData = {
    			
    			"firstName" : ctrl.firstName,
    			"lastName"	: ctrl.lastName,
    			"services" 	: ctrl.serivcesArray
   			
    	};
    	var signupjsondata = JSON.stringify(registerData);
    	
    }
             
    }]
    	
  });