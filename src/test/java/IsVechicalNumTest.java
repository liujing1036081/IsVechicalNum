
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by liujing on 2017/11/10.
 */
public class IsVechicalNumTest {
    @Test
    public void getIsVechicalNumTest(){
        String str="山东省济南市遥墙机场(五十铃牌桂J12128号1.490吨轻型箱式货车)";
        GetStrFromCorpname getstrfromcorpname=new GetStrFromCorpname();
        //获取括号中的字符串
        ArrayList innerStringList=getstrfromcorpname.getStr(str);
        CorpNamePreCompile Isvechical=new CorpNamePreCompile();
//        System.out.println(innerStringList);
        //遍历括号中的字符串并判断字符串中有没有车牌号
        for(int i=0;i<innerStringList.size();i++){
            boolean result= Isvechical.isVehicleNumber(innerStringList.get(i).toString());
            System.out.println("括号中内的字符串中有车牌号吗？： "+result);

        }

    }
}
