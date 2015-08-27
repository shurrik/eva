define(function () {
  // Azerbaijani
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      return overChars + ' simvol silin';
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      return remainingChars + ' simvol daxil edin';
    },
    loadingMore: function () {
      return 'Daha 莽ox n蓹tic蓹 y眉kl蓹nir钬?;
    },
    maximumSelected: function (args) {
      return 'Sad蓹c蓹 ' + args.maximum + ' element se莽蓹 bil蓹rsiniz';
    },
    noResults: function () {
      return 'N蓹tic蓹 tap谋lmad谋';
    },
    searching: function () {
      return 'Axtar谋l谋r钬?;
    }
  };
});
