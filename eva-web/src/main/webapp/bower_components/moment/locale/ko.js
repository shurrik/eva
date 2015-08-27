// moment.js locale configuration
// locale : korean (ko)
//
// authors
//
// - Kyungwook, Park : https://github.com/kyungw00k
// - Jeeeyul Lee <jeeeyul@gmail.com>
(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('ko', {
        months : '1鞗扰2鞗扰3鞗扰4鞗扰5鞗扰6鞗扰7鞗扰8鞗扰9鞗扰10鞗扰11鞗扰12鞗?.split('_'),
        monthsShort : '1鞗扰2鞗扰3鞗扰4鞗扰5鞗扰6鞗扰7鞗扰8鞗扰9鞗扰10鞗扰11鞗扰12鞗?.split('_'),
        weekdays : '鞚检殧鞚糭鞗旍殧鞚糭顸旍殧鞚糭靾橃殧鞚糭氇╈殧鞚糭旮堨殧鞚糭韱犾殧鞚?.split('_'),
        weekdaysShort : '鞚糭鞗扰顸扰靾榑氇旮坃韱?.split('_'),
        weekdaysMin : '鞚糭鞗扰顸扰靾榑氇旮坃韱?.split('_'),
        longDateFormat : {
            LT : 'A h鞁?m攵?,
            LTS : 'A h鞁?m攵?s齑?,
            L : 'YYYY.MM.DD',
            LL : 'YYYY云?MMMM D鞚?,
            LLL : 'YYYY云?MMMM D鞚?LT',
            LLLL : 'YYYY云?MMMM D鞚?dddd LT'
        },
        meridiem : function (hour, minute, isUpper) {
            return hour < 12 ? '鞓れ爠' : '鞓ろ泟';
        },
        calendar : {
            sameDay : '鞓る姌 LT',
            nextDay : '雮挫澕 LT',
            nextWeek : 'dddd LT',
            lastDay : '巩挫牅 LT',
            lastWeek : '歆€雮涤＜ dddd LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '%s 頉?,
            past : '%s 鞝?,
            s : '氇囲磮',
            ss : '%d齑?,
            m : '鞚茧秳',
            mm : '%d攵?,
            h : '顷涤嫓臧?,
            hh : '%d鞁滉皠',
            d : '顷橂（',
            dd : '%d鞚?,
            M : '顷滊嫭',
            MM : '%d雼?,
            y : '鞚茧厔',
            yy : '%d云?
        },
        ordinalParse : /\d{1,2}鞚?,
        ordinal : '%d鞚?,
        meridiemParse : /(鞓れ爠|鞓ろ泟)/,
        isPM : function (token) {
            return token === '鞓ろ泟';
        }
    });
}));
