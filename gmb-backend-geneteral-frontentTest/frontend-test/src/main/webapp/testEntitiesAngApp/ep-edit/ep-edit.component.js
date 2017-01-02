'use strict';

//Register `epList` component, along with its associated controller and template
angular.
module('epEdit',['ngCookies']).
component('epEdit' ,{
	templateUrl: 'ep-edit/ep-edit.template.html',

	controller: ['$cookies','EpIndividual','EpCategories','filterFilter','$routeParams','EpRegister',
	             function EPEditController($cookies,EpIndividual,EpCategories,filterFilter,$routeParams,EpRegister) {
		var ctrl = this;
		
		 ctrl.addService = function() {
		     ctrl.ep.services.push({"serviceBlockTitle" : '',
		 		"serviceBlockBody" : ''});
		    }
		 ctrl.submit = function(){
		 var jsondataStringify = JSON.stringify(ctrl.eps);
		 EpRegister.save(jsondataStringify,function(data){
	    		ctrl.message = data;
	    	}, function(error) {
	    	    ctrl.errorMessage = "error";
	    	}
	    			)
		 }
	           
			if ($routeParams.id){
				var jsondataStringifyRP = JSON.stringify($routeParams);
		    	 EpIndividual.save(jsondataStringifyRP,function(data){
			    		ctrl.eps = data;
			    	}, function(error) {
			    	    ctrl.errorMessage = "error";
			    	})
			    			
			}
			else
			{ ctrl.eps = [{ "sessionToken" : $cookies.get('auth'), users: [{"firstName": '',"lastName": ''}], services: [{"serviceBlockTitle" : '',"serviceBlockBody" : ''},{"serviceBlockTitle" : '',"serviceBlockBody" : ''}], addresses: [{addressLine1:''}], categories: [{}] }];
			var jsondataStringify = {
					"sessionToken" : $cookies.get('auth'),
			};
/*			EpIndividual.save(jsondataStringify,function(data){
				ctrl.eps = data;	     		
			}, function(error) {
				ctrl.message = "error";
			}
			);*/
			}
/*		ctrl.submit = function(data){
			 console.log("Submit working");
			 console.log(data);
		}*/
		

			ctrl.categories = EpCategories.query();

	} 
	]  
});