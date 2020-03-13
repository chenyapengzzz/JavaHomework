package mainBoard;

public abstract class MainBoard {
    private String name;
    private String speed;
    private int price;

    public MainBoard(String name , String speed , int price){
        this.name = name;
        this.speed = speed;
        this.price = price;
    }

    abstract public void work();

    public String getName(){
        return name;
    }

    public String getSpeed(){
        return speed;
    }

    public int getPrice(){
        return price;
    }

    public void display(){
        System.out.println("MainBoard: " + name + " " + speed + " " + price);
    }
}
