'use strict';
/**
 *  database
 */

//var editId;
app.controller('databaseCtrl', ["$scope","$http","$aside","$filter", "ngTableParams", function ($scope,$http,$aside,$filter, ngTableParams) {

    var myData = {};
    $scope.pageCtx = {};

    //$http.post('/rest/database/list',myData).success(function(response){
    //    $scope.pageCtx = response;
    //
    //    $scope.tableParams = new ngTableParams({
    //        page: 1,
    //        count: 10
    //    }, {
    //        total: $scope.pageCtx.rows.length,
    //        getData: function ($defer, params) {
    //            var orderedData = params.sorting() ? $filter('orderBy')($scope.pageCtx.rows, params.orderBy()) : $scope.pageCtx.rows;
    //            $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
    //        }
    //    });
    //});

    $scope.query = function () {
        alert('query');
        $http.post('/rest/database/list',myData).success(function(response){
            $scope.pageCtx = response;

            console.log($scope.pageCtx);
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
        });
    }
    $scope.query();

    //$scope.editId = -1;

    //$scope.database = {};
    $scope.delEditId = function (pid) {
        $http.post('/rest/database/delete',{'editId':pid}).success(function(response){
            alert('删除成功！');
            $scope.query();
        });
    }

    //$scope.setEditId = function (pid) {
    //    //editId = pid;
    //
    //    $aside.open({
    //        templateUrl: 'edit.html',
    //        placement: 'right',
    //        size: 'big',
    //        backdrop: true,
    //        controller: function ($scope, $modalInstance) {
    //            $http.post('/rest/database/edit',{'editId':pid}).success(function(response){
    //                $scope.database = response;
    //            });
    //
    //            $scope.ok = function (e) {
    //                $http.post('/rest/database/save',$scope.database).success(function(response){
    //                    alert('保存成功！');
    //                    $scope.query();
    //                    $modalInstance.close();
    //                    e.stopPropagation();
    //                });
    //            };
    //            $scope.cancel = function (e) {
    //                $modalInstance.dismiss();
    //                e.stopPropagation();
    //            };
    //        }
    //    });
    //};

    $scope.setEditId = function (pid) {
        //editId = pid;

        $aside.open({
            templateUrl: 'edit.html',
            placement: 'right',
            size: 'big',
            backdrop: true,
            controller: function ($scope,$modalInstance) {
                console.log($scope);
                console.log($modalInstance);

                //$scope.query();
                $http.post('/rest/database/edit',{'editId':pid}).success(function(response){
                    $scope.database = response;
                });

                $scope.ok = function (e) {
                    $http.post('/rest/database/save',$scope.database).success(function(response){
                        alert('保存成功！');
                        //$scope.query();
                        $modalInstance.close();
                        e.stopPropagation();
                    });
                };
                $scope.cancel = function (e) {
                    $modalInstance.dismiss();
                    e.stopPropagation();
                };
            }
        });
    };

    $scope.add = function () {
        //editId = pid;

        $aside.open({
            templateUrl: 'edit.html',
            placement: 'right',
            size: 'big',
            backdrop: true,
            controller: function ($scope, $modalInstance) {
                $scope.ok = function (e) {
                    $http.post('/rest/database/save',$scope.database).success(function(response){
                        alert('保存成功！');
                        $scope.query();
                        $modalInstance.close();
                        e.stopPropagation();
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


