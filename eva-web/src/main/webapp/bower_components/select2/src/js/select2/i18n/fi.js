define(function () {
  // Finnish
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      return 'Ole hyv盲 ja anna ' + overChars + ' merkki盲 v盲hemm盲n';
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      return 'Ole hyv盲 ja anna ' + remainingChars + ' merkki盲 lis盲盲';
    },
    loadingMore: function () {
      return 'Ladataan lis盲盲 tuloksia钬?;
    },
    maximumSelected: function (args) {
      return 'Voit valita ainoastaan ' + args.maximum + ' kpl';
    },
    noResults: function () {
      return 'Ei tuloksia';
    },
    searching: function () {

    }
  };
});
