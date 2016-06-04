angular.module('participations.services', [])

.factory('Participations', function () {

    var object = this;

    object.participations = {};

    return {
        all: function () {
            return participations;
        },
        remove: function (participation) {
            participations.splice(participations.indexOf(participation), 1);
        },
        get: function (participationId) {
            for (var i = 0; i < participations.length; i++) {
                if (participations[i].id === parseInt(participationId)) {
                    return participations[i];
                }
            }
            return null;
        },
        set: function (value) {
            object.participations = value;
        }
    };
});