import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.io.BufferedReader;
import java.util.HashMap;

/**
 * Created by liujing on 2017/11/14.
 * 姓氏字典
 */
public class LastNameDictionary {
    private static HashMap<String, String> lastNameMap;

    public static HashMap<String, String> getLastNameMap() {
        if (lastNameMap == null) {
            initLastNameMap();
        }
        return lastNameMap;
    }

    //初始化
    private static void initLastNameMap() {
        BufferedReader br;
        lastNameMap = new HashMap<String, String>();
        br = DicReader.getReader("lastName.txt");
        String str;
        try {
            while ((str = br.readLine()) != null) {
                if (str.trim() != null) {
                    lastNameMap.put(str.trim(), str.trim());
                }
            }
            if (br != null) br.close();

        } catch (Exception e) {
            System.out.println("姓氏词词典读取错误" + e);
            lastNameMap = new HashMap<String, String>();
        }

    }


}
