// moment.js locale configuration
// locale : Marathi (mr)
// author : Harshad Kale : https://github.com/kalehv

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

    return moment.defineLocale('mr', {
        months : '啶溹ぞ啶ㄠ啶掂ぞ啶班_啶啶啶班啶掂ぞ啶班_啶ぞ啶班啶歘啶忇お啷嵿ぐ啶苦げ_啶_啶溹啶╛啶溹啶侧_啶钺啶膏啶焈啶膏お啷嵿啷囙啶ぐ_啶钺啷嵿啷嬥が啶癣啶ㄠ啶掂啶灌啶傕が啶癣啶∴た啶膏啶傕が啶?.split('_'),
        monthsShort: '啶溹ぞ啶ㄠ._啶啶啶班._啶ぞ啶班啶?_啶忇お啷嵿ぐ啶?_啶._啶溹啶?_啶溹啶侧._啶钺._啶膏お啷嵿啷囙._啶钺啷嵿啷?_啶ㄠ啶掂啶灌啶?_啶∴た啶膏啶?'.split('_'),
        weekdays : '啶班さ啶苦さ啶距ぐ_啶膏啶さ啶距ぐ_啶啶椸こ啶掂ぞ啶癣啶啶оさ啶距ぐ_啶椸啶班啶掂ぞ啶癣啶多啶曕啶班さ啶距ぐ_啶多え啶苦さ啶距ぐ'.split('_'),
        weekdaysShort : '啶班さ啶绦啶膏啶甠啶啶椸こ_啶啶啶椸啶班_啶多啶曕啶癣啶多え啶?.split('_'),
        weekdaysMin : '啶癣啶膏_啶_啶_啶椸_啶多_啶?.split('_'),
        longDateFormat : {
            LT : 'A h:mm 啶掂ぞ啶溹い啶?,
            LTS : 'A h:mm:ss 啶掂ぞ啶溹い啶?,
            L : 'DD/MM/YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY, LT',
            LLLL : 'dddd, D MMMM YYYY, LT'
        },
        calendar : {
            sameDay : '[啶嗋] LT',
            nextDay : '[啶夃う啷嵿く啶纶 LT',
            nextWeek : 'dddd, LT',
            lastDay : '[啶曕ぞ啶瞉 LT',
            lastWeek: '[啶ぞ啶椸啶瞉 dddd, LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '%s 啶ㄠ啶むぐ',
            past : '%s 啶啶班啶掂',
            s : '啶膏啶曕啶?,
            m: '啶忇 啶た啶ㄠた啶?,
            mm: '%d 啶た啶ㄠた啶熰',
            h : '啶忇 啶むぞ啶?,
            hh : '%d 啶むぞ啶?,
            d : '啶忇 啶︵た啶掂じ',
            dd : '%d 啶︵た啶掂じ',
            M : '啶忇 啶す啶苦え啶?,
            MM : '%d 啶す啶苦え啷?,
            y : '啶忇 啶掂ぐ啷嵿し',
            yy : '%d 啶掂ぐ啷嵿し啷?
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
        meridiem: function (hour, minute, isLower)
        {
            if (hour < 4) {
                return '啶班ぞ啶む啶班';
            } else if (hour < 10) {
                return '啶膏啶距こ啷€';
            } else if (hour < 17) {
                return '啶︵啶ぞ啶班';
            } else if (hour < 20) {
                return '啶膏ぞ啶啶曕ぞ啶赤';
            } else {
                return '啶班ぞ啶む啶班';
            }
        },
        week : {
            dow : 0, // Sunday is the first day of the week.
            doy : 6  // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
