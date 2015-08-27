/* jshint -W100 */
/* jslint maxlen: 86 */
define(function () {
  // Farsi (Persian)
  return {
    errorLoading: function () {
      return '丕賲讴丕賳 亘丕乇诏匕丕乇蹖 賳鬲丕蹖噩 賵噩賵丿 賳丿丕乇丿.';
    },
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = '賱胤賮丕賸 ' + overChars + ' 讴丕乇丕讴鬲乇 乇丕 丨匕賮 賳賲丕蹖蹖丿';

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = '賱胤賮丕賸 鬲毓丿丕丿 ' + remainingChars + ' 讴丕乇丕讴鬲乇 蹖丕 亘蹖卮鬲乇 賵丕乇丿 賳賲丕蹖蹖丿';

      return message;
    },
    loadingMore: function () {
      return '丿乇 丨丕賱 亘丕乇诏匕丕乇蹖 賳鬲丕蹖噩 亘蹖卮鬲乇...';
    },
    maximumSelected: function (args) {
      var message = '卮賲丕 鬲賳赖丕 賲蹖钬屫堌з嗃屫?' + args.maximum + ' 丌蹖鬲賲 乇丕 丕賳鬲禺丕亘 賳賲丕蹖蹖丿';

      return message;
    },
    noResults: function () {
      return '赖蹖趩 賳鬲蹖噩赖钬屫й?蹖丕賮鬲 賳卮丿';
    },
    searching: function () {
      return '丿乇 丨丕賱 噩爻鬲噩賵...';
    }
  };
});
