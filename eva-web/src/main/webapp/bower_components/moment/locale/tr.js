// moment.js locale configuration
// locale : turkish (tr)
// authors : Erhan Gundogan : https://github.com/erhangundogan,
//           Burak Yi臒it Kaya: https://github.com/BYK

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    var suffixes = {
        1: '\'inci',
        5: '\'inci',
        8: '\'inci',
        70: '\'inci',
        80: '\'inci',

        2: '\'nci',
        7: '\'nci',
        20: '\'nci',
        50: '\'nci',

        3: '\'眉nc眉',
        4: '\'眉nc眉',
        100: '\'眉nc眉',

        6: '\'nc谋',

        9: '\'uncu',
        10: '\'uncu',
        30: '\'uncu',

        60: '\'谋nc谋',
        90: '\'谋nc谋'
    };

    return moment.defineLocale('tr', {
        months : 'Ocak_舰ubat_Mart_Nisan_May谋s_Haziran_Temmuz_A臒ustos_Eyl眉l_Ekim_Kas谋m_Aral谋k'.split('_'),
        monthsShort : 'Oca_舰ub_Mar_Nis_May_Haz_Tem_A臒u_Eyl_Eki_Kas_Ara'.split('_'),
        weekdays : 'Pazar_Pazartesi_Sal谋_脟ar艧amba_Per艧embe_Cuma_Cumartesi'.split('_'),
        weekdaysShort : 'Paz_Pts_Sal_脟ar_Per_Cum_Cts'.split('_'),
        weekdaysMin : 'Pz_Pt_Sa_脟a_Pe_Cu_Ct'.split('_'),
        longDateFormat : {
            LT : 'HH:mm',
            LTS : 'LT:ss',
            L : 'DD.MM.YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY LT',
            LLLL : 'dddd, D MMMM YYYY LT'
        },
        calendar : {
            sameDay : '[bug眉n saat] LT',
            nextDay : '[yar谋n saat] LT',
            nextWeek : '[haftaya] dddd [saat] LT',
            lastDay : '[d眉n] LT',
            lastWeek : '[ge莽en hafta] dddd [saat] LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '%s sonra',
            past : '%s 枚nce',
            s : 'birka莽 saniye',
            m : 'bir dakika',
            mm : '%d dakika',
            h : 'bir saat',
            hh : '%d saat',
            d : 'bir g眉n',
            dd : '%d g眉n',
            M : 'bir ay',
            MM : '%d ay',
            y : 'bir y谋l',
            yy : '%d y谋l'
        },
        ordinalParse: /\d{1,2}'(inci|nci|眉nc眉|nc谋|uncu|谋nc谋)/,
        ordinal : function (number) {
            if (number === 0) {  // special case for zero
                return number + '\'谋nc谋';
            }
            var a = number % 10,
                b = number % 100 - a,
                c = number >= 100 ? 100 : null;

            return number + (suffixes[a] || suffixes[b] || suffixes[c]);
        },
        week : {
            dow : 1, // Monday is the first day of the week.
            doy : 7  // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
