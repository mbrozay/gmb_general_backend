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
        when('/eps/:epId', {
          template: '<ep-detail></ep-detail>'
        }).
        otherwise('/eps');
    }
  ]);