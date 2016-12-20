'use strict';

angular.
module('core').
filter('aboutUsFilter', function() {
  return function(items,mdTypeId) {
	  var results = [];
      
          for (var i = 0; i < items.length; i++) {
              if( items[i].metaDataTypeId.id===mdTypeId){
            	  results.push(items[i]);
              };
          }
          return results;
     
  }
});