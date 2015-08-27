define(function () {
  // Ukranian
  function ending (count, one, couple, more) {
    if (count % 100 > 10 && count % 100 < 15) {
      return more;
    }
    if (count % 10 === 1) {
      return one;
    }
    if (count % 10 > 1 && count % 10 < 5) {
      return couple;
    }
    return more;
  }

  return {
    errorLoading: function () {
      return '袧械屑芯卸谢懈胁芯 蟹邪胁邪薪褌邪卸懈褌懈 褉械蟹褍谢褜褌邪褌懈';
    },
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;
      return '袘褍写褜 谢邪褋泻邪, 胁懈写邪谢褨褌褜 ' + overChars + ' ' +
        ending(args.maximum, '谢褨褌械褉褍', '谢褨褌械褉懈', '谢褨褌械褉');
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;
      return '袘褍写褜 谢邪褋泻邪, 胁胁械写褨褌褜 ' + remainingChars + ' 邪斜芯 斜褨谢褜褕械 谢褨褌械褉';
    },
    loadingMore: function () {
      return '袟邪胁邪薪褌邪卸械薪薪褟 褨薪褕懈褏 褉械蟹褍谢褜褌邪褌褨胁钬?;
    },
    maximumSelected: function (args) {
      return '袙懈 屑芯卸械褌械 胁懈斜褉邪褌懈 谢懈褕械 ' + args.maximum + ' ' +
        ending(args.maximum, '锌褍薪泻褌', '锌褍薪泻褌懈', '锌褍薪泻褌褨胁');
    },
    noResults: function () {
      return '袧褨褔芯谐芯 薪械 蟹薪邪泄写械薪芯';
    },
    searching: function () {
      return '袩芯褕褍泻钬?;
    }
  };
});
