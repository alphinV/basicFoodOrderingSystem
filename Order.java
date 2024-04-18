public class Order{
    private String name;
    private String payment;
    private double time;

    public Order(String name, String payment, double time){
        this.name = name;
        this.payment = payment;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", payment='" + payment + '\'' +
                ", time=" + time +
                '}';
    }
}
