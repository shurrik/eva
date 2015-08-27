define(function () {
  // Korean
  return {
    errorLoading: function () {
      return '瓴瓣臣毳?攵堧炀鞓?靾?鞐嗢姷雼堧嫟.';
    },
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = '雱堧 旯侂媹雼? ' + overChars + ' 旮€鞛?歆€鞗岇＜靹胳殧.';

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = '雱堧 歆ъ姷雼堧嫟. ' + remainingChars + ' 旮€鞛?雿?鞛呺牓顷挫＜靹胳殧.';

      return message;
    },
    loadingMore: function () {
      return '攵堧炀鞓る姅 欷戋€?;
    },
    maximumSelected: function (args) {
      var message = '斓滊寑 ' + args.maximum + '臧滉箤歆€毵?靹犿儩 臧€电ロ暕雼堧嫟.';

      return message;
    },
    noResults: function () {
      return '瓴瓣臣臧€ 鞐嗢姷雼堧嫟.';
    },
    searching: function () {
      return '瓴€靸?欷戋€?;
    }
  };
});
