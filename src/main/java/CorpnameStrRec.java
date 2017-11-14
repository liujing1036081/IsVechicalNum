import java.util.ArrayList;

/**
 * Created by liujing on 2017/11/14.
 */
public class CorpnameStrRec {
    public boolean corpnameStrRecognition(String str){
        //从corpname的括号中获取字符串
        GetStrFromCorpname getStrFromCorpname=new GetStrFromCorpname();
        ArrayList innerStringList=getStrFromCorpname.getStr(str);
        //初始化字符串预处理类
        CorpNamePreCompile corCom=new CorpNamePreCompile();
        boolean result_vehicle=false;//车牌号
        boolean result_name=false;//姓氏
        for(int i=0;i<innerStringList.size();i++){
            //车牌号识别
            String stri=innerStringList.get(i).toString();
            result_vehicle=corCom.isVehicleNumber(stri);
            System.out.println("第"+i+"个括号中有车牌号： "+result_vehicle);
            //姓氏识别
            if(stri.length()<1||stri.length()>4){
                result_name=false;

            }else{
                boolean result1=corCom.IsName(stri.substring(0,1));//前一个字
                boolean result2=corCom.IsName(stri.substring(0,2));//前两个字
                result_name=result1||result2;
                System.out.println("第"+i+"个括号中有姓氏： "+result_name+"    单字姓氏:"+result1+"    双字姓氏"+result2);

            }

        }
        boolean result=result_vehicle||result_name;
        return  result;


    }
}
