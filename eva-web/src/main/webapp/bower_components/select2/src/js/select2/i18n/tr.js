define(function () {
  // Turkish
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = overChars + ' karakter daha girmelisiniz';

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'En az ' + remainingChars + ' karakter daha girmelisiniz';

      return message;
    },
    loadingMore: function () {
      return 'Daha fazla钬?;
    },
    maximumSelected: function (args) {
      var message = 'Sadece ' + args.maximum + ' se莽im yapabilirsiniz';

      return message;
    },
    noResults: function () {
      return 'Sonu莽 bulunamad谋';
    },
    searching: function () {
      return 'Aran谋yor钬?;
    }
  };
});
