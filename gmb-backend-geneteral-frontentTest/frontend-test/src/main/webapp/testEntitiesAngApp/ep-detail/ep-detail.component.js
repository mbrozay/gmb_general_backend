'use strict';

// Register `phoneDetail` component, along with its associated controller and template
angular.
  module('epDetail').
  component('epDetail', {
    templateUrl: 'ep-detail/ep-detail.template.html',
    controller: ['$routeParams',
      function EpDetailController($routeParams) {
        this.epId = $routeParams.epId;
      }
    ]
  });