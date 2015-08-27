define(function () {
  // Macedonian
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = '袙械 屑芯谢懈屑械 胁薪械褋械褌械 ' + args.maximum + ' 锌芯屑邪谢泻褍 泻邪褉邪泻褌械褉';

      if (args.maximum !== 1) {
        message += '懈';
      }

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = '袙械 屑芯谢懈屑械 胁薪械褋械褌械 褍褕褌械 ' + args.maximum + ' 泻邪褉邪泻褌械褉';

      if (args.maximum !== 1) {
        message += '懈';
      }

      return message;
    },
    loadingMore: function () {
      return '袙褔懈褌褍胁邪褮械 褉械蟹褍谢褌邪褌懈钬?;
    },
    maximumSelected: function (args) {
      var message = '袦芯卸械褌械 写邪 懈蟹斜械褉械褌械 褋邪屑芯 ' + args.maximum + ' 褋褌邪胁泻';

      if (args.maximum === 1) {
        message += '邪';
      } else {
        message += '懈';
      }

      return message;
    },
    noResults: function () {
      return '袧械屑邪 锌褉芯薪邪褬写械薪芯 褋芯胁锌邪褤邪褮邪';
    },
    searching: function () {
      return '袩褉械斜邪褉褍胁邪褮械钬?;
    }
  };
});
