'use strict';

// Register `epList` component, along with its associated controller and template
angular.
  module('epEdit',['ngCookies']).
  component('epEdit' ,{
	  templateUrl: 'ep-edit/ep-edit.template.html',

	   controller: ['$cookies','EpIndividual','EpCategories','filterFilter',
		               function EPEditController($cookies,EpIndividual,EpCategories,filterFilter) {
	    	 var ctrl = this;
	    	 ctrl.categories = EpCategories.query();
	    	 var jsondataStringify = {
	    	            "sessionToken" : $cookies.get('auth'),
	    	    };
	    	 EpIndividual.save(jsondataStringify,function(data){
	     		ctrl.eps = data;	     		
	     	}, function(error) {
	     	    ctrl.message = "error";
	     	}
	     			)
		  }
	   
		  ]
	  
	});