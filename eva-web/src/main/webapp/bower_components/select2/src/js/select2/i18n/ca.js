define(function () {
  // Catalan
  return {
    errorLoading: function () {
      return 'La c脿rrega ha fallat';
    },
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = 'Si us plau, elimina ' + overChars + ' car';

      if (overChars == 1) {
        message += '脿cter';
      } else {
        message += '脿cters';
      }

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'Si us plau, introdueix ' + remainingChars + ' car';

      if (remainingChars == 1) {
        message += '脿cter';
      } else {
        message += '脿cters';
      }

      return message;
    },
    loadingMore: function () {
      return 'Carregant m茅s resultats钬?;
    },
    maximumSelected: function (args) {
      var message = 'Nom茅s es pot seleccionar ' + args.maximum + ' element';

      if (args.maximum != 1) {
        message += 's';
      }

      return message;
    },
    noResults: function () {
      return 'No s\'han trobat resultats';
    },
    searching: function () {
      return 'Cercant钬?;
    }
  };
});
