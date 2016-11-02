
(function(requirejs) {
    'use strict';

    // -- RequireJS config --
    requirejs.config({
        waitSeconds: 0, // we need to wait for all libraries to be loaded... so disable the default timeout
        // jquery needs to be first no matter what!
        deps: ['jquery'],
        // Packages = top-level folders; loads a contained file named 'main.js"
        packages: ['controllers', 'controllers/catalog', 'controllers/finance',
        	       {  name: 'moment', location: '../lib/momentjs', main: 'moment' }],
        shim: {
            'jsRoutes': {
                deps: [],
                //  it's not a RequireJS module, so we have to tell it what var is returned
                exports: 'jsRoutes'
            },
            'modernizr': { deps: [], exports: 'Modernizr' },
//            'moment-pt-br': ['moment'],
//            'bootstrap': ['jquery'],
            'angular': {
                deps: ['jquery'],
                exports: 'angular'
            },
            'angular-pt-br': ['angular'],
            'angular-route': ['angular'],
            'angular-resource': ['angular'],
            'angular-messages': ['angular'],
            'angular-animate': ['angular'],
            'angular-aria': ['angular'],
            'angular-sanitize': ['angular'],
            'angular-ui-router': ['angular'],
            'angular-material': ['angular', 'angular-animate', 'angular-aria', 'angular-messages', 'angular-sanitize'],
//            'angular-ui-select': ['angular'],
//            'angular-toastr': ['angular'],
//            'angular-loading-bar': ['angular'],
//            'satellizer': ['angular'],
//            'Highcharts': {
//                deps: ['jquery'],
//                exports: 'Highcharts'
//            },
//            'highcharts-more': ['Highcharts'],
//            'highcharts-gauge': ['Highcharts', 'highcharts-more']
        },
        paths: {
            'requirejs': ['../lib/requirejs/require'],
            'modernizr': ['../lib/modernizr/modernizr'],
//            'moment': ['../lib/momentjs/moment'],//, '../lib/momentjs/locale/pt-br'],
//            'moment-pt-br': ['../lib/momentjs/locale/pt-br'],
            'jquery': ['../lib/jquery/jquery'],
//            'bootstrap': ['../lib/bootstrap/js/bootstrap'],
            'angular': ['../lib/angularjs/angular'],
            'angular-pt-br': ['../lib/angularjs/i18n/angular-locale_pt-br'],
            'angular-route': ['../lib/angularjs/angular-route'],
            'angular-resource': ['../lib/angularjs/angular-resource'],
            'angular-messages': ['../lib/angularjs/angular-messages'],
            'angular-animate': ['../lib/angularjs/angular-animate'],
            'angular-aria': ['../lib/angularjs/angular-aria'],
            'angular-sanitize': ['../lib/angularjs/angular-sanitize'],
            'angular-ui-router': ['../lib/angular-ui-router/release/angular-ui-router'],
            'angular-material': ['../lib/angular-material/angular-material'],
            'domReady': ['../lib/requirejs-domready/domReady'],
//            'angular-ui-bootstrap': ['../lib/angular-ui-bootstrap/ui-bootstrap-tpls'],
//            'angular-ui-bootstrap': ['../lib/angular-ui-bootstrap/ui-bootstrap']
//            'angular-ui-select': ['../lib/angular-ui-select/dist/select'],
//            'angular-toastr': ['../lib/angular-toastr/dist/angular-toastr.tpls'],
//            'angular-loading-bar': ['../lib/angular-loading-bar/build/loading-bar'],
//            'Highcharts': ['../lib/highcharts/highcharts'],
//            'highcharts-more': ['../lib/highcharts/highcharts-more'],
//            'highcharts-gauge': ['../lib/highcharts/modules/solid-gauge'],
            'jsRoutes': ['/jsroutes']
        }
    });

    requirejs.onError = function(err) {
        console.log(err);
        console.log(err.requireType);
        console.log('modules: ' + err.requireModules);
        throw err;
    };
//
//    require([/*'modernizr'*/, 'moment', 'bootstrap', 'angular-messages',/*'angular-animate',*/ 'angular-aria', 'angular-sanitize'], 
//        function(/*Modernizr, */moment) {
//            //Modernizr.addTest('filereader', !!(window.File && window.FileList && window.FileReader));
//            //window.moment = moment;
//            //moment.locale('pt-BR');
//        }
//    );
    
    require(['moment', 'moment/locale/pt-br'], function(moment) {
        window.moment = moment;
        moment.locale('pt-BR');
    });

    require(['angular', 'moment', 'angular-animate', 'angular-pt-br', 'angular-aria', 'angular-sanitize', 'angular-material', './app'],
         function(angular) {
            require(['domReady'], function(document) {
                angular.bootstrap(document, ['app'], { strictDi: true });
            });
        }
    );
})(requirejs);
