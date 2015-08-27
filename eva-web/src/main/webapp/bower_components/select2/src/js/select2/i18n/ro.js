define(function () {
  // Romanian
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = 'V膬 rug膬m s膬 introduce葲i mai pu葲in de ' + overChars;
      message += ' caracter';

      if (message !== 1) {
        message += 'e';
      }

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'V膬 rug膬m s膬 introduce葲i inc膬 ' + remainingChars;
      message += ' caracter';

      if (message !== 1) {
        message += 'e';
      }

      return message;
    },
    loadingMore: function () {
      return 'Se 卯ncarc膬钬?;
    },
    maximumSelected: function (args) {
      var message = 'Ave葲i voie s膬 selecta葲i cel mult ' + args.maximum;
      message += ' element';

      if (message !== 1) {
        message += 'e';
      }

      return message;
    },
    noResults: function () {
      return 'Nu a fost g膬sit nimic';
    },
    searching: function () {
      return 'C膬utare钬?;
    }
  };
});
