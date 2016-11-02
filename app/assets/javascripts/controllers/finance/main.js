define(['angular', './POListingCtrl', './PaymentListingCtrl', './InvoiceListingCtrl'],
    function(angular, POListingCtrl, PaymentListingCtrl, InvoiceListingCtrl) {
    'use strict';
    
        return angular.module('controllers.finance', [])
            .controller('POListingCtrl', POListingCtrl)
            .controller('PaymentListingCtrl', PaymentListingCtrl) 
            .controller('InvoiceListingCtrl', InvoiceListingCtrl);
    }
);