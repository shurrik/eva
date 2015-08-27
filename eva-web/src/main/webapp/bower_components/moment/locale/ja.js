// moment.js locale configuration
// locale : japanese (ja)
// author : LI Long : https://github.com/baryon

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('ja', {
        months : '1链坃2链坃3链坃4链坃5链坃6链坃7链坃8链坃9链坃10链坃11链坃12链?.split('_'),
        monthsShort : '1链坃2链坃3链坃4链坃5链坃6链坃7链坃8链坃9链坃10链坃11链坃12链?.split('_'),
        weekdays : '镞ユ洔镞链堟洔镞鐏洔镞姘存洔镞链ㄦ洔镞閲戞洔镞鍦熸洔镞?.split('_'),
        weekdaysShort : '镞链坃鐏玙姘确链╛閲慱鍦?.split('_'),
        weekdaysMin : '镞链坃鐏玙姘确链╛閲慱鍦?.split('_'),
        longDateFormat : {
            LT : 'Ah鏅俶鍒?,
            LTS : 'LTs绉?,
            L : 'YYYY/MM/DD',
            LL : 'YYYY骞碝链图镞?,
            LLL : 'YYYY骞碝链图镞T',
            LLLL : 'YYYY骞碝链图镞T dddd'
        },
        meridiem : function (hour, minute, isLower) {
            if (hour < 12) {
                return '鍗埚墠';
            } else {
                return '鍗埚缌';
            }
        },
        calendar : {
            sameDay : '[浠婃棩] LT',
            nextDay : '[鏄庢棩] LT',
            nextWeek : '[鏉ラ€盷dddd LT',
            lastDay : '[鏄ㄦ棩] LT',
            lastWeek : '[鍓嶉€盷dddd LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '%s寰?,
            past : '%s鍓?,
            s : '鏁扮',
            m : '1鍒?,
            mm : '%d鍒?,
            h : '1鏅傞枔',
            hh : '%d鏅傞枔',
            d : '1镞?,
            dd : '%d镞?,
            M : '1銉舵湀',
            MM : '%d銉舵湀',
            y : '1骞?,
            yy : '%d骞?
        }
    });
}));
