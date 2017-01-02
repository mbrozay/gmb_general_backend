'use strict';

angular.
  module('core.ep').
  factory('EpAll', ['$resource','$http',
    function($resource,$http) {
      
	  return $resource('http://localhost:8080/gmb-backend-general-rest/entitySelector', {}, {
		          query: {
		            method: 'GET',
		            isArray: true
		          }
  });
  }
  ]);

angular.
module('core.ep').
factory('EpList', ['$resource','$http',
  function($resource,$http) {
	var response = $resource('http://localhost:8080/gmb-backend-general-rest/entitySelector', {}, {
        save: {
          method: 'POST',
          accept: "application/json",
          contentType: "application/json",
          isArray: true
        }	
	})  
	return response;
	}
]);

angular.
module('core.ep').
factory('EpCategories', ['$resource','$http',
  function($resource,$http) {
    
	  return $resource('http://localhost:8080/gmb-backend-general-rest/categories', {}, {
		          query: {
		            method: 'GET',
		            isArray: true
		          }
});
}
]);

angular.
module('core.ep').
factory('EpIndividual', ['$resource','$http',
  function($resource,$http) {
	var response = $resource('http://localhost:8080/gmb-backend-general-rest/epPicker', {}, {
        save: {
          method: 'POST',
          accept: "application/json",
          contentType: "application/json",
          isArray: true
        }	
	})
	return response;
	}
	

]);

angular.
module('core.ep').
factory('EpRegister', ['$resource','$http',
  function($resource,$http) {
	var response = $resource('http://localhost:8080/gmb-backend-general-rest/epRegister', {}, {
        save: {
          method: 'POST',
          accept: "application/json",
          contentType: "application/json",
          isArray: true
        }	
	})
	return response;
	}
]);

angular.
module('core.ep').
factory('EpLogin', ['$resource','$http',
  function($resource,$http) {
	var response = $resource('http://localhost:8080/gmb-backend-general-rest/epLogin', {}, {
        save: {
          method: 'POST',
          accept: "application/json",
          contentType: "application/json",
          isArray: false
        }	
	})  
	return response;
	}
]);

angular.
module('core.ep').
factory('EpByUser', ['$resource','$http',
  function($resource,$http) {
	var response = $resource('http://localhost:8080/gmb-backend-general-rest/epByUser', {}, {
        save: {
          method: 'POST',
          accept: "application/json",
          contentType: "application/json",
          isArray: false
        }	
	})  
	return response;
	}
]);

angular.
module('core.ep').
factory('EpUser', ['$resource','$http',
  function($resource,$http) {
	var response = $resource('http://localhost:8080/gmb-backend-general-rest/users', {}, {
        save: {
          method: 'POST',
          accept: "application/json",
          contentType: "application/json",
          isArray: false
        }	
	})  
	return response;
	}
]);