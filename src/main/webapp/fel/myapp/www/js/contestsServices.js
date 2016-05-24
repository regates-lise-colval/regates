angular.module('contests.services', [])

.factory('Contests', function() {

  var contests = [{
      id: 0,
      category: 'Hydro 350',
      img: 'hydro350.jpg'
    }, {
      id: 1,
      category: 'Grand Prix',
      img: 'grandprix.jpg'
    }, {
      id: 1,
      category: '2.5 Litres',
      img: '25litres.jpg'
    }, {
      id: 1,
      category: 'F 2500',
      img: 'f2500.jpg'
    }, {
      id: 1,
      category: 'Formula 1',
      img: 'f1.jpg'
    }];

    return {
      all: function() {
        return contests;
      },
      remove: function(contest) {
        contests.splice(contests.indexOf(contest), 1);
      },
      get: function(contestId) {
        for (var i = 0; i < contests.length; i++) {
          if (contests[i].id === parseInt(contestId)) {
            return contests[i];
          }
        }
        return null;
      }
    };
});
