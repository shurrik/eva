// moment.js locale configuration
// locale : Hebrew (he)
// author : Tomer Cohen : https://github.com/tomer
// author : Moshe Simantov : https://github.com/DevelopmentIL
// author : Tal Ater : https://github.com/TalAter

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('he', {
        months : '讬谞谠讗专_驻讘专谠讗专_诪专抓_讗驻专讬诇_诪讗讬_讬谠谞讬_讬谠诇讬_讗谠讙谠住讟_住驻讟诪讘专_讗谠拽讟谠讘专_谞谠讘诪讘专_赞爪诪讘专'.split('_'),
        monthsShort : '讬谞谠壮_驻讘专壮_诪专抓_讗驻专壮_诪讗讬_讬谠谞讬_讬谠诇讬_讗谠讙壮_住驻讟壮_讗谠拽壮_谞谠讘壮_赞爪诪壮'.split('_'),
        weekdays : '专讗砖谠谉_砖谞讬_砖诇讬砖讬_专讘讬注讬_谳诪讬砖讬_砖讬砖讬_砖讘转'.split('_'),
        weekdaysShort : '讗壮_讘壮_讙壮_赞壮_讛壮_谠壮_砖壮'.split('_'),
        weekdaysMin : '讗_讘_讙_赞_讛_谠_砖'.split('_'),
        longDateFormat : {
            LT : 'HH:mm',
            LTS : 'LT:ss',
            L : 'DD/MM/YYYY',
            LL : 'D [讘]MMMM YYYY',
            LLL : 'D [讘]MMMM YYYY LT',
            LLLL : 'dddd, D [讘]MMMM YYYY LT',
            l : 'D/M/YYYY',
            ll : 'D MMM YYYY',
            lll : 'D MMM YYYY LT',
            llll : 'ddd, D MMM YYYY LT'
        },
        calendar : {
            sameDay : '[讛讬谠诐 讘志]LT',
            nextDay : '[诪谳专 讘志]LT',
            nextWeek : 'dddd [讘砖注讛] LT',
            lastDay : '[讗转诪谠诇 讘志]LT',
            lastWeek : '[讘讬谠诐] dddd [讛讗谳专谠谉 讘砖注讛] LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '讘注谠赞 %s',
            past : '诇驻谞讬 %s',
            s : '诪住驻专 砖谞讬谠转',
            m : '赞拽讛',
            mm : '%d 赞拽谠转',
            h : '砖注讛',
            hh : function (number) {
                if (number === 2) {
                    return '砖注转讬讬诐';
                }
                return number + ' 砖注谠转';
            },
            d : '讬谠诐',
            dd : function (number) {
                if (number === 2) {
                    return '讬谠诪讬讬诐';
                }
                return number + ' 讬诪讬诐';
            },
            M : '谳谠赞砖',
            MM : function (number) {
                if (number === 2) {
                    return '谳谠赞砖讬讬诐';
                }
                return number + ' 谳谠赞砖讬诐';
            },
            y : '砖谞讛',
            yy : function (number) {
                if (number === 2) {
                    return '砖谞转讬讬诐';
                }
                return number + ' 砖谞讬诐';
            }
        }
    });
}));
