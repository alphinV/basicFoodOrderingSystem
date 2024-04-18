public class Delivery extends Order{
    private String address;

    public Delivery(String name, String payment, double time, String address){
        super(name,payment,time);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Delivery { " +
                "name='" + getName() + '\'' +
                ", payment='" + isPayment() + '\'' +
                ", time=" + getTime() +
                ", address='" + address + '\'' +
                " }";
    }

}