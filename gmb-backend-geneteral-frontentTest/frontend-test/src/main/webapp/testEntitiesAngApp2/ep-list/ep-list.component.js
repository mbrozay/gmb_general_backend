'use strict';

// Register `epList` component, along with its associated controller and template
angular.
  module('epList').
  component('epList', {
	  templateUrl: 'ep-list/ep-list.template.html',
    controller: function EPListController($http) {
    	 var self = this;
         self.orderProp = 'id';

         $http.get('eps/eps.json').then(function(response) {
           self.eps = response.data;
         });
       }
     });