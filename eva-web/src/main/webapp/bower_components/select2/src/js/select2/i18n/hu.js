define(function () {
  // Hungarian
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      return 'T煤l hossz煤. ' + overChars + ' karakterrel t枚bb, mint kellene.';
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      return 'T煤l r枚vid. M茅g ' + remainingChars + ' karakter hi谩nyzik.';
    },
    loadingMore: function () {
      return 'T枚lt茅s钬?;
    },
    maximumSelected: function (args) {
      return 'Csak ' + args.maximum + ' elemet lehet kiv谩lasztani.';
    },
    noResults: function () {
      return 'Nincs tal谩lat.';
    },
    searching: function () {
      return 'Keres茅s钬?;
    }
  };
});
