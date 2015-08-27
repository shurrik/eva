// moment.js locale configuration
// locale : nepali/nepalese
// author : suvash : https://github.com/suvash

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
        '1': '啷?,
        '2': '啷?,
        '3': '啷?,
        '4': '啷?,
        '5': '啷?,
        '6': '啷?,
        '7': '啷?,
        '8': '啷?,
        '9': '啷?,
        '0': '啷?
    },
    numberMap = {
        '啷?: '1',
        '啷?: '2',
        '啷?: '3',
        '啷?: '4',
        '啷?: '5',
        '啷?: '6',
        '啷?: '7',
        '啷?: '8',
        '啷?: '9',
        '啷?: '0'
    };

    return moment.defineLocale('ne', {
        months : '啶溹え啶掂ぐ啷€_啶啶啶班啶掂ぐ啷€_啶ぞ啶班啶歘啶呧お啷嵿ぐ啶苦げ_啶_啶溹啶╛啶溹啶侧ぞ啶坃啶呧啶粪啶焈啶膏啶啶熰啶啶ぐ_啶呧啷嵿啷嬥が啶癣啶ㄠ啶啶啶ぐ_啶∴た啶膏啶啶ぐ'.split('_'),
        monthsShort : '啶溹え._啶啶啶班._啶ぞ啶班啶歘啶呧お啷嵿ぐ啶?_啶_啶溹啶╛啶溹啶侧ぞ啶?_啶呧._啶膏啶啶?_啶呧啷嵿啷?_啶ㄠ啶._啶∴た啶膏.'.split('_'),
        weekdays : '啶嗋啶むが啶距ぐ_啶膏啶が啶距ぐ_啶啷嵿啶侧が啶距ぐ_啶啶оが啶距ぐ_啶た啶灌た啶ぞ啶癣啶多啶曕啶班が啶距ぐ_啶多え啶苦が啶距ぐ'.split('_'),
        weekdaysShort : '啶嗋啶?_啶膏啶?_啶啷嵿啶?_啶啶?_啶た啶灌た._啶多啶曕啶?_啶多え啶?'.split('_'),
        weekdaysMin : '啶嗋._啶膏._啶啷峗啶._啶た._啶多._啶?'.split('_'),
        longDateFormat : {
            LT : 'A啶曕 h:mm 啶啷?,
            LTS : 'A啶曕 h:mm:ss 啶啷?,
            L : 'DD/MM/YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY, LT',
            LLLL : 'dddd, D MMMM YYYY, LT'
        },
        preparse: function (string) {
            return string.replace(/[啷оエ啷┼オ啷ガ啷ギ啷ウ]/g, function (match) {
                return numberMap[match];
            });
        },
        postformat: function (string) {
            return string.replace(/\d/g, function (match) {
                return symbolMap[match];
            });
        },
        meridiem : function (hour, minute, isLower) {
            if (hour < 3) {
                return '啶班ぞ啶む';
            } else if (hour < 10) {
                return '啶た啶灌ぞ啶?;
            } else if (hour < 15) {
                return '啶︵た啶夃啶膏';
            } else if (hour < 18) {
                return '啶啶侧啶曕ぞ';
            } else if (hour < 20) {
                return '啶膏ぞ啶佮';
            } else {
                return '啶班ぞ啶む';
            }
        },
        calendar : {
            sameDay : '[啶嗋] LT',
            nextDay : '[啶啶侧] LT',
            nextWeek : '[啶嗋啶佮う啷媇 dddd[,] LT',
            lastDay : '[啶灌た啶溹] LT',
            lastWeek : '[啶椸啶曕] dddd[,] LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '%s啶ぞ',
            past : '%s 啶呧啶距ぁ啷€',
            s : '啶曕啶灌 啶膏ぎ啶?,
            m : '啶忇 啶た啶ㄠ啶?,
            mm : '%d 啶た啶ㄠ啶?,
            h : '啶忇 啶樴ぃ啷嵿啶?,
            hh : '%d 啶樴ぃ啷嵿啶?,
            d : '啶忇 啶︵た啶?,
            dd : '%d 啶︵た啶?,
            M : '啶忇 啶す啶苦え啶?,
            MM : '%d 啶す啶苦え啶?,
            y : '啶忇 啶ぐ啷嵿し',
            yy : '%d 啶ぐ啷嵿し'
        },
        week : {
            dow : 1, // Monday is the first day of the week.
            doy : 7  // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
