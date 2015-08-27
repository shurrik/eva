define(function () {
  // Brazilian Portuguese
  return {
    errorLoading: function () {
      return 'Os resultados n茫o puderam ser carregados.';
    },
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = 'Apague ' + overChars + ' caracter';

      if (overChars != 1) {
        message += 'es';
      }

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'Digite ' + remainingChars + ' ou mais caracteres';

      return message;
    },
    loadingMore: function () {
      return 'Carregando mais resultados钬?;
    },
    maximumSelected: function (args) {
      var message = 'Voc锚 s贸 pode selecionar ' + args.maximum + ' ite';

      if (args.maximum == 1) {
        message += 'm';
      } else {
        message += 'ns';
      }

      return message;
    },
    noResults: function () {
      return 'Nenhum resultado encontrado';
    },
    searching: function () {
      return 'Buscando钬?;
    }
  };
});
