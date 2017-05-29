(function() {
    'use strict';

    var jhiItemCount = {
        template: '<div class="info">' +
                    '<span data-translate="global.form.showing">Showing</span> {{(($ctrl.page - 1) * $ctrl.itemsPerPage) == 0 ? 1 : (($ctrl.page - 1) * $ctrl.itemsPerPage + 1)}} - ' +
                    '{{($ctrl.page * $ctrl.itemsPerPage) < $ctrl.queryCount ? ($ctrl.page * $ctrl.itemsPerPage) : $ctrl.queryCount}} ' +
                    '<span data-translate="global.form.of">of</span> {{$ctrl.queryCount}} <span data-translate="global.form.items">items</span>.' +
                '</div>',
        bindings: {
            page: '<',
            queryCount: '<total',
            itemsPerPage: '<'
        }
    };

    angular
        .module('kateApp')
        .component('jhiItemCount', jhiItemCount);
})();
