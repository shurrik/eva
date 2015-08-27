// moment.js locale configuration
// locale : hindi (hi)
// author : Mayank Singhal : https://github.com/mayanksinghal

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

    return moment.defineLocale('hi', {
        months : '啶溹え啶掂ぐ啷€_啶ぜ啶班さ啶班_啶ぞ啶班啶歘啶呧お啷嵿ぐ啷堗げ_啶_啶溹啶╛啶溹啶侧ぞ啶坃啶呧啶膏啶啶膏た啶むぎ啷嵿が啶癣啶呧啷嵿啷傕が啶癣啶ㄠさ啶啶ぐ_啶︵た啶膏ぎ啷嵿が啶?.split('_'),
        monthsShort : '啶溹え._啶ぜ啶?_啶ぞ啶班啶歘啶呧お啷嵿ぐ啷?_啶_啶溹啶╛啶溹啶?_啶呧._啶膏た啶?_啶呧啷嵿啷?_啶ㄠさ._啶︵た啶?'.split('_'),
        weekdays : '啶班さ啶苦さ啶距ぐ_啶膏啶さ啶距ぐ_啶啶椸げ啶掂ぞ啶癣啶啶оさ啶距ぐ_啶椸啶班啶掂ぞ啶癣啶多啶曕啶班さ啶距ぐ_啶多え啶苦さ啶距ぐ'.split('_'),
        weekdaysShort : '啶班さ啶绦啶膏啶甠啶啶椸げ_啶啶啶椸啶班_啶多啶曕啶癣啶多え啶?.split('_'),
        weekdaysMin : '啶癣啶膏_啶_啶_啶椸_啶多_啶?.split('_'),
        longDateFormat : {
            LT : 'A h:mm 啶啷?,
            LTS : 'A h:mm:ss 啶啷?,
            L : 'DD/MM/YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY, LT',
            LLLL : 'dddd, D MMMM YYYY, LT'
        },
        calendar : {
            sameDay : '[啶嗋] LT',
            nextDay : '[啶曕げ] LT',
            nextWeek : 'dddd, LT',
            lastDay : '[啶曕げ] LT',
            lastWeek : '[啶た啶涏げ啷嘳 dddd, LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '%s 啶啶?,
            past : '%s 啶す啶侧',
            s : '啶曕啶?啶灌 啶曕啶粪ぃ',
            m : '啶忇 啶た啶ㄠ',
            mm : '%d 啶た啶ㄠ',
            h : '啶忇 啶樴啶熰ぞ',
            hh : '%d 啶樴啶熰',
            d : '啶忇 啶︵た啶?,
            dd : '%d 啶︵た啶?,
            M : '啶忇 啶す啷€啶ㄠ',
            MM : '%d 啶す啷€啶ㄠ',
            y : '啶忇 啶掂ぐ啷嵿し',
            yy : '%d 啶掂ぐ啷嵿し'
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
        // Hindi notation for meridiems are quite fuzzy in practice. While there exists
        // a rigid notion of a 'Pahar' it is not used as rigidly in modern Hindi.
        meridiem : function (hour, minute, isLower) {
            if (hour < 4) {
                return '啶班ぞ啶?;
            } else if (hour < 10) {
                return '啶膏啶す';
            } else if (hour < 17) {
                return '啶︵啶す啶?;
            } else if (hour < 20) {
                return '啶多ぞ啶?;
            } else {
                return '啶班ぞ啶?;
            }
        },
        week : {
            dow : 0, // Sunday is the first day of the week.
            doy : 6  // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
