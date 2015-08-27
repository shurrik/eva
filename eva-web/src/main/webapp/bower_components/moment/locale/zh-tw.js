// moment.js locale configuration
// locale : traditional chinese (zh-tw)
// author : Ben : https://github.com/ben-lin

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('zh-tw', {
        months : '涓€链坃浜屾湀_涓夋湀_锲涙湀_浜旀湀_鍏湀_涓冩湀_鍏湀_涔濇湀_鍗佹湀_鍗佷竴链坃鍗佷簩链?.split('_'),
        monthsShort : '1链坃2链坃3链坃4链坃5链坃6链坃7链坃8链坃9链坃10链坃11链坃12链?.split('_'),
        weekdays : '鏄熸湡镞鏄熸湡涓€_鏄熸湡浜宊鏄熸湡涓埙鏄熸湡锲冲鏄熸湡浜扰鏄熸湡鍏?.split('_'),
        weekdaysShort : '阃辨棩_阃变竴_阃变簩_阃变笁_阃卞洓_阃变簲_阃卞叚'.split('_'),
        weekdaysMin : '镞涓€_浜宊涓埙锲冲浜扰鍏?.split('_'),
        longDateFormat : {
            LT : 'Ah榛瀖m',
            LTS : 'Ah榛瀖鍒唖绉?,
            L : 'YYYY骞碝MMD镞?,
            LL : 'YYYY骞碝MMD镞?,
            LLL : 'YYYY骞碝MMD镞T',
            LLLL : 'YYYY骞碝MMD镞dddLT',
            l : 'YYYY骞碝MMD镞?,
            ll : 'YYYY骞碝MMD镞?,
            lll : 'YYYY骞碝MMD镞T',
            llll : 'YYYY骞碝MMD镞dddLT'
        },
        meridiem : function (hour, minute, isLower) {
            var hm = hour * 100 + minute;
            if (hm < 900) {
                return '镞╀笂';
            } else if (hm < 1130) {
                return '涓婂崃';
            } else if (hm < 1230) {
                return '涓崃';
            } else if (hm < 1800) {
                return '涓嫔崃';
            } else {
                return '鏅氢笂';
            }
        },
        calendar : {
            sameDay : '[浠婂ぉ]LT',
            nextDay : '[鏄庡ぉ]LT',
            nextWeek : '[涓媇ddddLT',
            lastDay : '[鏄ㄥぉ]LT',
            lastWeek : '[涓奭ddddLT',
            sameElse : 'L'
        },
        ordinalParse: /\d{1,2}(镞链坾阃?/,
        ordinal : function (number, period) {
            switch (period) {
            case 'd' :
            case 'D' :
            case 'DDD' :
                return number + '镞?;
            case 'M' :
                return number + '链?;
            case 'w' :
            case 'W' :
                return number + '阃?;
            default :
                return number;
            }
        },
        relativeTime : {
            future : '%s鍏?,
            past : '%s鍓?,
            s : '骞剧',
            m : '涓€鍒嗛悩',
            mm : '%d鍒嗛悩',
            h : '涓€灏忔檪',
            hh : '%d灏忔檪',
            d : '涓€澶?,
            dd : '%d澶?,
            M : '涓€链嬫湀',
            MM : '%d链嬫湀',
            y : '涓€骞?,
            yy : '%d骞?
        }
    });
}));
