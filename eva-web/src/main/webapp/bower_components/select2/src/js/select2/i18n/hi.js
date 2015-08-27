define(function () {
  // Hindi
  return {
    errorLoading: function () {
      return '啶ぐ啶苦ぃ啶距ぎ啷嬥 啶曕 啶侧啶?啶ㄠす啷€啶?啶曕た啶ぞ 啶溹ぞ 啶膏啶距イ';
    },
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message =  overChars + ' 啶呧啷嵿し啶?啶曕 啶灌啶?啶︵啶?;

      if (overChars > 1) {
        message = overChars + ' 啶呧啷嵿し啶班啶?啶曕 啶灌啶?啶︵啶?';
      }

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = '啶曕啶く啶?' + remainingChars + ' 啶ぞ 啶呧ぇ啶苦 啶呧啷嵿し啶?啶︵ぐ啷嵿 啶曕ぐ啷囙';

      return message;
    },
    loadingMore: function () {
      return '啶呧ぇ啶苦 啶ぐ啶苦ぃ啶距ぎ 啶侧啶?啶灌 啶班す啷?啶灌...';
    },
    maximumSelected: function (args) {
      var message = '啶嗋お 啶曕啶掂げ ' + args.maximum + ' 啶嗋啶熰ぎ 啶曕ぞ 啶氞く啶?啶曕ぐ 啶膏啶む 啶灌啶?;
      return message;
    },
    noResults: function () {
      return '啶曕啶?啶ぐ啶苦ぃ啶距ぎ 啶ㄠす啷€啶?啶た啶侧ぞ';
    },
    searching: function () {
      return '啶栢啶?啶班す啶?啶灌...';
    }
  };
});
