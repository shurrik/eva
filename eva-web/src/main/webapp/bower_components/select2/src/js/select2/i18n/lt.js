define(function () {
  // Italian
  function ending (count, first, second, third) {
    if ((count % 100 > 9 && count % 100 < 21) || count % 10 === 0) {
      if (count % 10 > 1) {
        return second;
      } else {
        return third;
      }
    } else {
      return first;
    }
  }

  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = 'Pa拧alinkite ' + overChars + ' simbol';

      message += ending(overChars, 'i懦', 'ius', '寞');

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = '漠ra拧ykite dar ' + remainingChars + ' simbol';

      message += ending(remainingChars, 'i懦', 'ius', '寞');

      return message;
    },
    loadingMore: function () {
      return 'Kraunama daugiau rezultat懦钬?;
    },
    maximumSelected: function (args) {
      var message = 'J奴s galite pasirinkti tik ' + args.maximum + ' element';

      message += ending(args.maximum, '懦', 'us', '膮');

      return message;
    },
    noResults: function () {
      return 'Atitikmen懦 nerasta';
    },
    searching: function () {
      return 'Ie拧koma钬?;
    }
  };
});
