define(['angular', 'jquery', 'jsRoutes'], function(angular, jquery, jsRoutes) {
    'use strict';
    
    
    return ['$scope', '$http', function($scope, $http) {
        
        $scope.title = "Customers";
        $scope.tableOptions = null;
        
        $scope.init = function() {
            if ($scope.tableOptions === null) {
                $scope.tableOptions = {
                    destroy: true,
                    searching: false,
                    serverSide: true,
                    ajax: function(data, callback, settings) {
                        console.log(data);
                        $http.post(jsRoutes.merp.controllers.api.catalog.CustomerController.list().url, angular.toJson(data))
                            .success(function(response) { callback(response); });
                    },
                    pagingType: "simple_numbers",
                    "order": [],
                    columnDefs: [ { title: "#", data: "id", orderable: false, targets: 0 }, 
                                  { title: "Nome", data: "name", orderable: true, targets: 1 },
                                  { title: "CPF/CNPJ", data: "taxId", orderable: true, targets: 2 },
                                  { title: "Endereço", data: "address.toString", orderable: false, targets: 3 }],
                    language: {
                        "decimal":        ",",
                        "emptyTable":     "Não existem linhas para serem exibidas.",
                        "info":           "Vendo registros _START_ a _END_ de um total de _TOTAL_",
                        "infoEmpty":      "",
                        "infoFiltered":   "(filtered from _MAX_ total entries)",
                        "infoPostFix":    "",
                        "thousands":      ".",
                        "lengthMenu":     "Mostrar _MENU_ linhas por página",
                        "loadingRecords": "carregando...",
                        "processing":     "processando...",
                        "search":         "Search:",
                        "zeroRecords":    "Não foram encontradas linhas.",
                        "paginate": {
                            "first":      "Primeiro",
                            "last":       "Último",
                            "next":       "Próximo",
                            "previous":   "Anterior"
                        },
                        "aria": {
                            "sortAscending":  ": ordena a coluna de forma ascendente",
                            "sortDescending": ": ordena a coluna de forma descendente"
                        }
                    }
                };
                // init the datatable element
                jquery("#datatable").dataTable($scope.tableOptions);
            }
        };
        
        $scope.init();
    }];
});
