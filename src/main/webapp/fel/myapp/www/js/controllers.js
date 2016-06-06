angular.module('starter.controllers', [])

.controller('EventsCtrl', function ($scope, $http, Events) {

    var ctrl = this;
    ctrl.events;

    ctrl.loadEvent = function () {

        ctrl.getEvents();
        Events.set(ctrl.events);

    }

    ctrl.getEvents = function () {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/regates/webresources/events'
        }).then(function successCallback(response) {

            ctrl.events = response.data;

        }, function errorCallback(response) {});
    }
})

.controller('EventInfoCtrl', function ($scope, $http, $stateParams, $ionicNavBarDelegate, Events, Ships) {
    var ctrl = this;
    ctrl.event;
    ctrl.i = 0;
    //ctrl.races = [];


    ctrl.loadEvent = function () {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/regates/webresources/events/' + $stateParams.eventId
        }).then(function successCallback(response) {

                ctrl.event = response.data;
                ctrl.event.races = [];
                //console.log(ctrl.event);
                for (var i = 0; i < ctrl.event.racesId.length; i++) {



                    $http({
                        method: 'GET',
                        url: 'http://localhost:8080/regates/webresources/races/' + ctrl.event.racesId[i]
                    }).then(function successCallback(response) {

                            //ctrl.races.push(response.data);
                            ctrl.event.races.push(response.data);
                            console.log(ctrl.event.races[ctrl.i]);

                            //ctrl.event.races[ctrl.i].participations = [];


                            ctrl.i++;

                            console.log(ctrl.event.races);

                        },
                        function errorCallback(response) {});
                }


            },
            function errorCallback(response) {});
    }

})

.controller('EventScoreCtrl', function ($scope, $stateParams, $http, Events, Ships) {

    var ctrl = this;
    ctrl.event;
    ctrl.participations;

    ctrl.loadEvent = function () {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/regates/webresources/events/' + $stateParams.eventId
        }).then(function successCallback(response) {

                ctrl.event = response.data;


            },
            function errorCallback(response) {});

        $http({
            method: 'GET',
            url: 'http://localhost:8080/regates/webresources/participations/event/' + $stateParams.eventId
        }).then(function successCallback(response) {

                ctrl.participations = response.data;
                console.log(ctrl.participations);


            },
            function errorCallback(response) {});
    }

})

.controller('ShipsCtrl', function ($scope, Ships) {
    $scope.ships = Ships.all();
    $scope.remove = function (ships) {
        Ships.remove(ships);
    };
})

.controller('ContestsCtrl', function ($scope, Contests) {
    // With the new view caching in Ionic, Controllers are only called
    // when they are recreated or on app start, instead of every page change.
    // To listen for when this page is active (for example, to refresh data),
    // listen for the $ionicView.enter event:
    //
    //$scope.$on('$ionicView.enter', function(e) {
    //});

    $scope.contests = Contests.all();
    $scope.remove = function (contests) {
        Contests.remove(contests);
    };
})

.controller('AccountCtrl', function ($scope) {
    $scope.settings = {
        enableFriends: true
    };
});