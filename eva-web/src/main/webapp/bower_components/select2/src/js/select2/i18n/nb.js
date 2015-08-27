define(function () {
  // Norwegian (Bokm氓l)
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      return 'Vennligst fjern ' + overChars + ' tegn';
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'Vennligst skriv inn ';

      if (remainingChars > 1) {
        message += ' flere tegn';
      } else {
        message += ' tegn til';
      }

      return message;
    },
    loadingMore: function () {
      return 'Laster flere resultater钬?;
    },
    maximumSelected: function (args) {
      return 'Du kan velge maks ' + args.maximum + ' elementer';
    },
    noResults: function () {
      return 'Ingen treff';
    },
    searching: function () {
      return 'S酶ker钬?;
    }
  };
});
