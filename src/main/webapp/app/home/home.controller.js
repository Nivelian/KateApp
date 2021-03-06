(function() {
    'use strict';

    angular
        .module('kateApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'Principal', 'LoginService', '$state'];

    function HomeController ($scope, Principal, LoginService, $state) {
        var vm = this;

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.register = register;
        
        $scope.$on('authenticationSuccess', function() {
            getAccount();
            $state.go('request');
        });

        getAccount();

        function getAccount() {
            Principal.identity().then(function(account) {
                vm.account = account;
                vm.isAuthenticated = Principal.isAuthenticated;
                if(vm.isAuthenticated() === true)
                	$state.go('request');
            });
        }
        function register () {
            $state.go('register');
        }
    }
})();
