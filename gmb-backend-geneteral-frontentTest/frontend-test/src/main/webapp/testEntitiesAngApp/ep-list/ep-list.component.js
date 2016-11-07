'use strict';

// Register `epList` component, along with its associated controller and template
angular.
  module('epList').
  component('epList' ,{
	  templateUrl: 'ep-list/ep-list.template.html',
	controller: function EPListController($http) {
		 var self = this;
		 self.orderProp = 'id';

		 $http.get('http://localhost:8080/gmb-backend-general-rest/entitySelector').then(function(response) {
		   self.eps = response.data;
		 });
	   }
	});