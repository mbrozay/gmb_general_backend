'use strict';

// Register `epList` component, along with its associated controller and template
angular.
  module('epLogin',['ngCookies']).
  component('epLogin' ,{
	  templateUrl: 'ep-login/ep-login.template.html',

	  controller: ['EpLogin','$cookies', '$location',
	               function EPLoginController(EpLogin, $cookies, $location) {
		  var ctrl = this;
		  
		  ctrl.login = function(){
		  var registerData = {
	    			
	    			"username" : ctrl.username,
	    			"password" : ctrl.password	   			
	    	};
	    	var jsondataStringify = JSON.stringify(registerData);
	    	EpLogin.save(jsondataStringify,function(data){
	    		ctrl.message = data;
	            $cookies.put('auth',ctrl.message.sessionToken);
	            $location.path('/edit');
	    	}, function(error) {
	    	    ctrl.message = "error";
	    	}
	    )
		  }
	  }
	  
	  ]
	  
	});
