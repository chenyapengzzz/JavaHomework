import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        File file = new File("了不起的盖茨比英文.txt");
        Reader reader = null;

        //文件输入及处理
        try {
            reader = new FileReader(file);
            String line = null;
            BufferedReader bfReader = new BufferedReader(reader);
            while ((line = bfReader.readLine()) != null){
                String [] word = line.split(" ");

                for (int i = 0 ; i < word.length ; i++){
                    word[i] = word[i].trim();
                    if (!word[i].isEmpty()){
                        if (!map.keySet().contains(word[i])){
                            //放入map中
                            map.put(word[i],1);
                        }else {
                            //计数加一
                            Integer num = map.get(word[i]);
                            map.put(word[i],num+1);
                        }
                    }

                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        //排序
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //遍历输出到output.txt中
        File output = new File("output.txt");
        if (!output.exists()){
            try {
                output.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(output);
            for (Map.Entry<String,Integer> e: list){
                fileWriter.write(e.getKey() + " " + e.getValue() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Finish!");

    }


}
