angular.module('events.services', [])

.factory('Events', function ($http) {

    var object = this;

    object.events = {};

    return {
        all: function () {
            return events;
        },
        remove: function (event) {
            events.splice(events.indexOf(event), 1);
        },
        get: function (eventId) {
            for (var i = 0; i < events.length; i++) {
                if (events[i].id === parseInt(eventId)) {
                    return events[i];
                }
            }
            return null;
        },
        set: function (value) {
            object.events = value;
        }
    };
});