angular.module('ships.services', [])

.factory('Ships', function() {

  var ships = [{
    id: 1,
    tag: 255,
    driver: 'Vincent Laude',
    img: '255.jpg'
  }, {
    id: 2,
    tag: 42,
    driver: 'Dylan Guerville',
    img: '42.jpg'
  }, {
    id: 3,
    tag: 489,
    driver: 'Léa Masciantonio',
    img: '489.jpg'
  }, {
    id: 4,
    tag: 12,
    driver: 'M. Amine',
    img: '12.jpg'
  }, {
    id: 5,
    tag: 56,
    driver: 'M. Lotfi',
    img: '56.jpg'
  }];

  return {
      all: function() {
        return ships;
      },
      remove: function(ship) {
        ships.splice(ships.indexOf(ship), 1);
      },
      get: function(shipId) {
        for (var i = 0; i < ships.length; i++) {
          if (ships[i].id === parseInt(shipId)) {
            return ships[i];
          }
        }
        return null;
      }
    };

});
