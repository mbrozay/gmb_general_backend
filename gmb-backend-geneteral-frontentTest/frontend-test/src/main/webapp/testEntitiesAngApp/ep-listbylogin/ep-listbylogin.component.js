'use strict';

// Register `epList` component, along with its associated controller and template
angular.
  module('epListbylogin',['ngCookies']).
  component('epListbylogin' ,{
	  templateUrl: 'ep-listbylogin/ep-listbylogin.template.html',

	  controller: ['EpList','$cookies', '$location',
	               function EPListbyloginController(EpList, $cookies, $location) {
		  var ctrl = this; 
		 var jsondataStringify = {
					"sessionToken" : $cookies.get('auth'),
			};
		  
		  EpList.save(jsondataStringify,function(data){
				ctrl.eps = data;
			}, function(error) {
				ctrl.message = "error";
			})
	  }  
	  ] 
	});
