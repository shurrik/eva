define(function () {
  // Spanish
  return {
    errorLoading: function () {
      return 'La carga fall贸';
    },
    inputTooLong: function (args) {
      var remainingChars = args.input.length - args.maximum;

      var message = 'Por favor, elimine ' + remainingChars + ' car';

      if (remainingChars == 1) {
        message += '谩cter';
      } else {
        message += 'acteres';
      }

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'Por favor, introduzca ' + remainingChars + ' car';

      if (remainingChars == 1) {
        message += '谩cter';
      } else {
        message += 'acteres';
      }

      return message;
    },
    loadingMore: function () {
      return 'Cargando m谩s resultados钬?;
    },
    maximumSelected: function (args) {
      var message = 'S贸lo puede seleccionar ' + args.maximum + ' elemento';

      if (args.maximum != 1) {
        message += 's';
      }

      return message;
    },
    noResults: function () {
      return 'No se encontraron resultados';
    },
    searching: function () {
      return 'Buscando钬?;
    }
  };
});
