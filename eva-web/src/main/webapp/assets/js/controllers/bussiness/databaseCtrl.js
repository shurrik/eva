'use strict';
/**
 *  database
 */
app.controller('databaseCtrl', ["$scope","$http","$aside","$filter", "ngTableParams","SweetAlert", function ($scope,$http,$aside,$filter,ngTableParams,SweetAlert) {
    var myData = {};
    $scope.pageCtx = {};

    $scope.tableParams = {};
    $scope.data = [];
    $scope.listPromise = null;
    $scope.list = function () {
        $http.post('/rest/database/list',myData).success(function(data){
            $scope.data = data;
            $scope.tableParams.reload();
        });
    };

    $scope.tableParams = new ngTableParams({
        page: 1, // show first page
        count: 6           // count per page
    }, {
        counts: [],
        total: $scope.data.length, // length of data
        getData: function ($defer, params) {
            var orderedData = params.sorting() ? $filter('orderBy')($scope.data, params.orderBy()) : $scope.data;
            $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
            //$defer.resolve($scope.data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
        }
    });

    $scope.list();

    //$scope.totalItems = 64;
    //$scope.currentPage = 4;

    //$scope.setPage = function (pageNo) {
    //    alert(1);
    //    console.log(pageNo);
    //    $scope.currentPage = pageNo;
    //};

    $scope.pageChanged = function () {
        alert($scope.bigCurrentPage);
        console.log('Page changed to: ' + $scope.currentPage);
        //$log.log('Page changed to: ' + $scope.currentPage);
    };

    $scope.maxSize = 5;
    $scope.bigTotalItems = 175;
    $scope.bigCurrentPage = 1;

    $scope.delEditId = function (pid) {
        SweetAlert.swal({
            title: "确定删除?",
            text: "数据删除后将无法恢复",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            closeOnConfirm: true,
            closeOnCancel: true
        }, function (isConfirm) {
            if (isConfirm) {
                $http.post('/rest/database/delete',{'editId':pid}).success(function(response){
                    $scope.list();
                });
            }
        });

    }

    $scope.setEditId = function (pid) {
        $aside.open({
            templateUrl: 'edit.html',
            placement: 'right',
            size: 'big',
            backdrop: true,
            controller: function ($scope,$modalInstance,$state) {
                $http.post('/rest/database/edit',{'editId':pid}).success(function(response){
                    $scope.database = response;
                });
                $scope.ok = function (e) {
                    $http.post('/rest/database/save',$scope.database).success(function(response){
                        $modalInstance.close();
                        e.stopPropagation();
                        $state.transitionTo($state.current, null, {'reload':true});
                    });;
                };
                $scope.cancel = function (e) {
                    $modalInstance.dismiss();
                    e.stopPropagation();
                };
            }
        });
    };

    $scope.add = function () {
        $aside.open({
            templateUrl: 'edit.html',
            placement: 'right',
            size: 'big',
            backdrop: true,
            controller: function ($scope, $modalInstance,$state) {
                $scope.ok = function (e) {
                    $http.post('/rest/database/save',$scope.database).success(function(response){
                        $modalInstance.close();
                        e.stopPropagation();
                        $state.transitionTo($state.current, null, {'reload':true});
                    });
                };
                $scope.cancel = function (e) {
                    $modalInstance.dismiss();
                    e.stopPropagation();
                };
            }
        });
    };
}]);




