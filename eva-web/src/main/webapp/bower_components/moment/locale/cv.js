// moment.js locale configuration
// locale : chuvash (cv)
// author : Anatoly Mironov : https://github.com/mirontoli

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('cv', {
        months : '泻膬褉谢邪褔_薪邪褉膬褋_锌褍褕_邪泻邪_屑邪泄_莽臅褉褌屑械_褍褌膬_莽褍褉谢邪_邪胁膬薪_褞锌邪_褔映泻_褉邪褕褌邪胁'.split('_'),
        monthsShort : '泻膬褉_薪邪褉_锌褍褕_邪泻邪_屑邪泄_莽臅褉_褍褌膬_莽褍褉_邪胁_褞锌邪_褔映泻_褉邪褕'.split('_'),
        weekdays : '胁褘褉褋邪褉薪懈泻褍薪_褌褍薪褌懈泻褍薪_褘褌谢邪褉懈泻褍薪_褞薪泻褍薪_泻臅莽薪械褉薪懈泻褍薪_褝褉薪械泻褍薪_褕膬屑邪褌泻褍薪'.split('_'),
        weekdaysShort : '胁褘褉_褌褍薪_褘褌谢_褞薪_泻臅莽_褝褉薪_褕膬屑'.split('_'),
        weekdaysMin : '胁褉_褌薪_褘褌_褞薪_泻莽_褝褉_褕屑'.split('_'),
        longDateFormat : {
            LT : 'HH:mm',
            LTS : 'LT:ss',
            L : 'DD-MM-YYYY',
            LL : 'YYYY [莽褍谢褏懈] MMMM [褍泄膬褏臅薪] D[-屑臅褕臅]',
            LLL : 'YYYY [莽褍谢褏懈] MMMM [褍泄膬褏臅薪] D[-屑臅褕臅], LT',
            LLLL : 'dddd, YYYY [莽褍谢褏懈] MMMM [褍泄膬褏臅薪] D[-屑臅褕臅], LT'
        },
        calendar : {
            sameDay: '[袩邪褟薪] LT [褋械褏械褌褉械]',
            nextDay: '[蝎褉邪薪] LT [褋械褏械褌褉械]',
            lastDay: '[臄薪械褉] LT [褋械褏械褌褉械]',
            nextWeek: '[脟懈褌械褋] dddd LT [褋械褏械褌褉械]',
            lastWeek: '[袠褉褌薪臅] dddd LT [褋械褏械褌褉械]',
            sameElse: 'L'
        },
        relativeTime : {
            future : function (output) {
                var affix = /褋械褏械褌$/i.exec(output) ? '褉械薪' : /莽褍谢$/i.exec(output) ? '褌邪薪' : '褉邪薪';
                return output + affix;
            },
            past : '%s 泻邪褟谢谢邪',
            s : '锌臅褉-懈泻 莽械泻泻褍薪褌',
            m : '锌臅褉 屑懈薪褍褌',
            mm : '%d 屑懈薪褍褌',
            h : '锌臅褉 褋械褏械褌',
            hh : '%d 褋械褏械褌',
            d : '锌臅褉 泻褍薪',
            dd : '%d 泻褍薪',
            M : '锌臅褉 褍泄膬褏',
            MM : '%d 褍泄膬褏',
            y : '锌臅褉 莽褍谢',
            yy : '%d 莽褍谢'
        },
        ordinalParse: /\d{1,2}-屑臅褕/,
        ordinal : '%d-屑臅褕',
        week : {
            dow : 1, // Monday is the first day of the week.
            doy : 7  // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
