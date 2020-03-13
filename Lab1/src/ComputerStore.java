import cpu.AMD;
import cpu.CPU;
import cpu.Intel;
import hardDisk.HardDisk;
import hardDisk.Seagate;
import hardDisk.WestDigitals;
import mainBoard.Asus;
import mainBoard.Gigabyte;
import mainBoard.MainBoard;
import ram.Kingston;
import ram.RAM;
import ram.Samsung;

public class ComputerStore {
    public static void main(String[] args) {
        //初始化多种组件
        CPU cpu1 = new Intel("intel_1" , 8 , 1500);
        CPU cpu2 = new AMD("amd_99" , 4 , 1000);
        CPU cpu3 = new Intel("intel_99" , 16 , 2999);
        HardDisk hardDisk1 = new Seagate("seagate_101" , "1TB" , 799);
        HardDisk hardDisk2 = new WestDigitals("westDigitals_250" , "10GB" , 9999);
        HardDisk hardDisk3 = new Seagate("seagate_500" , "500GB" , 599);
        MainBoard mainBoard1 = new Asus("asus_9" , "3000Mbps" , 1999);
        MainBoard mainBoard2 = new Gigabyte("gigabyte_1558" , "2594Mbps" , 1499);
        MainBoard mainBoard3 = new Gigabyte("gigabyte_5499" , "5000Mbps" , 4999);
        RAM ram1 = new Kingston("kingston_777" , "8GB" , 599);
        RAM ram2 = new Kingston("kingston_999" , "16GB" , 799);
        RAM ram3 = new Samsung("samsung_197" , "4GB" , 599);

        //初始化3个计算机实例
        Computer computer1 = new Computer("computer1",cpu1,ram1,hardDisk1,mainBoard1);
        Computer computer2 = new Computer("computer2",cpu2,ram2,hardDisk2,mainBoard2);
        Computer computer3 = new Computer("computer3",cpu3,ram3,hardDisk3,mainBoard3);

        //打印信息
        computer1.display();
        computer2.display();
        computer3.display();
        System.out.println("----------------------------------------------------------------");
        //工作
        computer1.work();
        computer2.work();
        computer3.work();
    }
}
