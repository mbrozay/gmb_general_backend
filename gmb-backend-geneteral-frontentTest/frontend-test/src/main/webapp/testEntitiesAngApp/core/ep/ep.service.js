'use strict';

angular.
  module('core.ep').
  factory('EpAll', ['$resource','$http',
    function($resource,$http) {
      
	  return $resource('http://localhost:8080/gmb-backend-general-rest/entitySelector', {}, {
		          query: {
		            method: 'GET',
		//            params: {epId: 'eps'},
		            isArray: true
		          }
  });
  }
  ]);

angular.
module('core.ep').
factory('EpIndividual', ['$resource','$http',
  function($resource,$http) {
    
/*	var jsondata = {"id" : "3"};
	var jsondataStringify = JSON.stringify(jsondata);
	 return $resource('http://localhost:8080/gmb-backend-general-rest/epPicker', jsondataStringify, {
         update: {
           method: 'POST',
           accept: "application/json",
           contentType: "application/json",
            params: {"id": '2'},
           isArray: true
         }
});*/
	var jsondata = {
            "id" : "1"
    };
	var jsondataStringify = JSON.stringify(jsondata);
	var response = $http.post('http://localhost:8080/gmb-backend-general-rest/epPicker', jsondataStringify);
	return response;
	}
	

]);