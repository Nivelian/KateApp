(function() {
    'use strict';

    angular
        .module('kateApp')
        .controller('ServiceDetailController', ServiceDetailController);

    ServiceDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Service'];

    function ServiceDetailController($scope, $rootScope, $stateParams, previousState, entity, Service) {
        var vm = this;

        vm.service = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('kateApp:serviceUpdate', function(event, result) {
            vm.service = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
