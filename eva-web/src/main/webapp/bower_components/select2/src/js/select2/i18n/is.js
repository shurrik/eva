define(function () {
  // Icelandic
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = 'Vinsamlegast stytti冒 texta um ' + overChars + ' staf';

      if (overChars <= 1) {
        return message;
      }

      return message + 'i';
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'Vinsamlegast skrifi冒 ' + remainingChars + ' staf';

      if (remainingChars > 1) {
        message += 'i';
      }

      message += ' 铆 vi冒b贸t';

      return message;
    },
    loadingMore: function () {
      return 'S忙ki fleiri ni冒urst枚冒ur钬?;
    },
    maximumSelected: function (args) {
      return '脼煤 getur a冒eins vali冒 ' + args.maximum + ' atri冒i';
    },
    noResults: function () {
      return 'Ekkert fannst';
    },
    searching: function () {
      return 'Leita钬?;
    }
  };
});
