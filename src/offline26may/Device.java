package offline26may;

public abstract class Device {
    public static final int bios = 512;
    private String model;
    private int memory;

    public Device() {
    }

    public Device(String model, int memory) {
        this.model = model;
        this.memory = memory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public abstract void start();

    public final void shutdown() {
        System.out.println("shutting down");
    }

}
