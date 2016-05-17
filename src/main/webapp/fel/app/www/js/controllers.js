angular.module('starter.controllers', [])

.controller('EventsCtrl', function($scope, $http, Events) {

  $http({
  method: 'GET',
  url: 'http://localhost:8080/regates/webresources/events'
  }).then(function successCallback(response) {

    Events.events = response.data;
    $scope.events = Events.events;

  }, function errorCallback(response) {
  });
  //console.log(Events.events);
  //$scope.events = Events.all();
  $scope.remove = function(event) {
    Events.remove(event);
  };
})

.controller('EventInfoCtrl', function($scope, $stateParams, $ionicNavBarDelegate, Events, Ships) {
  /*
  $http({
  method: 'GET',
  url: 'http://localhost:8080/regates/webresources/events/' + $stateParams.eventId
  }).then(function successCallback(response) {
    $scope.event = response.data;
    console.log(response.data[0]);
  }, function errorCallback(response) {
  });
  */
  $scope.event = Events.get($stateParams.eventId);
  $scope.ships = Ships.all();
  $scope.remove = function(ships) {
    Ships.remove(ships);
  };
})

.controller('EventScoreCtrl', function($scope, $stateParams, Events, Ships) {

  $scope.event = Events.get($stateParams.eventId);
  $scope.ships = Ships.all();
  $scope.remove = function(ships) {
    Ships.remove(ships);
  };
})

.controller('ShipsCtrl', function($scope, Ships) {
  $scope.ships = Ships.all();
  $scope.remove = function(ships) {
    Ships.remove(ships);
  };
})

.controller('ContestsCtrl', function($scope, Contests) {
  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //
  //$scope.$on('$ionicView.enter', function(e) {
  //});

  $scope.contests = Contests.all();
  $scope.remove = function(contests) {
    Contests.remove(contests);
  };
})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
