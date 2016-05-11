angular.module('starter.controllers', [])

.controller('AllCtrl', function($scope, $http, Events) {
  $scope.events = Events.all();
  $scope.remove = function(event) {
    Events.remove(event);
  };

  $scope.events = {};

  $http({
  method: 'GET',
  url: 'http://localhost:8080/regates/events'
  }).then(function successCallback(response) {
    $scope.events = response.data;
    console.log(response.data[0]);
  }, function errorCallback(response) {
  });
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

.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
  $scope.chat = Chats.get($stateParams.chatId);
})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
