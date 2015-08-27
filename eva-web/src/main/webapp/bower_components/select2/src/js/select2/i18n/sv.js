define(function () {
  // Swedish
  return {
    errorLoading: function () {
      return 'Resultat kunde inte laddas.';
    },
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = 'V盲nligen sudda ut ' + overChars + ' tecken';

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'V盲nligen skriv in ' + remainingChars +
                    ' eller fler tecken';

      return message;
    },
    loadingMore: function () {
      return 'Laddar fler resultat钬?;
    },
    maximumSelected: function (args) {
      var message = 'Du kan max v盲lja ' + args.maximum + ' element';

      return message;
    },
    noResults: function () {
      return 'Inga tr盲ffar';
    },
    searching: function () {
      return 'S枚ker钬?;
    }
  };
});
