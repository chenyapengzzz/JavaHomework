package hardDisk;

public abstract class HardDisk {
    private String name;
    private String volume;
    private int price;

    public HardDisk(String name , String volume , int price){
        this.name = name;
        this.volume = volume;
        this.price = price;
    }

    abstract public void work();

    public String getName(){
        return name;
    }

    public String getVolume(){
        return volume;
    }

    public int getPrice(){
        return price;
    }

    public void display(){
        System.out.println("HardDisk: " + name + " " + volume + " " + price);
    }
}
