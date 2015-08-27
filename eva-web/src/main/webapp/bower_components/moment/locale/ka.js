// moment.js locale configuration
// locale : Georgian (ka)
// author : Irakli Janiashvili : https://github.com/irakli-janiashvili

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define(['moment'], factory); // AMD
    } else if (typeof exports === 'object') {
        module.exports = factory(require('../moment')); // Node
    } else {
        factory((typeof global !== 'undefined' ? global : this).moment); // node or other global
    }
}(function (moment) {
    function monthsCaseReplace(m, format) {
        var months = {
            'nominative': '醿樶儛醿湿儠醿愥儬醿榑醿椺偿醿戓偿醿犪儠醿愥儦醿榑醿涐儛醿犪儮醿榑醿愥优醿犪儤醿氠儤_醿涐儛醿樶儭醿榑醿樶儠醿湿儤醿♂儤_醿樶儠醿氠儤醿♂儤_醿愥儝醿暧儤醿♂儮醿漘醿♂偿醿メ儮醿斸儧醿戓偿醿犪儤_醿浊儱醿⑨儩醿涐儜醿斸儬醿榑醿湿儩醿斸儧醿戓偿醿犪儤_醿抚偿醿欋偿醿涐儜醿斸儬醿?.split('_'),
            'accusative': '醿樶儛醿湿儠醿愥儬醿醿椺偿醿戓偿醿犪儠醿愥儦醿醿涐儛醿犪儮醿醿愥优醿犪儤醿氠儤醿醿涐儛醿樶儭醿醿樶儠醿湿儤醿♂儭_醿樶儠醿氠儤醿♂儭_醿愥儝醿暧儤醿♂儮醿醿♂偿醿メ儮醿斸儧醿戓偿醿犪儭_醿浊儱醿⑨儩醿涐儜醿斸儬醿醿湿儩醿斸儧醿戓偿醿犪儭_醿抚偿醿欋偿醿涐儜醿斸儬醿?.split('_')
        },

        nounCase = (/D[oD] *MMMM?/).test(format) ?
            'accusative' :
            'nominative';

        return months[nounCase][m.month()];
    }

    function weekdaysCaseReplace(m, format) {
        var weekdays = {
            'nominative': '醿欋儠醿樶儬醿恄醿浊儬醿ㄡ儛醿戓儛醿椺儤_醿♂儛醿涐儴醿愥儜醿愥儣醿榑醿浊儣醿儴醿愥儜醿愥儣醿榑醿儯醿椺儴醿愥儜醿愥儣醿榑醿炨儛醿犪儛醿♂儥醿斸儠醿榑醿ㄡ儛醿戓儛醿椺儤'.split('_'),
            'accusative': '醿欋儠醿樶儬醿愥儭_醿浊儬醿ㄡ儛醿戓儛醿椺儭_醿♂儛醿涐儴醿愥儜醿愥儣醿醿浊儣醿儴醿愥儜醿愥儣醿醿儯醿椺儴醿愥儜醿愥儣醿醿炨儛醿犪儛醿♂儥醿斸儠醿醿ㄡ儛醿戓儛醿椺儭'.split('_')
        },

        nounCase = (/(醿儤醿湿儛|醿ㄡ偿醿涐儞醿斸儝)/).test(format) ?
            'accusative' :
            'nominative';

        return weekdays[nounCase][m.day()];
    }

    return moment.defineLocale('ka', {
        months : monthsCaseReplace,
        monthsShort : '醿樶儛醿淿醿椺偿醿慱醿涐儛醿燺醿愥优醿燺醿涐儛醿榑醿樶儠醿淿醿樶儠醿歘醿愥儝醿昣醿♂偿醿醿浊儱醿醿湿儩醿扰醿抚偿醿?.split('_'),
        weekdays : weekdaysCaseReplace,
        weekdaysShort : '醿欋儠醿榑醿浊儬醿╛醿♂儛醿冲醿浊儣醿甠醿儯醿梍醿炨儛醿燺醿ㄡ儛醿?.split('_'),
        weekdaysMin : '醿欋儠_醿浊儬_醿♂儛_醿浊儣_醿儯_醿炨儛_醿ㄡ儛'.split('_'),
        longDateFormat : {
            LT : 'h:mm A',
            LTS : 'h:mm:ss A',
            L : 'DD/MM/YYYY',
            LL : 'D MMMM YYYY',
            LLL : 'D MMMM YYYY LT',
            LLLL : 'dddd, D MMMM YYYY LT'
        },
        calendar : {
            sameDay : '[醿抚储醿斸儭] LT[-醿栣偿]',
            nextDay : '[醿儠醿愥儦] LT[-醿栣偿]',
            lastDay : '[醿掅儯醿ㄡ儤醿淽 LT[-醿栣偿]',
            nextWeek : '[醿ㄡ偿醿涐儞醿斸儝] dddd LT[-醿栣偿]',
            lastWeek : '[醿儤醿湿儛] dddd LT-醿栣偿',
            sameElse : 'L'
        },
        relativeTime : {
            future : function (s) {
                return (/(醿儛醿涐儤|醿儯醿椺儤|醿♂儛醿愥儣醿榺醿偿醿氠儤)/).test(s) ?
                    s.replace(/醿?/, '醿ㄡ儤') :
                    s + '醿ㄡ儤';
            },
            past : function (s) {
                if ((/(醿儛醿涐儤|醿儯醿椺儤|醿♂儛醿愥儣醿榺醿抚储醿攟醿椺儠醿?/).test(s)) {
                    return s.replace(/(醿榺醿?$/, '醿樶儭 醿儤醿?);
                }
                if ((/醿偿醿氠儤/).test(s)) {
                    return s.replace(/醿偿醿氠儤$/, '醿儦醿樶儭 醿儤醿?);
                }
            },
            s : '醿犪儛醿涐儞醿斸儨醿樶儧醿?醿儛醿涐儤',
            m : '醿儯醿椺儤',
            mm : '%d 醿儯醿椺儤',
            h : '醿♂儛醿愥儣醿?,
            hh : '%d 醿♂儛醿愥儣醿?,
            d : '醿抚储醿?,
            dd : '%d 醿抚储醿?,
            M : '醿椺儠醿?,
            MM : '%d 醿椺儠醿?,
            y : '醿偿醿氠儤',
            yy : '%d 醿偿醿氠儤'
        },
        ordinalParse: /0|1-醿氠儤|醿涐偿-\d{1,2}|\d{1,2}-醿?,
        ordinal : function (number) {
            if (number === 0) {
                return number;
            }

            if (number === 1) {
                return number + '-醿氠儤';
            }

            if ((number < 20) || (number <= 100 && (number % 20 === 0)) || (number % 100 === 0)) {
                return '醿涐偿-' + number;
            }

            return number + '-醿?;
        },
        week : {
            dow : 1,
            doy : 7
        }
    });
}));
