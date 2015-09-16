'use strict';
/**
 *  database
 */
app.controller('databaseCtrl', ["$scope","$http","$aside","$filter", "ngTableParams", function ($scope,$http,$aside,$filter, ngTableParams) {
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
            $defer.resolve($scope.data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
        }
    });

    $scope.list();

    $scope.delEditId = function (pid) {
        $http.post('/rest/database/delete',{'editId':pid}).success(function(response){
            //alert('删除成功！');
            $scope.list();
        });
    }

    $scope.setEditId = function (pid) {
        //editId = pid;
        var s = $scope;
        console.log(s);
        $aside.open({
            templateUrl: 'edit.html',
            placement: 'right',
            size: 'big',
            backdrop: true,
            controller: function ($scope,$modalInstance,$location) {
                $http.post('/rest/database/edit',{'editId':pid}).success(function(response){
                    $scope.database = response;
                });
                $scope.ok = function (e) {
                    $http.post('/rest/database/save',$scope.database).success(function(response){
                        //alert('保存成功！');

                        $modalInstance.close();
                        e.stopPropagation();
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
            controller: function ($scope, $modalInstance) {
                $scope.ok = function (e) {
                    $http.post('/rest/database/save',$scope.database).success(function(response){
                        //alert('保存成功！');
                        //$scope.list();
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




