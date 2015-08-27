// moment.js locale configuration
// locale : khmer (km)
// author : Kruy Vanna : https://github.com/kruyvanna

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('km', {
        months: '钓樶瀫钓氠灦_钓€钓会灅钐掅滠钐坃钓樶灧钓抚灦_钓樶焷钓热灦_钓п灍钓椺灦_钓樶灧钓愥灮钓抚灦_钓€钓€钐掅瀫钓娽灦_钓热灨钓犪灦_钓€钓夅炼钓夅灦_钓忈灮钓涐灦_钓湿灧钓呩炼钓吗灧钓€钓禵钓掅炼钓抚灱'.split('_'),
        monthsShort: '钓樶瀫钓氠灦_钓€钓会灅钐掅滠钐坃钓樶灧钓抚灦_钓樶焷钓热灦_钓п灍钓椺灦_钓樶灧钓愥灮钓抚灦_钓€钓€钐掅瀫钓娽灦_钓热灨钓犪灦_钓€钓夅炼钓夅灦_钓忈灮钓涐灦_钓湿灧钓呩炼钓吗灧钓€钓禵钓掅炼钓抚灱'.split('_'),
        weekdays: '钓⑨灦钓戓灧钓忈炼钓檩钓呩煇钓抚炼钓慱钓⑨瀯钐掅瀭钓夺灇_钓栣灮钓抇钓栣炼钓氠灎钓热炼钓斸瀼钓丰煃_钓热灮钓€钐掅灇_钓热焻钓氠煃'.split('_'),
        weekdaysShort: '钓⑨灦钓戓灧钓忈炼钓檩钓呩煇钓抚炼钓慱钓⑨瀯钐掅瀭钓夺灇_钓栣灮钓抇钓栣炼钓氠灎钓热炼钓斸瀼钓丰煃_钓热灮钓€钐掅灇_钓热焻钓氠煃'.split('_'),
        weekdaysMin: '钓⑨灦钓戓灧钓忈炼钓檩钓呩煇钓抚炼钓慱钓⑨瀯钐掅瀭钓夺灇_钓栣灮钓抇钓栣炼钓氠灎钓热炼钓斸瀼钓丰煃_钓热灮钓€钐掅灇_钓热焻钓氠煃'.split('_'),
        longDateFormat: {
            LT: 'HH:mm',
            LTS : 'LT:ss',
            L: 'DD/MM/YYYY',
            LL: 'D MMMM YYYY',
            LLL: 'D MMMM YYYY LT',
            LLLL: 'dddd, D MMMM YYYY LT'
        },
        calendar: {
            sameDay: '[钓愥炼钓勧焹钓抚焾 钓樶焿钐勧瀯] LT',
            nextDay: '[钓热炼钓⑨焸钓€ 钓樶焿钐勧瀯] LT',
            nextWeek: 'dddd [钓樶焿钐勧瀯] LT',
            lastDay: '[钓樶炼钓热灧钓涐灅钓丰瀴 钓樶焿钐勧瀯] LT',
            lastWeek: 'dddd [钓热灁钐掅瀼钓夺灎钐嶀灅钓会灀] [钓樶焿钐勧瀯] LT',
            sameElse: 'L'
        },
        relativeTime: {
            future: '%s钓戓焵钓?,
            past: '%s钓樶灮钓?,
            s: '钓斸焿钓会灀钐掅灅钓夺灀钓湿灧钓抚灦钓戓灨',
            m: '钓樶灲钓欋灀钓夺澜钓?,
            mm: '%d 钓抚灦钓戓灨',
            h: '钓樶灲钓欋灅钐夅焺钓?,
            hh: '%d 钓樶焿钐勧瀯',
            d: '钓樶灲钓欋瀽钐掅瀯钐?,
            dd: '%d 钓愥炼钓勧焹',
            M: '钓樶灲钓欋瀬钐?,
            MM: '%d 钓佱焸',
            y: '钓樶灲钓欋瀱钐掅灀钓夺焼',
            yy: '%d 钓吗炼钓抚灦钐?
        },
        week: {
            dow: 1, // Monday is the first day of the week.
            doy: 4 // The week that contains Jan 4th is the first week of the year.
        }
    });
}));
