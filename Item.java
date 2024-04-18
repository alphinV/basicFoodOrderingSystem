public class Item{
    private int id;
    private String dish;
    private double price;

    public Item(int id, String dish, double price){
        this.id = id;
        this.dish = dish;
        this.price = price;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String toString() {
        return "Item: " + dish + ", Price: $" + price;
    }
    
}