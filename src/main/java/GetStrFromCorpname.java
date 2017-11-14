import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by liujing on 2017/11/10.
 */
public class GetStrFromCorpname {
    public ArrayList getStr(String str) {
//        Pattern pattern = Pattern.compile("((.*?))"); //英文括号
        Pattern pattern = Pattern.compile("(\\([^\\)]*\\))"); //中文括号


        Matcher matcher = pattern.matcher(str);
        ArrayList resultString= new ArrayList();
        while (matcher.find()) {
            System.out.println("括号中的内容是： "+matcher.group(1));   //0是包括括号1是只取内容
            resultString.add(matcher.group().substring(1,matcher.group().length()-1));
        }
        return resultString;
    }
}

