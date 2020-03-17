import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountNumOfString {
    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        //通过命令行参数输入
        for (String s: args){
            if (!map.keySet().contains(s)){
                //放入map中
                map.put(s,1);
            }else {
                //计数加一
                Integer num = map.get(s);
                map.put(s,num+1);
            }
        }

        //遍历输出
        Set<String> keySet = map.keySet();
        for (String key: keySet){
            System.out.println("<"+key+">=<"+map.get(key)+">");
}
    }
}
