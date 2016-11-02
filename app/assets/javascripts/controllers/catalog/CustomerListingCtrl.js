define(['angular', 'jsRoutes'], function(angular, jsRoutes) {
    'use strict';
    
    
    return ['$scope',  function($scope) {
        $scope.title = "Customers";
        
        $scope.list = function() {
            //jsRoutes.merp.controllers.api.catalog.CustomerController.list().url
        };
    }];
});
