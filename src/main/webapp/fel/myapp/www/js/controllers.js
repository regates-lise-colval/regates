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
    ctrl.scores;

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
            url: 'http://localhost:8080/regates/webresources/escore/event/' + $stateParams.eventId
        }).then(function successCallback(response) {

                ctrl.scores = response.data;
                console.log(ctrl.scores);


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

.controller('ContestsCtrl', function ($scope, $http, Contests) {
    var ctrl = this;
    ctrl.contests;

    ctrl.loadContests = function () {

        ctrl.getContests();
        //Contests.set(ctrl.contests);

    }

    ctrl.getContests = function () {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/regates/webresources/contests'
        }).then(function successCallback(response) {

            ctrl.contests = response.data;
            console.log(ctrl.contests);

        }, function errorCallback(response) {});
    }

})

.controller('ContestInfoCtrl', function ($scope, $stateParams, $http, Contests) {
    var ctrl = this;
    ctrl.contest;
    ctrl.events;


    ctrl.loadContest = function () {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/regates/webresources/contests/' + $stateParams.contestId
        }).then(function successCallback(response) {

                ctrl.contest = response.data;

            },
            function errorCallback(response) {});

        $http({
            method: 'GET',
            url: 'http://localhost:8080/regates/webresources/events/contest/' + $stateParams.contestId
        }).then(function successCallback(response) {

                ctrl.events = response.data;
                console.log(ctrl.events);

            },
            function errorCallback(response) {});
    }
})

.controller('AccountCtrl', function ($scope) {
    $scope.settings = {
        enableFriends: true
    };
});