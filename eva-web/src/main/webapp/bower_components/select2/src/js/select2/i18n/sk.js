define(function () {
  // Slovak

  // use text for the numbers 2 through 4
  var smallNumbers = {
    2: function (masc) { return (masc ? 'dva' : 'dve'); },
    3: function () { return 'tri'; },
    4: function () { return '拧tyri'; }
  };

  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      if (overChars == 1) {
        return 'Pros铆m, zadajte o jeden znak menej';
      } else if (overChars >= 2 && overChars <= 4) {
        return 'Pros铆m, zadajte o ' + smallNumbers[overChars](true) +
          ' znaky menej';
      } else {
        return 'Pros铆m, zadajte o ' + overChars + ' znakov menej';
      }
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      if (remainingChars == 1) {
        return 'Pros铆m, zadajte e拧te jeden znak';
      } else if (remainingChars <= 4) {
        return 'Pros铆m, zadajte e拧te 膹al拧ie ' +
          smallNumbers[remainingChars](true) + ' znaky';
      } else {
        return 'Pros铆m, zadajte e拧te 膹al拧铆ch ' + remainingChars + ' znakov';
      }
    },
    loadingMore: function () {
      return 'Loading more results钬?;
    },
    maximumSelected: function (args) {
      if (args.maximum == 1) {
        return 'M么啪ete zvoli钮 len jednu polo啪ku';
      } else if (args.maximum >= 2 && args.maximum <= 4) {
        return 'M么啪ete zvoli钮 najviac ' + smallNumbers[args.maximum](false) +
          ' polo啪ky';
      } else {
        return 'M么啪ete zvoli钮 najviac ' + args.maximum + ' polo啪iek';
      }
    },
    noResults: function () {
      return 'Nena拧li sa 啪iadne polo啪ky';
    },
    searching: function () {
      return 'Vyh木ad谩vanie钬?;
    }
  };
});
