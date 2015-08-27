﻿// moment.js locale configuration
// locale : modern greek (el)
// author : Aggelos Karalias : https://github.com/mehiel

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('el', {
        monthsNominativeEl : '螜伪谓慰蠀维蚁喂慰蟼_桅蔚尾蚁慰蠀维蚁喂慰蟼_螠维蚁蟿喂慰蟼_螒蟺蚁委位喂慰蟼_螠维喂慰蟼_螜慰蠉谓喂慰蟼_螜慰蠉位喂慰蟼_螒蠉纬慰蠀蟽蟿慰蟼_危蔚蟺蟿苇渭尾蚁喂慰蟼_螣魏蟿蠋尾蚁喂慰蟼_螡慰苇渭尾蚁喂慰蟼_螖蔚魏苇渭尾蚁喂慰蟼'.split('_'),
        monthsGenitiveEl : '螜伪谓慰蠀伪蚁委慰蠀_桅蔚尾蚁慰蠀伪蚁委慰蠀_螠伪蚁蟿委慰蠀_螒蟺蚁喂位委慰蠀_螠伪螑慰蠀_螜慰蠀谓委慰蠀_螜慰蠀位委慰蠀_螒蠀纬慰蠉蟽蟿慰蠀_危蔚蟺蟿蔚渭尾蚁委慰蠀_螣魏蟿蝇尾蚁委慰蠀_螡慰蔚渭尾蚁委慰蠀_螖蔚魏蔚渭尾蚁委慰蠀'.split('_'),
        months : function (momentToFormat, format) {
            if (/D/.test(format.substring(0, format.indexOf('MMMM')))) { // if there is a day number before 'MMMM'
                return this._monthsGenitiveEl[momentToFormat.month()];
            } else {
                return this._monthsNominativeEl[momentToFormat.month()];
            }
        },
        monthsShort : '螜伪谓_桅蔚尾_螠伪蚁_螒蟺蚁_螠伪虿_螜慰蠀谓_螜慰蠀位_螒蠀纬_危蔚蟺_螣魏蟿_螡慰蔚_螖蔚魏'.split('_'),
        weekdays : '螝蠀蚁喂伪魏萎_螖蔚蠀蟿苇蚁伪_韦蚁委蟿畏_韦蔚蟿维蚁蟿畏_螤苇渭蟺蟿畏_螤伪蚁伪蟽魏蔚蠀萎_危维尾尾伪蟿慰'.split('_'),
        weekdaysShort : '螝蠀蚁_螖蔚蠀_韦蚁喂_韦蔚蟿_螤蔚渭_螤伪蚁_危伪尾'.split('_'),
        weekdaysMin : '螝蠀_螖蔚_韦蚁_韦蔚_螤蔚_螤伪_危伪'.split('_'),
        meridiem : function (hours, minutes, isLower) {
            if (hours > 11) {
                return isLower ? '渭渭' : '螠螠';
            } else {
                return isLower ? '蟺渭' : '螤螠';
            }
        },
        isPM : function (input) {
            return ((input + '').toLowerCase()[0] === '渭');
        },
        meridiemParse : /[螤螠]\.?螠?\.?/i,
        longDateFormat : {
            LT : 'h:mm A',
            LTS : 'h:mm:ss A',
            L : 'DD/MM/YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY LT',
            LLLL : 'dddd, D MMMM YYYY LT'
        },
        calendarEl : {
            sameDay : '[危萎渭蔚蚁伪 {}] LT',
            nextDay : '[螒蠉蚁喂慰 {}] LT',
            nextWeek : 'dddd [{}] LT',
            lastDay : '[围胃蔚蟼 {}] LT',
            lastWeek : function () {
                switch (this.day()) {
                    case 6:
                        return '[蟿慰 蟺蚁慰畏纬慰蠉渭蔚谓慰] dddd [{}] LT';
                    default:
                        return '[蟿畏谓 蟺蚁慰畏纬慰蠉渭蔚谓畏] dddd [{}] LT';
                }
            },
            sameElse : 'L'
        },
        calendar : function (key, mom) {
            var output = this._calendarEl[key],
                hours = mom && mom.hours();

            if (typeof output === 'function') {
                output = output.apply(mom);
            }

            return output.replace('{}', (hours % 12 === 1 ? '蟽蟿畏' : '蟽蟿喂蟼'));
        },
        relativeTime : {
            future : '蟽蔚 %s',
            past : '%s 蟺蚁喂谓',
            s : '位委纬伪 未蔚蠀蟿蔚蚁蠈位蔚蟺蟿伪',
            m : '苇谓伪 位蔚蟺蟿蠈',
            mm : '%d 位蔚蟺蟿维',
            h : '渭委伪 蠋蚁伪',
            hh : '%d 蠋蚁蔚蟼',
            d : '渭委伪 渭苇蚁伪',
            dd : '%d 渭苇蚁蔚蟼',
            M : '苇谓伪蟼 渭萎谓伪蟼',
            MM : '%d 渭萎谓蔚蟼',
            y : '苇谓伪蟼 蠂蚁蠈谓慰蟼',
            yy : '%d 蠂蚁蠈谓喂伪'
        },
        ordinalParse: /\d{1,2}畏/,
        ordinal: '%d畏',
        week : {
            dow : 1, // Monday is the first day of the week.
            doy : 4  // The week that contains Jan 4st is the first week of the year.
        }
    });
}));
