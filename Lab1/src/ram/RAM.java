package ram;

public abstract class RAM {
    private String name;
    private String volume;
    private int price;

    public RAM(String name , String volume , int price){
        this.name = name;
        this.volume = volume;
        this.price = price;
    }

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
        System.out.println("RAM: " + name + " " + volume + " " + price);
    }

    abstract public void work();
}
