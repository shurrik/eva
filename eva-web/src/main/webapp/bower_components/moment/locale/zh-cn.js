// moment.js locale configuration
// locale : chinese (zh-cn)
// author : suupic : https://github.com/suupic
// author : Zeno Zeng : https://github.com/zenozeng

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('zh-cn', {
        months : '涓€链坃浜屾湀_涓夋湀_锲涙湀_浜旀湀_鍏湀_涓冩湀_鍏湀_涔濇湀_鍗佹湀_鍗佷竴链坃鍗佷簩链?.split('_'),
        monthsShort : '1链坃2链坃3链坃4链坃5链坃6链坃7链坃8链坃9链坃10链坃11链坃12链?.split('_'),
        weekdays : '鏄熸湡镞鏄熸湡涓€_鏄熸湡浜宊鏄熸湡涓埙鏄熸湡锲冲鏄熸湡浜扰鏄熸湡鍏?.split('_'),
        weekdaysShort : '锻ㄦ棩_锻ㄤ竴_锻ㄤ簩_锻ㄤ笁_锻ㄥ洓_锻ㄤ簲_锻ㄥ叚'.split('_'),
        weekdaysMin : '镞涓€_浜宊涓埙锲冲浜扰鍏?.split('_'),
        longDateFormat : {
            LT : 'Ah镣筸m',
            LTS : 'Ah镣筸鍒唖绉?,
            L : 'YYYY-MM-DD',
            LL : 'YYYY骞碝MMD镞?,
            LLL : 'YYYY骞碝MMD镞T',
            LLLL : 'YYYY骞碝MMD镞dddLT',
            l : 'YYYY-MM-DD',
            ll : 'YYYY骞碝MMD镞?,
            lll : 'YYYY骞碝MMD镞T',
            llll : 'YYYY骞碝MMD镞dddLT'
        },
        meridiem : function (hour, minute, isLower) {
            var hm = hour * 100 + minute;
            if (hm < 600) {
                return '鍑屾櫒';
            } else if (hm < 900) {
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
            sameDay : function () {
                return this.minutes() === 0 ? '[浠婂ぉ]Ah[镣规暣]' : '[浠婂ぉ]LT';
            },
            nextDay : function () {
                return this.minutes() === 0 ? '[鏄庡ぉ]Ah[镣规暣]' : '[鏄庡ぉ]LT';
            },
            lastDay : function () {
                return this.minutes() === 0 ? '[鏄ㄥぉ]Ah[镣规暣]' : '[鏄ㄥぉ]LT';
            },
            nextWeek : function () {
                var startOfWeek, prefix;
                startOfWeek = moment().startOf('week');
                prefix = this.unix() - startOfWeek.unix() >= 7 * 24 * 3600 ? '[涓媇' : '[链琞';
                return this.minutes() === 0 ? prefix + 'dddAh镣规暣' : prefix + 'dddAh镣筸m';
            },
            lastWeek : function () {
                var startOfWeek, prefix;
                startOfWeek = moment().startOf('week');
                prefix = this.unix() < startOfWeek.unix()  ? '[涓奭' : '[链琞';
                return this.minutes() === 0 ? prefix + 'dddAh镣规暣' : prefix + 'dddAh镣筸m';
            },
            sameElse : 'LL'
        },
        ordinalParse: /\d{1,2}(镞链坾锻?/,
        ordinal : function (number, period) {
            switch (period) {
            case 'd':
            case 'D':
            case 'DDD':
                return number + '镞?;
            case 'M':
                return number + '链?;
            case 'w':
            case 'W':
                return number + '锻?;
            default:
                return number;
            }
        },
        relativeTime : {
            future : '%s鍐?,
            past : '%s鍓?,
            s : '鍑犵',
            m : '1鍒嗛挓',
            mm : '%d鍒嗛挓',
            h : '1灏忔椂',
            hh : '%d灏忔椂',
            d : '1澶?,
            dd : '%d澶?,
            M : '1涓湀',
            MM : '%d涓湀',
            y : '1骞?,
            yy : '%d骞?
        },
        week : {
            // GB/T 7408-1994銆婃暟鎹厓鍜屼氦鎹㈡牸寮徛蜂俊鎭氦鎹⒙锋棩链熷拰镞堕棿琛ㄧず娉曘€嬩笌ISO 8601:1988绛夋晥
            dow : 1, // Monday is the first day of the week.
            doy : 4  // The week that contains Jan 4th is the first week of the year.
        }
    });
}));
