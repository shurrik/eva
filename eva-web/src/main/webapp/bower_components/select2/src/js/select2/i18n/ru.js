define(function () {
  // Russian
  function ending (count, one, couple, more) {
    if (count % 10 < 5 && count % 10 > 0 &&
        count % 100 < 5 || count % 100 > 20) {
      if (count % 10 > 1) {
        return couple;
      }
    } else {
      return more;
    }

    return one;
  }

  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = '袩芯卸邪谢褍泄褋褌邪, 胁胁械写懈褌械 薪邪 ' + overChars + ' 褋懈屑胁芯谢';

      message += ending(overChars, '', 'a', '芯胁');

      message += ' 屑械薪褜褕械';

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = '袩芯卸邪谢褍泄褋褌邪, 胁胁械写懈褌械 械褖械 褏芯褌褟 斜褘 ' + remainingChars +
        ' 褋懈屑胁芯谢';

      message += ending(remainingChars, '', 'a', '芯胁');

      return message;
    },
    loadingMore: function () {
      return '袟邪谐褉褍蟹泻邪 写邪薪薪褘褏钬?;
    },
    maximumSelected: function (args) {
      var message = '袙褘 屑芯卸械褌械 胁褘斜褉邪褌褜 薪械 斜芯谢械械 ' + args.maximum + ' 褝谢械屑械薪褌';

      message += ending(args.maximum, '', 'a', '芯胁');

      return message;
    },
    noResults: function () {
      return '小芯胁锌邪写械薪懈泄 薪械 薪邪泄写械薪芯';
    },
    searching: function () {
      return '袩芯懈褋泻钬?;
    }
  };
});
