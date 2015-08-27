define(function () {
  // Bulgarian
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = '袦芯谢褟 胁褗胁械写械褌械 褋 ' + overChars + ' 锌芯-屑邪谢泻芯 褋懈屑胁芯谢';

      if (overChars > 1) {
        message += 'a';
      }

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = '袦芯谢褟 胁褗胁械写械褌械 芯褖械 ' + remainingChars + ' 褋懈屑胁芯谢';

      if (remainingChars > 1) {
        message += 'a';
      }

      return message;
    },
    loadingMore: function () {
      return '袟邪褉械卸写邪褌 褋械 芯褖械钬?;
    },
    maximumSelected: function (args) {
      var message = '袦芯卸械褌械 写邪 薪邪锌褉邪胁懈褌械 写芯 ' + args.maximum + ' ';

      if (args.maximum > 1) {
        message += '懈蟹斜芯褉邪';
      } else {
        message += '懈蟹斜芯褉';
      }

      return message;
    },
    noResults: function () {
      return '袧褟屑邪 薪邪屑械褉械薪懈 褋褗胁锌邪写械薪懈褟';
    },
    searching: function () {
      return '孝褗褉褋械薪械钬?;
    }
  };
});
