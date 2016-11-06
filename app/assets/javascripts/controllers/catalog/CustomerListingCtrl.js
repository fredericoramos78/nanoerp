define(['angular', 'jquery', 'jsRoutes'], function(angular, jquery, datatables, jsRoutes) {
    'use strict';
    
    
    return ['$scope', function($scope) {
        $scope.title = "Customers";
        
        
        $scope.tableOptions = {
                destroy: true,
                searching: false,
                pagingType: "simple_numbers",
                "order": [],
                columnDefs: [ { title: "#", data: "id", orderable: false, targets: 0 }, 
                              { title: "Nome", data: "name", orderable: true, targets: 1 },
                              { title: "CPF/CNPJ", data: "taxId", orderable: true, targets: 2 },
                              { title: "Endereço", data: "address", orderable: false, targets: 3 }],
                data: [
                    {id: "1", name: "TIM Celular S.A.", taxId: "00.000.000/0000-00", address: "1010, Lancaster street - London, UK"},
                    {id: "2", name: "TIM Celular S.A.", taxId: "00.000.000/0000-00", address: "1010, Lancaster street - London, UK"},
                    {id: "3", name: "TIM Celular S.A.", taxId: "00.000.000/0000-00", address: "1010, Lancaster street - London, UK"},
                    {id: "4", name: "TIM Celular S.A.", taxId: "00.000.000/0000-00", address: "1010, Lancaster street - London, UK"}
                ],
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
        
        $scope.list = function() {
            //jsRoutes.merp.controllers.api.catalog.CustomerController.list().url
            
        };
        
        jquery("#datatable").dataTable($scope.tableOptions);
    }];
});
