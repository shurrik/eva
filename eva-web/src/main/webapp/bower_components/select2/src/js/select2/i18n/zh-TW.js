define(function () {
  // Chinese (Traditional)
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = '璜嫔埅鎺? + overChars + '链嫔瓧鍏?;

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = '璜嫔啀杓稿叆' + remainingChars + '链嫔瓧鍏?;

      return message;
    },
    loadingMore: function () {
      return '杓夊叆涓€?;
    },
    maximumSelected: function (args) {
      var message = '浣犲彧鑳介夫鎿囨渶澶? + args.maximum + '阕?;

      return message;
    },
    noResults: function () {
      return '娌掓湁镓惧埌鐩哥镄勯爡鐩?;
    },
    searching: function () {
      return '鎼滃皨涓€?;
    }
  };
});
