define(['jquery', 'angular', 'angular-ui-router', 'angular-animate', 'jsRoutes', 'controllers'], function($, angular, moment, jsRoutes) {
    'use strict';

    var app = angular.module('app', [ 'ui.router', 'ngAnimate', 'ngAria', 'ngSanitize', 'ngMaterial', 'ngAnimate', 'controllers' ]);

    /**
     * Angular configurations
     */
    app.config(['$urlRouterProvider', '$locationProvider', '$stateProvider', 
        function($urlRouterProvider, $locationProvider, $stateProvider) {

        $urlRouterProvider.otherwise('/').deferIntercept();

        $stateProvider
            .state('home', 
                   { url: '/home', 
                     templateUrl: '/views/home/landing.html',
                     controller: 'HomeCtrl', })
//            .state('registration', 
//                { url: '/register', 
//                  templateUrl: '/views/home/register.html',
//                  controller: 'RegistrationCtrl' })
            .state('customerListing', 
                   { url: '/customer/list', 
                     templateUrl: '/views/customers/listing.html',
                     controller: 'CustomerListingCtrl', })
            .state('POListing', 
                   { url: '/po/list', 
                     templateUrl: '/views/po/listing.html',
                     controller: 'POListingCtrl', })
            .state('paymentListing', 
                   { url: '/payment/list', 
                     templateUrl: '/views/payment/listing.html',
                     controller: 'PaymentListingCtrl', })
            .state('invoiceListing', 
                   { url: '/invoice/list', 
                     templateUrl: '/views/invoice/listing.html',
                     controller: 'InvoiceListingCtrl', })
        ;
        
        $locationProvider.html5Mode(true).hashPrefix("!");
    } ]);

    // ngAnimation settings.
    app.config(['$animateProvider', function($animateProvider){
        // do not mess with 'fa-spin' icons
        $animateProvider.classNameFilter(/^((?!(fa-spin)).)*$/);
    }]);

    // Angular material theme
    app.config(['$mdThemingProvider', function($mdThemingProvider) {
        $mdThemingProvider
            .theme('default')
            .primaryPalette('blue')
            .accentPalette('deep-orange')
            .warnPalette('red')
            .backgroundPalette('grey');
    }]);
    /**
     * Angular initialization code
     */
    // ui-router initialization and rootScope defaults
    app.run(['$rootScope', '$state', '$stateParams', '$location', '$urlRouter',
    function($rootScope, $state, $stateParams, $location, $urlRouter) {
        // Redirect to home page if user is already authenticated
        $state.go('home');
    }]);
        
 // Filters
    app.filter('isodatetime', ['$filter', function($filter) {
        return function(input, format) {
            var date = moment(input);
            if (date) {
                if (format) {
                    return date.format(format);
                } else {
                    var isToday = moment().isSame(date, 'day');
                    var f = isToday ? '[Hoje,] HH:mm' : 'DD/MM/YYYY HH:mm';
                    return date.format(f);
                }
            } else {
                return '';
            }
        };
    }]);
    
    return app;
});
