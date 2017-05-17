(function() {
    'use strict';

    angular
        .module('kateApp')
        .controller('RequestDialogController', RequestDialogController);

    RequestDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Request', 'User', 'Service'];

    function RequestDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Request, User, Service) {
        var vm = this;

        vm.request = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.users = User.query();
        vm.services = Service.query();
        vm.serviceChange = serviceChange;
        vm.squareChange = squareChange;
        vm.chosenServices = angular.copy(vm.request.services);

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            vm.request.services = vm.chosenServices;
            if (vm.request.id !== null) {
                Request.update(vm.request, onSaveSuccess, onSaveError);
            } else {
                Request.save(vm.request, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('kateApp:requestUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.lastModifiedDate = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
        
        function serviceChange() {        	
        	var support = [];
        	
        	vm.request.services.forEach(function(item) {
        		vm.chosenServices.forEach(function(chosenItem) {
        			if(item.id === chosenItem.id) {
        				support.push(chosenItem);
        			}
        				
        		});
        	});
        	
        	vm.chosenServices = vm.request.services;
        	
        	vm.chosenServices.forEach(function(item, i, array) {
        		support.forEach(function(supItem) {
        			if(item.id === supItem.id) {
        				array[i] = supItem;
        			}
        		});
        	});
        		
        	var total = 0;
        	vm.chosenServices.forEach(function(item) {
        		if(item.price)
        			total += item.price;
        		else
        			total += item.cost;
        	});
        	vm.request.total = total;
        }
        
        function squareChange() {
        	var total = 0;
        	vm.chosenServices.forEach(function(item) {
        		item.price = item.square ? item.cost * item.square : undefined;
        		if(item.price)
        			total += item.price;
        		else
        			total += item.cost;
        	});
        	vm.request.total = total;
        }
        
        squareChange();
    }
})();
