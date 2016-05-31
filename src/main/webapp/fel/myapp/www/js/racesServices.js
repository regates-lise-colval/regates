angular.module('races.services', [])

.factory('Races', function () {

    var object = this;

    object.races = {};

    return {
        all: function () {
            return races;
        },
        remove: function (race) {
            races.splice(races.indexOf(race), 1);
        },
        get: function (raceId) {
            for (var i = 0; i < races.length; i++) {
                if (races[i].id === parseInt(raceId)) {
                    return races[i];
                }
            }
            return null;
        },
        set: function (value) {
            object.races = value;
        }
    };
});