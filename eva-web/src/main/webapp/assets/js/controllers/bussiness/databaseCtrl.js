'use strict';
/**
 *  database
 */
app.controller('DatabaseCtrl', ["$scope","$http","$aside","$filter", "ngTableParams", function ($scope,$http,$aside,$filter, ngTableParams) {

    var myData = {};
    $scope.pageCtx = {};

    $http.post('/rest/database/findall',myData).success(function(response){
        $scope.pageCtx = response;

        $scope.tableParams = new ngTableParams({
            page: 1,
            count: 10
        }, {
            total: $scope.pageCtx.rows.length,
            getData: function ($defer, params) {
                var orderedData = params.sorting() ? $filter('orderBy')($scope.pageCtx.rows, params.orderBy()) : $scope.pageCtx.rows;
                $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
            }
        });

        $scope.editId = -1;

        $scope.setEditId = function (pid) {
            $scope.editId = pid;
        };

    });
}]);


