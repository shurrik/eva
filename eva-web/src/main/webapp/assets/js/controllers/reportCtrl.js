'use strict';
/**
 * controller for User Profile Example
 */
app.controller('ReportCtrl', ["$scope","$http","$aside", function ($scope,$http,$aside) {

    var myData = {};
    $scope.reports = [];
    $http.post('/rest/report/getall',myData).success(function(response){
        //console.log(response);
        $scope.reports = response;
    });

    $scope.openAside = function (position) {
        $aside.open({
            templateUrl: 'asideContent.html',
            placement: position,
            size: 'sm',
            backdrop: true,
            controller: function ($scope, $modalInstance) {
                $scope.ok = function (e) {
                    $modalInstance.close();
                    e.stopPropagation();
                };
                $scope.cancel = function (e) {
                    $modalInstance.dismiss();
                    e.stopPropagation();
                };
            }
        });
    };
}]);

app.controller('ReportDetailCtrl', ["$scope","$stateParams", function ($scope,$stateParams) {
    //alert($stateParams.reportId);
}]);

