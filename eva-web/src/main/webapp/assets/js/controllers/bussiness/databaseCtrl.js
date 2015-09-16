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
            $defer.resolve($scope.data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
        }
    });

    $scope.list();

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
                    //SweetAlert.swal("Deleted!", "Event has been deleted.", "success");
                });
            } else {
                //SweetAlert.swal("Cancelled", "Event is safe :)", "error");
            }
        });

        //$http.post('/rest/database/delete',{'editId':pid}).success(function(response){
        //    $scope.list();
        //});
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




