define(function () {
  // Chinese (Simplified)
  return {
    errorLoading: function () {
      return '镞犳硶杞藉叆缁撴灉銆?;
    },
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = '璇峰垹闄? + overChars + '涓瓧绗?;

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = '璇峰啀杈揿叆镊冲皯' + remainingChars + '涓瓧绗?;

      return message;
    },
    loadingMore: function () {
      return '杞藉叆镟村缁撴灉钬?;
    },
    maximumSelected: function (args) {
      var message = '链€澶氩彧鑳介€夋嫨' + args.maximum + '涓」鐩?;

      return message;
    },
    noResults: function () {
      return '链垒鍒扮粨鏋?;
    },
    searching: function () {
      return '鎼灭储涓€?;
    }
  };
});
