'use strict';

// Register `phoneDetail` component, along with its associated controller and template
angular.
  module('epRegister').
  component('epRegister', {
    templateUrl: 'ep-register/ep-register.template.html',
    
    controller: [function registerListController(){	
    	
    var ctrl = this;
    
    var firstN	= ctrl.firstName="";
    
    ctrl.makeJson = function(){
    	
    	var registerData = {
    			
    			"firstName" : ctrl.firstName,
    			"lastName"	: ctrl.lastName
    			
    	};
    	var signupjsondata = JSON.stringify(registerData);
    	
    }
             
    }]
    	
  });