import org.junit.Test;

/**
 * Created by liujing on 2017/11/14.
 */
public class CorpnameStrRecTest {
    @Test
    public void Test(){
        String str="山东省济南市遥墙机场(王挂)";
        CorpnameStrRec corpnameStrRec=new CorpnameStrRec();
        boolean result=corpnameStrRec.corpnameStrRecognition(str);
        System.out.println("corpname中含有车牌号或者人名： "+result);

    }
}
