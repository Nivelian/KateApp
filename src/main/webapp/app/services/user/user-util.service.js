(function() {
    'use strict';

    angular
        .module('kateApp')
        .factory('UserUtil', UserUtil);

    UserUtil.$inject = ['$http'];

    function UserUtil ($http) {

        var service = {
            getLoggedUser: getLoggedUser
        };

        return service;

        function getLoggedUser () {
            return $http.get('api/users/logged-user').then(function(result) {
            	return result.data;
            });
        }
    }
})();
