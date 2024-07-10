package offline26may;

public class Laptop extends Device {
    private int battery;

    public Laptop() {
    }


    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public void compute() {
        System.out.println("computing");
    }

    @Override
    public void start() {
//        super.start();
        System.out.println("starting laptop");
    }
}
