// moment.js locale configuration
// locale : tibetan (bo)
// author : Thupten N. Chakrishar : https://github.com/vajradog

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
        '1': '嗉?,
        '2': '嗉?,
        '3': '嗉?,
        '4': '嗉?,
        '5': '嗉?,
        '6': '嗉?,
        '7': '嗉?,
        '8': '嗉?,
        '9': '嗉?,
        '0': '嗉?
    },
    numberMap = {
        '嗉?: '1',
        '嗉?: '2',
        '嗉?: '3',
        '嗉?: '4',
        '嗉?: '5',
        '嗉?: '6',
        '嗉?: '7',
        '嗉?: '8',
        '嗉?: '9',
        '嗉?: '0'
    };

    return moment.defineLocale('bo', {
        months : '嘟熰境嗉嬥綎嗉嬥綉嘟剿纭嘟断郊_嘟熰境嗉嬥綎嗉嬥絺嘟夃讲嘟︵纭嘟扰嘟熰境嗉嬥綎嗉嬥絺嘟︵酱嘟樴纭嘟扰嘟熰境嗉嬥綎嗉嬥綎嘟炧讲嗉嬥綌_嘟熰境嗉嬥綎嗉嬥剑嗑断纭嘟扰嘟熰境嗉嬥綎嗉嬥綉嗑侧酱嘟傕纭嘟扰嘟熰境嗉嬥綎嗉嬥綎嘟钺酱嘟撪纭嘟扰嘟熰境嗉嬥綎嗉嬥綎嘟⑧缅嗑编綉嗉嬥綌_嘟熰境嗉嬥綎嗉嬥綉嘟傕酱嗉嬥綌_嘟熰境嗉嬥綎嗉嬥綎嘟呧酱嗉嬥綌_嘟熰境嗉嬥綎嗉嬥綎嘟呧酱嗉嬥絺嘟呧讲嘟傕纭嘟扰嘟熰境嗉嬥綎嗉嬥綎嘟呧酱嗉嬥絺嘟夃讲嘟︵纭嘟?.split('_'),
        monthsShort : '嘟熰境嗉嬥綎嗉嬥綉嘟剿纭嘟断郊_嘟熰境嗉嬥綎嗉嬥絺嘟夃讲嘟︵纭嘟扰嘟熰境嗉嬥綎嗉嬥絺嘟︵酱嘟樴纭嘟扰嘟熰境嗉嬥綎嗉嬥綎嘟炧讲嗉嬥綌_嘟熰境嗉嬥綎嗉嬥剑嗑断纭嘟扰嘟熰境嗉嬥綎嗉嬥綉嗑侧酱嘟傕纭嘟扰嘟熰境嗉嬥綎嗉嬥綎嘟钺酱嘟撪纭嘟扰嘟熰境嗉嬥綎嗉嬥綎嘟⑧缅嗑编綉嗉嬥綌_嘟熰境嗉嬥綎嗉嬥綉嘟傕酱嗉嬥綌_嘟熰境嗉嬥綎嗉嬥綎嘟呧酱嗉嬥綌_嘟熰境嗉嬥綎嗉嬥綎嘟呧酱嗉嬥絺嘟呧讲嘟傕纭嘟扰嘟熰境嗉嬥綎嗉嬥綎嘟呧酱嗉嬥絺嘟夃讲嘟︵纭嘟?.split('_'),
        weekdays : '嘟傕綗嘟犩纭嘟夃讲嗉嬥綐嗉媉嘟傕綗嘟犩纭嘟熰境嗉嬥綎嗉媉嘟傕綗嘟犩纭嘟樴讲嘟傕纭嘟钺綐嘟⑧纭_嘟傕綗嘟犩纭嘟｀痉嘟傕纭嘟断纭_嘟傕綗嘟犩纭嘟曕酱嘟⑧纭嘟栢酱_嘟傕綗嘟犩纭嘟断纭嘟︵絼嘟︵纭_嘟傕綗嘟犩纭嘟︵兢嘟亨綋嗉嬥綌嗉?.split('_'),
        weekdaysShort : '嘟夃讲嗉嬥綐嗉媉嘟熰境嗉嬥綎嗉媉嘟樴讲嘟傕纭嘟钺綐嘟⑧纭_嘟｀痉嘟傕纭嘟断纭_嘟曕酱嘟⑧纭嘟栢酱_嘟断纭嘟︵絼嘟︵纭_嘟︵兢嘟亨綋嗉嬥綌嗉?.split('_'),
        weekdaysMin : '嘟夃讲嗉嬥綐嗉媉嘟熰境嗉嬥綎嗉媉嘟樴讲嘟傕纭嘟钺綐嘟⑧纭_嘟｀痉嘟傕纭嘟断纭_嘟曕酱嘟⑧纭嘟栢酱_嘟断纭嘟︵絼嘟︵纭_嘟︵兢嘟亨綋嗉嬥綌嗉?.split('_'),
        longDateFormat : {
            LT : 'A h:mm',
            LTS : 'LT:ss',
            L : 'DD/MM/YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY, LT',
            LLLL : 'dddd, D MMMM YYYY, LT'
        },
        calendar : {
            sameDay : '[嘟钺讲嗉嬥舰嘟侧絼] LT',
            nextDay : '[嘟︵絼嗉嬥绑嘟侧綋] LT',
            nextWeek : '[嘟栢綉嘟脆綋嗉嬥綍嗑侧絺嗉嬥舰嗑椸胶嘟︵纭嘟榏, LT',
            lastDay : '[嘟佮纭嘟︵絼] LT',
            lastWeek : '[嘟栢綉嘟脆綋嗉嬥綍嗑侧絺嗉嬥綐嘟愢綘嗉嬥綐] dddd, LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '%s 嘟｀纭',
            past : '%s 嘟︵緮嘟撪纭嘟?,
            s : '嘟｀綐嗉嬥溅嘟?,
            m : '嘟︵緪嘟⑧纭嘟樴纭嘟傕絽嘟侧絺',
            mm : '%d 嘟︵緪嘟⑧纭嘟?,
            h : '嘟嗋酱嗉嬥綒嘟监綉嗉嬥絺嘟呧讲嘟?,
            hh : '%d 嘟嗋酱嗉嬥綒嘟监綉',
            d : '嘟夃讲嘟撪纭嘟傕絽嘟侧絺',
            dd : '%d 嘟夃讲嘟撪纭',
            M : '嘟熰境嗉嬥綎嗉嬥絺嘟呧讲嘟?,
            MM : '%d 嘟熰境嗉嬥綎',
            y : '嘟｀郊嗉嬥絺嘟呧讲嘟?,
            yy : '%d 嘟｀郊'
        },
        preparse: function (string) {
            return string.replace(/[嗉∴饥嗉｀激嗉ム鸡嗉о绩嗉┼紶]/g, function (match) {
                return numberMap[match];
            });
        },
        postformat: function (string) {
            return string.replace(/\d/g, function (match) {
                return symbolMap[match];
            });
        },
        meridiem : function (hour, minute, isLower) {
            if (hour < 4) {
                return '嘟樴綒嘟撪纭嘟樴郊';
            } else if (hour < 10) {
                return '嘟炧郊嘟傕溅嗉嬥絸嘟?;
            } else if (hour < 17) {
                return '嘟夃讲嘟撪纭嘟傕酱嘟?;
            } else if (hour < 20) {
                return '嘟钺絺嘟监絼嗉嬥綉嘟?;
            } else {
                return '嘟樴綒嘟撪纭嘟樴郊';
            }
        },
        week : {
            dow : 0, // Sunday is the first day of the week.
            doy : 6  // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
