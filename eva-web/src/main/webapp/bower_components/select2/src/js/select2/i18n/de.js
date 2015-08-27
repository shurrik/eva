define(function () {
  // German
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      return 'Bitte ' + overChars + ' Zeichen weniger eingeben';
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      return 'Bitte ' + remainingChars + ' Zeichen mehr eingeben';
    },
    loadingMore: function () {
      return 'Lade mehr Ergebnisse钬?;
    },
    maximumSelected: function (args) {
      var message = 'Sie k枚nnen nur ' + args.maximum + ' Eintr';

      if (args.maximum === 1) {
        message += 'ag';
      } else {
        message += '盲ge';
      }

      message += ' ausw盲hlen';

      return message;
    },
    noResults: function () {
      return 'Keine 脺bereinstimmungen gefunden';
    },
    searching: function () {
      return 'Suche钬?;
    }
  };
});
