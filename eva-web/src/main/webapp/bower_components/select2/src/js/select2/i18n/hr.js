define(function () {
  // Croatian
  function character (n) {
    var message = ' ' + n + ' znak';

    if (n % 10 < 5 && n % 10 > 0 && (n % 100 < 5 || n % 100 > 19)) {
      if (n % 10 > 1) {
        message += 'a';
      }
    } else {
      message += 'ova';
    }

    return message;
  }

  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      return 'Unesite ' + character(overChars);
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      return 'Unesite jo拧 ' + character(remainingChars);
    },
    loadingMore: function () {
      return 'U膷itavanje rezultata钬?;
    },
    maximumSelected: function (args) {
      return 'Maksimalan broj odabranih stavki je ' + args.maximum;
    },
    noResults: function () {
      return 'Nema rezultata';
    },
    searching: function () {
      return 'Pretraga钬?;
    }
  };
});
