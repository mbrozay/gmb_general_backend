'use strict';

// Register `phoneDetail` component, along with its associated controller and template
angular.
  module('epDetail').
  component('epDetail', {
    templateUrl: 'ep-detail/ep-detail.template.html',
   
        
  /*      controller: ['EpIndividual',
  	               function EPDetailController(EpIndividual) {
  		  this.eps = EpIndividual.query();
  		  this.orderProp = 'age';
  	  }
  	  ]*/
    
    controller: ['$routeParams','EpIndividual',
	               function EPListController($routeParams,EpIndividual) {
    	 var self = this;
    	
    	/*var handleSuccess = function(data, status, headers, config) {
           self.eps = data;
        };
        var handleError = function(data, status, headers, config) {
        	alert( "Exception details: " + JSON.stringify({data: data}));
        };*/
    	
	//	 EpIndividual.success(handleSuccess);
    	 var jsondata = {
    	            "id" : "1"
    	    };
    		var jsondataStringify = JSON.stringify($routeParams);
    	 self.eps=EpIndividual.save(jsondataStringify);
		  
	  }
	  ]

  });