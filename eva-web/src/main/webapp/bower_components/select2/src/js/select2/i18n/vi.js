define(function () {
  // Vietnamese
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = 'Vui l貌ng nh岷璸 铆t h啤n ' + overChars + ' k媒 t峄?;

      if (overChars != 1) {
        message += 's';
      }

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'Vui l貌ng nh岷璸 nhi峄乽 h啤n ' + remainingChars + ' k媒 t峄?';

      return message;
    },
    loadingMore: function () {
      return '膼ang l岷 th锚m k岷演 qu岷ｂ€?;
    },
    maximumSelected: function (args) {
      var message = 'Ch峄?c贸 th峄?ch峄峮 胆瓢峄 ' + args.maximum + ' l峄盿 ch峄峮';

      return message;
    },
    noResults: function () {
      return 'Kh么ng t矛m th岷 k岷演 qu岷?;
    },
    searching: function () {
      return '膼ang t矛m钬?;
    }
  };
});
