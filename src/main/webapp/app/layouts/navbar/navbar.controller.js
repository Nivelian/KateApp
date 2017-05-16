(function() {
    'use strict';

    angular
        .module('kateApp')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$scope', '$state', 'Auth', 'Principal', 'ProfileService', 'LoginService', 'UserUtil'];

    function NavbarController ($scope, $state, Auth, Principal, ProfileService, LoginService, UserUtil) {
        var vm = this;

        vm.isNavbarCollapsed = true;
        vm.isAuthenticated = Principal.isAuthenticated;

        ProfileService.getProfileInfo().then(function(response) {
            vm.inProduction = response.inProduction;
            vm.swaggerEnabled = response.swaggerEnabled;
        });

        vm.login = login;
        vm.logout = logout;
        vm.toggleNavbar = toggleNavbar;
        vm.collapseNavbar = collapseNavbar;
        vm.$state = $state;
        
        vm.currentUser = null;
        
        if(vm.isAuthenticated() === true) {
        	getCurrentUser();
        }
        
        $scope.$on('authenticationSuccess', function() {
        	getCurrentUser();
        });

        function login() {
            collapseNavbar();
            LoginService.open();
        }

        function logout() {
            collapseNavbar();
            Auth.logout();
            $state.go('home');
        }

        function toggleNavbar() {
            vm.isNavbarCollapsed = !vm.isNavbarCollapsed;
        }

        function collapseNavbar() {
            vm.isNavbarCollapsed = true;
        }
        
        function getCurrentUser() {
        	UserUtil.getLoggedUser().then(function(result) {
        		vm.currentUser = result;
        	});
        }
    }
})();
