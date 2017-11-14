import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liujing on 2017/11/10.
 * 车牌号识别
 */

public class CorpNamePreCompile {

    public boolean isVehicleNumber(String str) {
        boolean result = false;

        //正常车牌号；桂J1181挂；
        Pattern pattern_1 = Pattern.compile("^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]" +
                "{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$");
        //汽车品牌+正常车牌号
        Pattern pattern_2 = Pattern.compile("^[《\u4e00-\u9fa5》]{4,6}[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]" +
                "{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$");
        //非正常车牌号1##没有正常省字简称：车牌号:89－50490
        Pattern pattern_3 = Pattern.compile("^[车牌号:]{4}[A-Z0-9]{2}[－]{1}[A-Z0-9]{5}$");
        //非正常车牌号2##有省字简称，有标点符号：汉字+省简称+大写字母+标点符号+数字:单车皖M-60871，蒙G.18230,
        Pattern pattern_4 = Pattern.compile("^[\u4e00-\u9fa5]{0,5}[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z0-9]{1}" +
                "[?/.:·-]{1}[A-Z0-9]{5}$");
        //非正常车牌号3##位数大于7：省字简称+两位数字：辽01W0440，辽11/D0054
        Pattern pattern_5 = Pattern.compile("^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[0-9]{2}[/]{0,1}[A-Z0-9]{5}$");
        //非正常车牌号4##地名后数字字母标点符号：山东H?44718
        Pattern pattern_6 = Pattern.compile("^[\u4e00-\u9fa5]{2,6}[A-Z]{1}[?/.:·-]{1}[A-Z0-9]{5}$");
        //非正常车牌号5##汉字后正常车牌号+任意字符：五十铃牌桂JLY128号1.490吨轻型箱式货车
        Pattern pattern_7 = Pattern.compile("^[\u4e00-\u9fa5]{0,6}[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]" +
                "{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}.*$");

        Matcher matcher_1 = pattern_1.matcher(str);
        Matcher matcher_2 = pattern_2.matcher(str);
        Matcher matcher_3 = pattern_3.matcher(str);
        Matcher matcher_4 = pattern_4.matcher(str);
        Matcher matcher_5 = pattern_5.matcher(str);
        Matcher matcher_6 = pattern_6.matcher(str);
        Matcher matcher_7 = pattern_7.matcher(str);

        if (matcher_1.matches()) {
            result = true;
            System.out.println("正常车牌号！");
        } else if (matcher_2.matches()) {
            result = true;
            System.out.println("汽车品牌+车牌号！");
        } else if (matcher_3.matches()) {
            result = true;
            System.out.println("非正常车牌号1");
        } else if (matcher_4.matches()) {
            result = true;
            System.out.println("非正常车牌号2");
        } else if (matcher_5.matches()) {
            result = true;
            System.out.println("非正常车牌号3");
        } else if (matcher_6.matches()) {
            result = true;
            System.out.println("非正常车牌号4");
        } else if (matcher_7.matches()) {
            result = true;
            System.out.println("非正常车牌号5");
        } else {
            System.out.println("没有车牌号！");

        }
    return result;
    }

    /**
     * 姓氏识别
     * @param str
     * @return
     */
    private static final HashMap<String,String > lastNameMap=LastNameDictionary.getLastNameMap();
    public boolean IsName(String str){
        boolean result = false;
        String lastName=lastNameMap.get(str);
        if(lastName!=null) result=true;
        return result;
    }

}


