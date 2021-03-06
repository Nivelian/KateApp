(function() {
    'use strict';

    angular
        .module('kateApp')
        .controller('RequestDetailController', RequestDetailController);

    RequestDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Request', 'User', 'Service'];

    function RequestDetailController($scope, $rootScope, $stateParams, previousState, entity, Request, User, Service) {
        var vm = this;

        vm.request = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('kateApp:requestUpdate', function(event, result) {
            vm.request = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
