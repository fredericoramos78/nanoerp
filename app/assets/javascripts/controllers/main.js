define(['angular', './HomeCtrl', './MenuCtrl', 'controllers/catalog', 'controllers/finance'],
    function(angular, HomeCtrl, MenuCtrl) {
    'use strict';
    
        return angular.module('controllers', ['controllers.catalog', 'controllers.finance'])
            .controller('HomeCtrl', HomeCtrl)
            .controller('MenuCtrl', MenuCtrl);
    }
);