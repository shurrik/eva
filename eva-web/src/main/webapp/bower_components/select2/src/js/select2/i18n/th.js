define(function () {
  // Thai
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = '喙傕笡喔｀笖喔ム笟喔腑喔?' + overChars + ' 喔曕副喔о腑喔编竵喔┼福';

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = '喙傕笡喔｀笖喔炧复喔∴笧喙屶箑喔炧复喙堗浮喔傅喔?' + remainingChars + ' 喔曕副喔о腑喔编竵喔┼福';

      return message;
    },
    loadingMore: function () {
      return '喔佮赋喔ム副喔囙竸喙夃笝喔傕箟喔浮喔灌弗喙€喔炧复喙堗浮钬?;
    },
    maximumSelected: function (args) {
      var message = '喔剿父喔撪釜喔侧浮喔侧福喔栢箑喔ム阜喔竵喙剿笖喙夃箘喔∴箞喙€喔佮复喔?' + args.maximum + ' 喔｀覆喔⑧竵喔侧福';

      return message;
    },
    noResults: function () {
      return '喔∴箞喔炧笟喔傕箟喔浮喔灌弗';
    },
    searching: function () {
      return '喔佮赋喔ム副喔囙竸喙夃笝喔傕箟喔浮喔灌弗钬?;
    }
  };
});
