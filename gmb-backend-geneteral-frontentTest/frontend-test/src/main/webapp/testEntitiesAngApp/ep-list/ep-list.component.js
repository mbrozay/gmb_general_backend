'use strict';

// Register `epList` component, along with its associated controller and template
angular.
  module('epList').
  component('epList' ,{
	  templateUrl: 'ep-list/ep-list.template.html',
	  
	  controller: ['EpList',
	               function EPListController(EpList) {
		  var ctrl = this;
		  var jsondataStringify = {
					"sessionToken" : null,
			};
		  
		  EpList.save(jsondataStringify,function(data){
				ctrl.eps = data;	     		
			}, function(error) {
				ctrl.message = "error";
			})
		/*  this.eps = EpAll.query();
		  this.orderProp = 'age';*/

	  }
	  

	    
	  
	  ]
	  
	});
