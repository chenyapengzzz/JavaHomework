import hardDisk.HardDisk;
import mainBoard.MainBoard;
import cpu.CPU;
import ram.RAM;

public class Computer {
    private String name;
    private CPU cpu;
    private RAM ram;
    private HardDisk hardDisk;
    private MainBoard mainBoard;
    private int price;

    public Computer(String name , CPU cpu , RAM ram , HardDisk hardDisk , MainBoard mainBoard){
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.mainBoard = mainBoard;
        this.price = cpu.getPrice() + ram.getPrice() + hardDisk.getPrice() + mainBoard.getPrice();
    }

    public void display(){
        System.out.println(name+":");
        cpu.display();
        ram.display();
        hardDisk.display();
        mainBoard.display();
        System.out.println("HolePrice:" + price);
        System.out.println();
    }

    public void work(){
        cpu.work();
        ram.work();
        hardDisk.work();
        mainBoard.work();
        System.out.println();
    }
}