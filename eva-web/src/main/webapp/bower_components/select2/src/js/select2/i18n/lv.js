define(function () {
  // Latvian
  function ending (count, eleven, singular, other) {
    if (count === 11) {
      return eleven;
    }

    if (count % 10 === 1) {
      return singular;
    }

    return other;
  }

  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = 'L奴dzu ievadiet par  ' + overChars;

      message += ' simbol' + ending(overChars, 'iem', 'u', 'iem');

      return message + ' maz腻k';
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'L奴dzu ievadiet v脓l ' + remainingChars;

      message += ' simbol' + ending(remainingChars, 'us', 'u', 'us');

      return message;
    },
    loadingMore: function () {
      return 'Datu iel腻de钬?;
    },
    maximumSelected: function (args) {
      var message = 'J奴s varat izv脓l脓ties ne vair腻k k腻 ' + args.maximum;

      message += ' element' + ending(args.maximum, 'us', 'u', 'us');

      return message;
    },
    noResults: function () {
      return 'Sakrit墨bu nav';
    },
    searching: function () {
      return 'Mekl脓拧ana钬?;
    }
  };
});
