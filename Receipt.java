class Receipt {
    private Item item;
    private int quantity;

    public Receipt(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getPrice() {
        return item.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Dish: " + item.getDish() + " (Quantity: " + quantity + "), Price: $" + (item.getPrice() * quantity);
    }
}