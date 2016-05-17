angular.module('events.services', [])

.factory('Events', function() {



    /*
    var events = [{
      id: 1,
      city: 'Détroit',
      category: 'Hydro 350',
      date: '2016/06/20',
      img: 'detroit.jpg'
    }, {
      id: 2,
      city: 'Stuart',
      category: 'Hydro 350',
      date: '2016/06/20',
      img: 'stuart.jpg'
    }, {
      id: 3,
      city: 'Valleyfield',
      category: 'Hydro 350',
      date: '2016/06/20',
      img: 'Valleyfield.jpg'
    }, {
      id: 4,
      city: 'buffalo',
      category: 'Hydro 350',
      date: '2016/06/20',
      img: 'buffalo.jpg'
    }, {
      id: 5,
      city: 'St Felicien',
      category: 'Hydro 350',
      date: '2016/06/20',
      img: 'st_felicien.jpg'
    }, {
      id: 6,
      city: 'Détroit',
      category: 'Hydro 350',
      date: '2016/06/20',
      img: 'detroit.jpg'
    }, {
      id: 7,
      city: 'Valleyfield',
      category: 'Hydro 350',
      date: '2016/06/20',
      img: 'Valleyfield.jpg'
    }, {
      id: 8,
      city: 'Buffalo',
      category: 'Hydro 350',
      date: '2016/06/20',
      img: 'buffalo.jpg'
    }, {
      id: 9,
      city: 'Détroit',
      category: 'Hydro 350',
      date: '2016/06/20',
      img: 'detroit.jpg'
    }, {
      id: 10,
      city: 'Stuart',
      category: 'Hydro 350',
      date: '2016/06/20',
      img: 'stuart.jpg'
    }];
    */

    return {
      all: function() {
        return events;
      },
      remove: function(event) {
        events.splice(events.indexOf(event), 1);
      },
      get: function(eventId) {
        for (var i = 0; i < events.length; i++) {
          if (events[i].id === parseInt(eventId)) {
            return events[i];
          }
        }
        return null;
      }
    };
});
