'use strict';

// Register `phoneDetail` component, along with its associated controller and template
angular.
  module('epDetail').
  component('epDetail', {
    templateUrl: 'ep-detail/ep-detail.template.html',
    
    controller: ['$routeParams','EpIndividual',
	               function EPListController($routeParams,EpIndividual) {
    	 var self = this;

    		var jsondataStringify = JSON.stringify($routeParams);
    	 self.eps=EpIndividual.save(jsondataStringify);
		  
	  }
	  ]

  });