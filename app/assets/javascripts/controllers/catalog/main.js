define(['angular', './CustomerListingCtrl'],
    function(angular, CustomerListingCtrl) {
    'use strict';
    
        return angular.module('controllers.catalog', [])
            .controller('CustomerListingCtrl', CustomerListingCtrl);
    }
);