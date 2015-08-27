// moment.js locale configuration
// locale : Bengali (bn)
// author : Kaushik Gandhi : https://github.com/kaushikgandhi

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
        '1': '唰?,
        '2': '唰?,
        '3': '唰?,
        '4': '唰?,
        '5': '唰?,
        '6': '唰?,
        '7': '唰?,
        '8': '唰?,
        '9': '唰?,
        '0': '唰?
    },
    numberMap = {
        '唰?: '1',
        '唰?: '2',
        '唰?: '3',
        '唰?: '4',
        '唰?: '5',
        '唰?: '6',
        '唰?: '7',
        '唰?: '8',
        '唰?: '9',
        '唰?: '0'
    };

    return moment.defineLocale('bn', {
        months : '唳溹唳ㄠ唰熰唳班_唳唳唰熰唳班_唳唳班唳歘唳忇Κ唰嵿Π唳苦Σ_唳_唳溹唳╛唳溹唳侧唳嘷唳呧唳距Ω唰嵿_唳膏唳唳熰唳唳Π_唳呧唰嵿唰嬥Μ唳癣唳ㄠΝ唰囙Ξ唰嵿Μ唳癣唳∴唳膏唳唳Π'.split('_'),
        monthsShort : '唳溹唳ㄠ_唳唳琠唳唳班唳歘唳忇Κ唳癣唳_唳溹唳╛唳溹唳瞋唳呧_唳膏唳唳焈唳呧唰嵿唰媉唳ㄠΝ_唳∴唳膏唳'.split('_'),
        weekdays : '唳班Μ唳苦Μ唳距Π_唳膏唳Μ唳距Π_唳唰嵿唳侧Μ唳距Π_唳唳оΜ唳距Π_唳唳灌Ω唰嵿Κ唳む唳む唳唳癣唳多唳曕唳班唳唳癣唳多Θ唳苦Μ唳距Π'.split('_'),
        weekdaysShort : '唳班Μ唳绦唳膏唳甠唳唰嵿唳瞋唳唳唳唳灌Ω唰嵿Κ唳む唳む_唳多唳曕唳班_唳多Θ唳?.split('_'),
        weekdaysMin : '唳班Μ_唳膏Ξ_唳唰嵿_唳_唳唳班唳筥唳多_唳多Θ唳?.split('_'),
        longDateFormat : {
            LT : 'A h:mm 唳膏Ξ唰?,
            LTS : 'A h:mm:ss 唳膏Ξ唰?,
            L : 'DD/MM/YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY, LT',
            LLLL : 'dddd, D MMMM YYYY, LT'
        },
        calendar : {
            sameDay : '[唳嗋] LT',
            nextDay : '[唳嗋唳距Ξ唰€唳曕唳瞉 LT',
            nextWeek : 'dddd, LT',
            lastDay : '[唳椸Δ唳曕唳瞉 LT',
            lastWeek : '[唳椸Δ] dddd, LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '%s 唳Π唰?,
            past : '%s 唳嗋唰?,
            s : '唳曕唳?唳膏唳曕唳ㄠ唳?,
            m : '唳忇 唳唳ㄠ唳?,
            mm : '%d 唳唳ㄠ唳?,
            h : '唳忇 唳樴Θ唰嵿唳?,
            hh : '%d 唳樴Θ唰嵿唳?,
            d : '唳忇 唳︵唳?,
            dd : '%d 唳︵唳?,
            M : '唳忇 唳唳?,
            MM : '%d 唳唳?,
            y : '唳忇 唳唳?,
            yy : '%d 唳唳?
        },
        preparse: function (string) {
            return string.replace(/[唰оЖ唰┼И唰К唰М唰Е]/g, function (match) {
                return numberMap[match];
            });
        },
        postformat: function (string) {
            return string.replace(/\d/g, function (match) {
                return symbolMap[match];
            });
        },
        //Bengali is a vast language its spoken
        //in different forms in various parts of the world.
        //I have just generalized with most common one used
        meridiem : function (hour, minute, isLower) {
            if (hour < 4) {
                return '唳班唳?;
            } else if (hour < 10) {
                return '唳多唳距Σ';
            } else if (hour < 17) {
                return '唳︵唳唳?;
            } else if (hour < 20) {
                return '唳唳曕唳?;
            } else {
                return '唳班唳?;
            }
        },
        week : {
            dow : 0, // Sunday is the first day of the week.
            doy : 6  // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
