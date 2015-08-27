// moment.js locale configuration
// locale : tamil (ta)
// author : Arjunkumar Krishnamoorthy : https://github.com/tk120404

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    /*var symbolMap = {
            '1': '喁?,
            '2': '喁?,
            '3': '喁?,
            '4': '喁?,
            '5': '喁?,
            '6': '喁?,
            '7': '喁?,
            '8': '喁?,
            '9': '喁?,
            '0': '喁?
        },
        numberMap = {
            '喁?: '1',
            '喁?: '2',
            '喁?: '3',
            '喁?: '4',
            '喁?: '5',
            '喁?: '6',
            '喁?: '7',
            '喁?: '8',
            '喁?: '9',
            '喁?: '0'
        }; */

    return moment.defineLocale('ta', {
        months : '喈溹喈掂喈绦喈喈瘝喈班喈班_喈喈班瘝喈氞瘝_喈忇喁嵿喈侧瘝_喈瘒_喈溹疯喈┼瘝_喈溹疯喈侧痪_喈嗋畷喈膏瘝喈熰瘝_喈氞瘑喈瘝喈熰瘑喈瘝喈喁峗喈呧畷喁嵿疅喁囙喈喁峗喈ㄠ喈瘝喈喁峗喈熰喈氞喁嵿喈班瘝'.split('_'),
        monthsShort : '喈溹喈掂喈绦喈喈瘝喈班喈班_喈喈班瘝喈氞瘝_喈忇喁嵿喈侧瘝_喈瘒_喈溹疯喈┼瘝_喈溹疯喈侧痪_喈嗋畷喈膏瘝喈熰瘝_喈氞瘑喈瘝喈熰瘑喈瘝喈喁峗喈呧畷喁嵿疅喁囙喈喁峗喈ㄠ喈瘝喈喁峗喈熰喈氞喁嵿喈班瘝'.split('_'),
        weekdays : '喈炧喈喈编瘝喈编瘉喈曕瘝喈曕喈脆喁坃喈む喈权瘝喈曕疅喁嵿畷喈苦喈痪_喈氞瘑喈掂瘝喈掂喈瘝喈曕喈脆喁坃喈瘉喈む喁嵿畷喈苦喈痪_喈掂喈喈脆畷喁嵿畷喈苦喈痪_喈掂瘑喈赤瘝喈赤喈曕瘝喈曕喈脆喁坃喈氞喈苦畷喁嵿畷喈苦喈痪'.split('_'),
        weekdaysShort : '喈炧喈喈编瘉_喈む喈权瘝喈曕喁峗喈氞瘑喈掂瘝喈掂喈瘝_喈瘉喈む喁峗喈掂喈喈脆喁峗喈掂瘑喈赤瘝喈赤_喈氞喈?.split('_'),
        weekdaysMin : '喈炧_喈む_喈氞瘑_喈瘉_喈掂_喈掂瘑_喈?.split('_'),
        longDateFormat : {
            LT : 'HH:mm',
            LTS : 'LT:ss',
            L : 'DD/MM/YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY, LT',
            LLLL : 'dddd, D MMMM YYYY, LT'
        },
        calendar : {
            sameDay : '[喈囙喁嵿喁乚 LT',
            nextDay : '[喈ㄠ喈赤痪] LT',
            nextWeek : 'dddd, LT',
            lastDay : '[喈ㄠ瘒喈编瘝喈编瘉] LT',
            lastWeek : '[喈曕疅喈ㄠ瘝喈?喈掂喈班喁峕 dddd, LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '%s 喈囙喁?,
            past : '%s 喈瘉喈┼瘝',
            s : '喈抡喁?喈氞喈?喈掂喈ㄠ喈熰喈曕喁?,
            m : '喈抡喁?喈ㄠ喈喈熰喁?,
            mm : '%d 喈ㄠ喈喈熰畽喁嵿畷喈赤瘝',
            h : '喈抡喁?喈喈?喈ㄠ瘒喈班喁?,
            hh : '%d 喈喈?喈ㄠ瘒喈班喁?,
            d : '喈抡喁?喈ㄠ喈赤瘝',
            dd : '%d 喈ㄠ喈熰瘝喈曕喁?,
            M : '喈抡喁?喈喈む喁?,
            MM : '%d 喈喈む畽喁嵿畷喈赤瘝',
            y : '喈抡喁?喈掂喁佮疅喈瘝',
            yy : '%d 喈嗋喁嵿疅喁佮畷喈赤瘝'
        },
/*        preparse: function (string) {
            return string.replace(/[喁о喁┼喁喁喁]/g, function (match) {
                return numberMap[match];
            });
        },
        postformat: function (string) {
            return string.replace(/\d/g, function (match) {
                return symbolMap[match];
            });
        },*/
        ordinalParse: /\d{1,2}喈掂喁?,
        ordinal : function (number) {
            return number + '喈掂喁?;
        },


        // refer http://ta.wikipedia.org/s/1er1

        meridiem : function (hour, minute, isLower) {
            if (hour >= 6 && hour <= 10) {
                return ' 喈曕喈侧痪';
            } else if (hour >= 10 && hour <= 14) {
                return ' 喈ㄠ喁嵿喈曕喁?;
            } else if (hour >= 14 && hour <= 18) {
                return ' 喈庎喁嵿喈距疅喁?;
            } else if (hour >= 18 && hour <= 20) {
                return ' 喈喈侧痪';
            } else if (hour >= 20 && hour <= 24) {
                return ' 喈囙喈掂瘉';
            } else if (hour >= 0 && hour <= 6) {
                return ' 喈掂痪喈曕喁?;
            }
        },
        week : {
            dow : 0, // Sunday is the first day of the week.
            doy : 6  // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
