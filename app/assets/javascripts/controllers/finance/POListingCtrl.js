define(['angular', 'angular-material'], function(angular) {
    'use strict';
    
    return ['$scope', function($scope) {
    
        $scope.openSortOptions = function($mdOpenMenu, ev) {
            //originatorEv = ev;
            $mdOpenMenu(ev);
        };
    }];
});
