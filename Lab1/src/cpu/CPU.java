package cpu;

public abstract class CPU {
    private String name;
    private int coreNum;
    private int price;

    public CPU(String name , int coreNum , int price){
        this.name = name;
        this.coreNum = coreNum;
        this.price = price;
    }

    abstract public void work();

    public String getName(){
        return name;
    }

    public int getCoreNum(){
        return coreNum;
    }

    public int getPrice(){
        return price;
    }

    public void display(){
        System.out.println("CPU: " + name + " " + coreNum + " " + price);
    }
}
