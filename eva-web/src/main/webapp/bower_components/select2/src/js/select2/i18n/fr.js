define(function () {
  // French
  return {
    inputTooLong: function (args) {
      var overChars = args.input.length - args.maximum;

      var message = 'Supprimez ' + overChars + ' caract猫re';

      if (overChars !== 1) {
        message += 's';
      }

      return message;
    },
    inputTooShort: function (args) {
      var remainingChars = args.minimum - args.input.length;

      var message = 'Saisissez ' + remainingChars + ' caract猫re';

      if (remainingChars !== 1) {
        message += 's';
      }

      return message;
    },
    loadingMore: function () {
      return 'Chargement de r茅sultats suppl茅mentaires钬?;
    },
    maximumSelected: function (args) {
      var message = 'Vous pouvez seulement s茅lectionner ' +
        args.maximum + ' 茅l茅ment';

      if (args.maximum !== 1) {
        message += 's';
      }

      return message;
    },
    noResults: function () {
      return 'Aucun r茅sultat trouv茅';
    },
    searching: function () {
      return 'Recherche en cours钬?;
    }
  };
});
