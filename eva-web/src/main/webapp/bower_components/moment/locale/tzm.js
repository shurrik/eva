// moment.js locale configuration
// locale : Morocco Central Atlas Tamazi桑t (tzm)
// author : Abdel Said : https://github.com/abdelsaid

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('tzm', {
        months : '獾夆祻獾忊窗獾⑩禂_獯扁禃獯扳耽獾昣獾庘窗獾曗禋_獾夆幢獾斺祲獾扰獾庘窗獾⑩耽獾揰獾⑩禄獾忊耽獾揰獾⑩禄獾嵝耽獾撯担_獾栤禄獾涒祸_獾涒禄獾溾窗獾忊幢獾夆禂_獯解禑獾撯幢獾昣獾忊禄獾♀窗獾忊幢獾夆禂_獯封禄獾娾祻獯扁祲獾?.split('_'),
        monthsShort : '獾夆祻獾忊窗獾⑩禂_獯扁禃獯扳耽獾昣獾庘窗獾曗禋_獾夆幢獾斺祲獾扰獾庘窗獾⑩耽獾揰獾⑩禄獾忊耽獾揰獾⑩禄獾嵝耽獾撯担_獾栤禄獾涒祸_獾涒禄獾溾窗獾忊幢獾夆禂_獯解禑獾撯幢獾昣獾忊禄獾♀窗獾忊幢獾夆禂_獯封禄獾娾祻獯扁祲獾?.split('_'),
        weekdays : '獯扳禉獯扳祹獯扳禉_獯扳耽獾忊窗獾檩獯扳禉獾夆祻獯扳禉_獯扳唇獾斺窗獾檩獯扳唇獾♀窗獾檩獯扳禉獾夆祹獾♀窗獾檩獯扳禉獾夆垂獾⑩窗獾?.split('_'),
        weekdaysShort : '獯扳禉獯扳祹獯扳禉_獯扳耽獾忊窗獾檩獯扳禉獾夆祻獯扳禉_獯扳唇獾斺窗獾檩獯扳唇獾♀窗獾檩獯扳禉獾夆祹獾♀窗獾檩獯扳禉獾夆垂獾⑩窗獾?.split('_'),
        weekdaysMin : '獯扳禉獯扳祹獯扳禉_獯扳耽獾忊窗獾檩獯扳禉獾夆祻獯扳禉_獯扳唇獾斺窗獾檩獯扳唇獾♀窗獾檩獯扳禉獾夆祹獾♀窗獾檩獯扳禉獾夆垂獾⑩窗獾?.split('_'),
        longDateFormat : {
            LT : 'HH:mm',
            LTS: 'LT:ss',
            L : 'DD/MM/YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY LT',
            LLLL : 'dddd D MMMM YYYY LT'
        },
        calendar : {
            sameDay: '[獯扳禉獯封祬 獯碷 LT',
            nextDay: '[獯扳禉獯解窗 獯碷 LT',
            nextWeek: 'dddd [獯碷 LT',
            lastDay: '[獯扳禋獯扳祻獾?獯碷 LT',
            lastWeek: 'dddd [獯碷 LT',
            sameElse: 'L'
        },
        relativeTime : {
            future : '獯封窗獯封祬 獾?獾⑩窗獾?%s',
            past : '獾⑩窗獾?%s',
            s : '獾夆祹獾夆唇',
            m : '獾庘祲獾忊禄獯?,
            mm : '%d 獾庘祲獾忊禄獯?,
            h : '獾欌窗獾勨窗',
            hh : '%d 獾溾窗獾欌禉獯扳祫獾夆祻',
            d : '獯扳禉獾?,
            dd : '%d o獾欌禉獯扳祻',
            M : '獯扳耽o獾撯禂',
            MM : '%d 獾夆耽獾⑩祲獾斺祻',
            y : '獯扳禉獯斥窗獾?,
            yy : '%d 獾夆禉獯斥窗獾欌祻'
        },
        week : {
            dow : 6, // Saturday is the first day of the week.
            doy : 12  // The week that contains Jan 1st is the first week of the year.
        }
    });
}));
