angular.module('starter.controllers', [])

.controller('AllCtrl', function($scope, $http, Events) {
  $scope.events = Events.all();
  $scope.remove = function(event) {
    Events.remove(event);
  };

  $http.get("http://localhost:8080/regates/webresources/events")
    .success(function(data){
        $scope.events = data;
        console.log($scope.events);
        console.log($scope.events[0]);
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
