// moment.js locale configuration
// locale : Burmese (my)
// author : Squar team, mysquar.com

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
        '1': '醽?,
        '2': '醽?,
        '3': '醽?,
        '4': '醽?,
        '5': '醽?,
        '6': '醽?,
        '7': '醽?,
        '8': '醽?,
        '9': '醽?,
        '0': '醽€'
    }, numberMap = {
        '醽?: '1',
        '醽?: '2',
        '醽?: '3',
        '醽?: '4',
        '醽?: '5',
        '醽?: '6',
        '醽?: '7',
        '醽?: '8',
        '醽?: '9',
        '醽€': '0'
    };
    return moment.defineLocale('my', {
        months: '醼囜€斸€横€斸€浊€€涐€甠醼栣€贬€栣€贬€€横€浊€€涐€甠醼欋€愥€篲醼п€暧€坚€甠醼欋€盻醼囜€结€斸€篲醼囜€搬€湿€€€勧€篲醼炨€坚€伧€€愥€篲醼呩€€醼横€愥€勧€横€樶€琠醼♂€贬€€€醼横€愥€€€樶€琠醼斸€€€浊€勧€横€樶€琠醼掅€€囜€勧€横€樶€?.split('_'),
        monthsShort: '醼囜€斸€篲醼栣€盻醼欋€愥€篲醼暧€坚€甠醼欋€盻醼囜€结€斸€篲醼湿€€€勧€篲醼炨€糭醼呩€€醼篲醼♂€贬€€€醼篲醼斸€€痏醼掅€?.split('_'),
        weekdays: '醼愥€斸€勧€横€贯€伧€斸€结€盻醼愥€斸€勧€横€贯€湿€琠醼♂€勧€横€贯€伧€玙醼椺€€掅€贯€抚€热€搬€竉醼€醼坚€€炨€暧€愥€贬€竉醼炨€贬€€€醼坚€琠醼呩€斸€?.split('_'),
        weekdaysShort: '醼斸€结€盻醼湿€琠醼勧€横€贯€伧€玙醼热€搬€竉醼€醼坚€琠醼炨€贬€琠醼斸€?.split('_'),
        weekdaysMin: '醼斸€结€盻醼湿€琠醼勧€横€贯€伧€玙醼热€搬€竉醼€醼坚€琠醼炨€贬€琠醼斸€?.split('_'),
        longDateFormat: {
            LT: 'HH:mm',
            LTS: 'HH:mm:ss',
            L: 'DD/MM/YYYY',
            LL: 'D MMMM YYYY',
            LLL: 'D MMMM YYYY LT',
            LLLL: 'dddd D MMMM YYYY LT'
        },
        calendar: {
            sameDay: '[醼氠€斸€?] LT [醼欋€踞€琞',
            nextDay: '[醼欋€斸€€醼横€栣€坚€斸€篯 LT [醼欋€踞€琞',
            nextWeek: 'dddd LT [醼欋€踞€琞',
            lastDay: '[醼欋€斸€?醼€] LT [醼欋€踞€琞',
            lastWeek: '[醼暧€坚€€羔€佱€册€丰€炨€贬€琞 dddd LT [醼欋€踞€琞',
            sameElse: 'L'
        },
        relativeTime: {
            future: '醼湿€€欋€娽€横€?%s 醼欋€踞€?,
            past: '醼湿€结€斸€横€佱€册€丰€炨€贬€?%s 醼€',
            s: '醼呩€€醼贯€€醼斸€?醼♂€斸€娽€横€羔€勧€氠€?,
            m: '醼愥€呩€横€欋€€斸€呩€?,
            mm: '%d 醼欋€€斸€呩€?,
            h: '醼愥€呩€横€斸€€涐€?,
            hh: '%d 醼斸€€涐€?,
            d: '醼愥€呩€横€涐€€醼?,
            dd: '%d 醼涐€€醼?,
            M: '醼愥€呩€横€?,
            MM: '%d 醼?,
            y: '醼愥€呩€横€斸€踞€呩€?,
            yy: '%d 醼斸€踞€呩€?
        },
        preparse: function (string) {
            return string.replace(/[醽佱亗醽冡亜醽呩亚醽囜亪醽夅亐]/g, function (match) {
                return numberMap[match];
            });
        },
        postformat: function (string) {
            return string.replace(/\d/g, function (match) {
                return symbolMap[match];
            });
        },
        week: {
            dow: 1, // Monday is the first day of the week.
            doy: 4 // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
