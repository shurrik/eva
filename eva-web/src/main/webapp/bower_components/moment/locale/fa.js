// moment.js locale configuration
// locale : Persian (fa)
// author : Ebrahim Byagowi : https://github.com/ebraminio

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    var symbolMap = {
        '1': '郾',
        '2': '鄄',
        '3': '鄢',
        '4': '鄞',
        '5': '鄣',
        '6': '鄱',
        '7': '鄯',
        '8': '鄹',
        '9': '酃',
        '0': '郯'
    }, numberMap = {
        '郾': '1',
        '鄄': '2',
        '鄢': '3',
        '鄞': '4',
        '鄣': '5',
        '鄱': '6',
        '鄯': '7',
        '鄹': '8',
        '酃': '9',
        '郯': '0'
    };

    return moment.defineLocale('fa', {
        months : '跇丕賳賵蹖赖_賮賵乇蹖赖_賲丕乇爻_丌賵乇蹖賱_賲赖_跇賵卅賳_跇賵卅蹖赖_丕賵鬲_爻倬鬲丕賲亘乇_丕讴鬲亘乇_賳賵丕賲亘乇_丿爻丕賲亘乇'.split('_'),
        monthsShort : '跇丕賳賵蹖赖_賮賵乇蹖赖_賲丕乇爻_丌賵乇蹖賱_賲赖_跇賵卅賳_跇賵卅蹖赖_丕賵鬲_爻倬鬲丕賲亘乇_丕讴鬲亘乇_賳賵丕賲亘乇_丿爻丕賲亘乇'.split('_'),
        weekdays : '蹖讴\u200c卮賳亘赖_丿賵卮賳亘赖_爻赖\u200c卮賳亘赖_趩赖丕乇卮賳亘赖_倬賳噩\u200c卮賳亘赖_噩賲毓赖_卮賳亘赖'.split('_'),
        weekdaysShort : '蹖讴\u200c卮賳亘赖_丿賵卮賳亘赖_爻赖\u200c卮賳亘赖_趩赖丕乇卮賳亘赖_倬賳噩\u200c卮賳亘赖_噩賲毓赖_卮賳亘赖'.split('_'),
        weekdaysMin : '蹖_丿_爻_趩_倬_噩_卮'.split('_'),
        longDateFormat : {
            LT : 'HH:mm',
            LTS : 'LT:ss',
            L : 'DD/MM/YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY LT',
            LLLL : 'dddd, D MMMM YYYY LT'
        },
        meridiem : function (hour, minute, isLower) {
            if (hour < 12) {
                return '賯亘賱 丕夭 馗赖乇';
            } else {
                return '亘毓丿 丕夭 馗赖乇';
            }
        },
        calendar : {
            sameDay : '[丕賲乇賵夭 爻丕毓鬲] LT',
            nextDay : '[賮乇丿丕 爻丕毓鬲] LT',
            nextWeek : 'dddd [爻丕毓鬲] LT',
            lastDay : '[丿蹖乇賵夭 爻丕毓鬲] LT',
            lastWeek : 'dddd [倬蹖卮] [爻丕毓鬲] LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '丿乇 %s',
            past : '%s 倬蹖卮',
            s : '趩賳丿蹖賳 孬丕賳蹖赖',
            m : '蹖讴 丿賯蹖賯赖',
            mm : '%d 丿賯蹖賯赖',
            h : '蹖讴 爻丕毓鬲',
            hh : '%d 爻丕毓鬲',
            d : '蹖讴 乇賵夭',
            dd : '%d 乇賵夭',
            M : '蹖讴 賲丕赖',
            MM : '%d 賲丕赖',
            y : '蹖讴 爻丕賱',
            yy : '%d 爻丕賱'
        },
        preparse: function (string) {
            return string.replace(/[郯-酃]/g, function (match) {
                return numberMap[match];
            }).replace(/貙/g, ',');
        },
        postformat: function (string) {
            return string.replace(/\d/g, function (match) {
                return symbolMap[match];
            }).replace(/,/g, '貙');
        },
        ordinalParse: /\d{1,2}賲/,
        ordinal : '%d賲',
        week : {
            dow : 6, // Saturday is the first day of the week.
            doy : 12 // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
