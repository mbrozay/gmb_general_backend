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
        otherwise('/eps');
    }
  ]);