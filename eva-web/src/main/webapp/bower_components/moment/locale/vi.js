// moment.js locale configuration
// locale : vietnamese (vi)
// author : Bang Nguyen : https://github.com/bangnk

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('vi', {
        months : 'th谩ng 1_th谩ng 2_th谩ng 3_th谩ng 4_th谩ng 5_th谩ng 6_th谩ng 7_th谩ng 8_th谩ng 9_th谩ng 10_th谩ng 11_th谩ng 12'.split('_'),
        monthsShort : 'Th01_Th02_Th03_Th04_Th05_Th06_Th07_Th08_Th09_Th10_Th11_Th12'.split('_'),
        weekdays : 'ch峄?nh岷玺_th峄?hai_th峄?ba_th峄?t瓢_th峄?n膬m_th峄?s谩u_th峄?b岷'.split('_'),
        weekdaysShort : 'CN_T2_T3_T4_T5_T6_T7'.split('_'),
        weekdaysMin : 'CN_T2_T3_T4_T5_T6_T7'.split('_'),
        longDateFormat : {
            LT : 'HH:mm',
            LTS : 'LT:ss',
            L : 'DD/MM/YYYY',
            LL : 'D MMMM [n膬m] YYYY',
            LLL : 'D MMMM [n膬m] YYYY LT',
            LLLL : 'dddd, D MMMM [n膬m] YYYY LT',
            l : 'DD/M/YYYY',
            ll : 'D MMM YYYY',
            lll : 'D MMM YYYY LT',
            llll : 'ddd, D MMM YYYY LT'
        },
        calendar : {
            sameDay: '[H么m nay l煤c] LT',
            nextDay: '[Ng脿y mai l煤c] LT',
            nextWeek: 'dddd [tu岷 t峄沬 l煤c] LT',
            lastDay: '[H么m qua l煤c] LT',
            lastWeek: 'dddd [tu岷 r峄搃 l煤c] LT',
            sameElse: 'L'
        },
        relativeTime : {
            future : '%s t峄沬',
            past : '%s tr瓢峄沜',
            s : 'v脿i gi芒y',
            m : 'm峄檛 ph煤t',
            mm : '%d ph煤t',
            h : 'm峄檛 gi峄?,
            hh : '%d gi峄?,
            d : 'm峄檛 ng脿y',
            dd : '%d ng脿y',
            M : 'm峄檛 th谩ng',
            MM : '%d th谩ng',
            y : 'm峄檛 n膬m',
            yy : '%d n膬m'
        },
        ordinalParse: /\d{1,2}/,
        ordinal : function (number) {
            return number;
        },
        week : {
            dow : 1, // Monday is the first day of the week.
            doy : 4  // The week that contains Jan 4th is the first week of the year.
        }
    });
}));
