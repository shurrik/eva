﻿// moment.js locale configuration
// locale : Moroccan Arabic (ar-ma)
// author : ElFadili Yassine : https://github.com/ElFadiliY
// author : Abdel Said : https://github.com/abdelsaid

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('ar-ma', {
        months : '賷賳丕賷乇_賮亘乇丕賷乇_賲丕乇爻_兀亘乇賷賱_賲丕賷_賷賵賳賷賵_賷賵賱賷賵夭_睾卮鬲_卮鬲賳亘乇_兀賰鬲賵亘乇_賳賵賳亘乇_丿噩賳亘乇'.split('_'),
        monthsShort : '賷賳丕賷乇_賮亘乇丕賷乇_賲丕乇爻_兀亘乇賷賱_賲丕賷_賷賵賳賷賵_賷賵賱賷賵夭_睾卮鬲_卮鬲賳亘乇_兀賰鬲賵亘乇_賳賵賳亘乇_丿噩賳亘乇'.split('_'),
        weekdays : '丕賱兀丨丿_丕賱廿鬲賳賷賳_丕賱孬賱丕孬丕亍_丕賱兀乇亘毓丕亍_丕賱禺賲賷爻_丕賱噩賲毓丞_丕賱爻亘鬲'.split('_'),
        weekdaysShort : '丕丨丿_丕鬲賳賷賳_孬賱丕孬丕亍_丕乇亘毓丕亍_禺賲賷爻_噩賲毓丞_爻亘鬲'.split('_'),
        weekdaysMin : '丨_賳_孬_乇_禺_噩_爻'.split('_'),
        longDateFormat : {
            LT : 'HH:mm',
            LTS : 'LT:ss',
            L : 'DD/MM/YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY LT',
            LLLL : 'dddd D MMMM YYYY LT'
        },
        calendar : {
            sameDay: '[丕賱賷賵賲 毓賱賶 丕賱爻丕毓丞] LT',
            nextDay: '[睾丿丕 毓賱賶 丕賱爻丕毓丞] LT',
            nextWeek: 'dddd [毓賱賶 丕賱爻丕毓丞] LT',
            lastDay: '[兀賲爻 毓賱賶 丕賱爻丕毓丞] LT',
            lastWeek: 'dddd [毓賱賶 丕賱爻丕毓丞] LT',
            sameElse: 'L'
        },
        relativeTime : {
            future : '賮賷 %s',
            past : '賲賳匕 %s',
            s : '孬賵丕賳',
            m : '丿賯賷賯丞',
            mm : '%d 丿賯丕卅賯',
            h : '爻丕毓丞',
            hh : '%d 爻丕毓丕鬲',
            d : '賷賵賲',
            dd : '%d 兀賷丕賲',
            M : '卮赖乇',
            MM : '%d 兀卮赖乇',
            y : '爻賳丞',
            yy : '%d 爻賳賵丕鬲'
        },
        week : {
            dow : 6, // Saturday is the first day of the week.
            doy : 12  // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
