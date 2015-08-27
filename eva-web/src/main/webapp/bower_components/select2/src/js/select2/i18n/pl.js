define(function () {
  // Polish
  var charsWords = ['znak', 'znaki', 'znak贸w'];
  var itemsWords = ['element', 'elementy', 'element贸w'];

  var pluralWord = function pluralWord(numberOfChars, words) {
    if (numberOfChars === 1) {
        return words[0];
    } else if (numberOfChars > 1 && numberOfChars <= 4) {
      return words[1];
    } else if (numberOfChars >= 5) {
      return words[2];
    }
  };
  
  return {
    errorLoading: function () {
      return 'Nie mo偶na za艂adowa膰 wynik贸w.';
    },
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      return 'Usu艅 ' + overChars + ' ' + pluralWord(overChars, charsWords);
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;
      
      return 'Podaj przynajmniej ' + remainingChars + ' ' +
        pluralWord(remainingChars, charsWords);
    },
    loadingMore: function () {
      return 'Trwa 艂adowanie钬?;
    },
    maximumSelected: function (args) {
      return 'Mo偶esz zaznaczy膰 tylko ' + args.maximum + ' ' +
        pluralWord(args.maxiumum, itemsWords);
    },
    noResults: function () {
      return 'Brak wynik贸w';
    },
    searching: function () {
      return 'Trwa wyszukiwanie钬?;
    }
  };
});