import java.io.*;

public class FileCopy {
    public static void main(String[] args){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入需要拷贝的目标文件路径:");
            String from = input.readLine();
            System.out.println("请输入拷贝位置路径及文件名称:");
            String to = input.readLine();

            File sourceFile = new File(from);
            File destinationFile = new File(to);

            byte[] data = new byte[1024*8];
            InputStream inputStream = new FileInputStream(sourceFile);
            OutputStream outputStream = new FileOutputStream(destinationFile);
            int length;
            while ((length = inputStream.read(data)) != -1){
                outputStream.write(data,0,length);
                outputStream.flush();
            }
            inputStream.close();
            outputStream.close();
            System.out.println("拷贝完成");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
