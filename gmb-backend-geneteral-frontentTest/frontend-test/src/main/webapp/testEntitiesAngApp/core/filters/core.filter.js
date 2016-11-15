'use strict';

angular.
module('core').
filter('categoryFilter', function() {
  return function(input) {
    return input ? '\u2713' : '\u2718';
  };
});