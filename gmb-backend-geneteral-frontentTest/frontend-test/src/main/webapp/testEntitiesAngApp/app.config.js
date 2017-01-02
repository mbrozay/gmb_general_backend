'use strict';

angular.
  module('gmbcatApp').
  config(['$locationProvider' ,'$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/eps', {
          template: '<ep-list></ep-list>'
        }).
        when('/register', {
            template: '<ep-register></ep-register>'
          }).
        when('/eps/:id', {
          template: '<ep-detail></ep-detail>'
        }).
        when('/login', {
            template: '<ep-login></ep-login>'
          }).
          when('/listbyuser', {
        	  resolve: {
      			"check" : function($location, $rootScope, $cookies){
      				var checkLoggedIn = $cookies.get('auth');
      				if (checkLoggedIn=="null"){
      					$location.path('/eps');
      				}
      			}
      		},    	
              template: '<ep-listbylogin></ep-listbylogin>'
            }).
            when('/edit/:id', {
          	  resolve: {
        			"check" : function($location, $rootScope, $cookies){
        				var checkLoggedIn = $cookies.get('auth');
        				if (checkLoggedIn=="null"){
        					$location.path('/eps');
        				}
        			}
        		},    	
                template: '<ep-edit></ep-edit>'
              }).
        when('/edit', {
        	resolve: {
    			"check" : function($location, $rootScope, $cookies){
    				var checkLoggedIn = $cookies.get('auth');
    				if (checkLoggedIn=="null"){
    					$location.path('/eps');
    				}
    			}
    		},   		
            template: '<ep-edit></ep-edit>'
            }).
        otherwise('/eps');
    }
  ]);