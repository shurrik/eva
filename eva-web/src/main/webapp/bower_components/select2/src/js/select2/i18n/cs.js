define(function () {
  // Czech
  function small (count, masc) {
    switch(count) {
      case 2:
        return masc ? 'dva' : 'dv臎';
      case 3:
        return 't艡i';
      case 4:
        return '膷ty艡i';
    }
    return '';
  }
  return {
    errorLoading: function () {
      return 'V媒sledky nemohly b媒t na膷teny.';
    },
    inputTooLong: function (args) {
      var n = args.input.length - args.maximum;

      if (n == 1) {
        return 'Pros铆m zadejte o jeden znak m茅n臎';
      } else if (n <= 4) {
        return 'Pros铆m zadejte o ' + small(n, true) + ' znaky m茅n臎';
      } else {
        return 'Pros铆m zadejte o ' + n + ' znak暖 m茅n臎';
      }
    },
    inputTooShort: function (args) {
      var n = args.minimum - args.input.length;

      if (n == 1) {
        return 'Pros铆m zadejte je拧t臎 jeden znak';
      } else if (n <= 4) {
        return 'Pros铆m zadejte je拧t臎 dal拧铆 ' + small(n, true) + ' znaky';
      } else {
        return 'Pros铆m zadejte je拧t臎 dal拧铆ch ' + n + ' znak暖';
      }
    },
    loadingMore: function () {
      return 'Na膷铆taj铆 se dal拧铆 v媒sledky钬?;
    },
    maximumSelected: function (args) {
      var n = args.maximum;

      if (n == 1) {
        return 'M暖啪ete zvolit jen jednu polo啪ku';
      } else if (n <= 4) {
        return 'M暖啪ete zvolit maxim谩ln臎 ' + small(n, false) + ' polo啪ky';
      } else {
        return 'M暖啪ete zvolit maxim谩ln臎 ' + n + ' polo啪ek';
      }
    },
    noResults: function () {
      return 'Nenalezeny 啪谩dn茅 polo啪ky';
    },
    searching: function () {
      return 'Vyhled谩v谩n铆钬?;
    }
  };
});
