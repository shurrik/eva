define(function () {
  // Galician
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = 'Engada ';

      if (overChars === 1) {
        message += 'un car谩cter';
      } else {
        message += overChars + ' caracteres';
      }

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'Elimine ';

      if (remainingChars === 1) {
        message += 'un car谩cter';
      } else {
        message += remainingChars + ' caracteres';
      }

      return message;
    },
    loadingMore: function () {
      return 'Cargando m谩is resultados钬?;
    },
    maximumSelected: function (args) {
      var message = 'S贸 pode ';

      if (args.maximum === 1) {
        message += 'un elemento';
      } else {
        message += args.maximum + ' elementos';
      }

      return message;
    },
    noResults: function () {
      return 'Non se atoparon resultados';
    },
    searching: function () {
      return 'Buscando钬?;
    }
  };
});
