// moment.js locale configuration
// locale : thai (th)
// author : Kridsada Thanabulpong : https://github.com/sirn

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    return moment.defineLocale('th', {
        months : '喔∴竵喔｀覆喔剿浮_喔佮父喔∴笭喔侧笧喔编笝喔樴箤_喔∴傅喔权覆喔剿浮_喙€喔∴俯喔侧涪喔檩喔炧袱喔┼笭喔侧竸喔喔∴复喔栢父喔权覆喔⑧笝_喔佮福喔佮笌喔侧竸喔喔复喔囙斧喔侧竸喔喔佮副喔权涪喔侧涪喔檩喔曕父喔ム覆喔剿浮_喔炧袱喔ㄠ笀喔脆竵喔侧涪喔檩喔樴副喔权抚喔侧竸喔?.split('_'),
        monthsShort : '喔∴竵喔｀覆_喔佮父喔∴笭喔瞋喔∴傅喔权覆_喙€喔∴俯喔瞋喔炧袱喔┼笭喔瞋喔∴复喔栢父喔权覆_喔佮福喔佮笌喔瞋喔复喔囙斧喔瞋喔佮副喔权涪喔瞋喔曕父喔ム覆_喔炧袱喔ㄠ笀喔脆竵喔瞋喔樴副喔权抚喔?.split('_'),
        weekdays : '喔覆喔椸复喔曕涪喙宊喔堗副喔权笚喔｀箤_喔副喔囙竸喔侧福_喔炧父喔榑喔炧袱喔副喔笟喔断傅_喔ㄠ父喔佮福喙宊喙€喔覆喔｀箤'.split('_'),
        weekdaysShort : '喔覆喔椸复喔曕涪喙宊喔堗副喔权笚喔｀箤_喔副喔囙竸喔侧福_喔炧父喔榑喔炧袱喔副喔猒喔ㄠ父喔佮福喙宊喙€喔覆喔｀箤'.split('_'), // yes, three characters difference
        weekdaysMin : '喔覆._喔?_喔?_喔?_喔炧袱._喔?_喔?'.split('_'),
        longDateFormat : {
            LT : 'H 喔权覆喔复喔佮覆 m 喔权覆喔椸傅',
            LTS : 'LT s 喔о复喔权覆喔椸傅',
            L : 'YYYY/MM/DD',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY 喙€喔о弗喔?LT',
            LLLL : '喔о副喔檇ddd喔椸傅喙?D MMMM YYYY 喙€喔о弗喔?LT'
        },
        meridiem : function (hour, minute, isLower) {
            if (hour < 12) {
                return '喔佮箞喔笝喙€喔椸傅喙堗涪喔?;
            } else {
                return '喔弗喔编竾喙€喔椸傅喙堗涪喔?;
            }
        },
        calendar : {
            sameDay : '[喔о副喔权笝喔掂箟 喙€喔о弗喔瞉 LT',
            nextDay : '[喔炧福喔膏箞喔囙笝喔掂箟 喙€喔о弗喔瞉 LT',
            nextWeek : 'dddd[喔笝喙夃覆 喙€喔о弗喔瞉 LT',
            lastDay : '[喙€喔∴阜喙堗腑喔о覆喔权笝喔掂箟 喙€喔о弗喔瞉 LT',
            lastWeek : '[喔о副喔橾dddd[喔椸傅喙堗箒喔ム箟喔?喙€喔о弗喔瞉 LT',
            sameElse : 'L'
        },
        relativeTime : {
            future : '喔傅喔?%s',
            past : '%s喔椸傅喙堗箒喔ム箟喔?,
            s : '喙剿浮喙堗竵喔掂箞喔о复喔权覆喔椸傅',
            m : '1 喔权覆喔椸傅',
            mm : '%d 喔权覆喔椸傅',
            h : '1 喔娻副喙堗抚喙傕浮喔?,
            hh : '%d 喔娻副喙堗抚喙傕浮喔?,
            d : '1 喔о副喔?,
            dd : '%d 喔о副喔?,
            M : '1 喙€喔断阜喔笝',
            MM : '%d 喙€喔断阜喔笝',
            y : '1 喔涏傅',
            yy : '%d 喔涏傅'
        }
    });
}));
