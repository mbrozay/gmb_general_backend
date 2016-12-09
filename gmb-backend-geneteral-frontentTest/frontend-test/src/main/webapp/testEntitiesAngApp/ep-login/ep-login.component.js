'use strict';

// Register `epList` component, along with its associated controller and template
angular.
  module('epLogin').
  component('epLogin' ,{
	  templateUrl: 'ep-login/ep-login.template.html',

	  controller: ['EpLogin',function EPLoginController(EpLogin) {
		  var ctrl = this;
		  
		  ctrl.login = function(){
		  var registerData = {
	    			
	    			"username" : ctrl.username,
	    			"password" : ctrl.password	   			
	    	};
	    	var jsondataStringify = JSON.stringify(registerData);
	    	EpLogin.save(jsondataStringify,function(data){
	    		ctrl.message = data;
	    	}, function(error) {
	    	    ctrl.message = "error";
	    	}
	    )
		  }
	  }
	  ]
	  
	});
