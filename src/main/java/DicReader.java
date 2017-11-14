import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by liujing on 2017/11/14.
 * 加载词典使用的类
 */
public class DicReader {
    public static BufferedReader getReader(String name){
        try{
            InputStream in=DicReader.class.getResourceAsStream("/"+name);
            return new BufferedReader(new InputStreamReader(in,"utf-8"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }

}
