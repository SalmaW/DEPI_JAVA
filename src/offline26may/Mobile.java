package offline26may;

public class Mobile extends Device{

    private String camera;

    public Mobile() {
    }


    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public void gps(){
        System.out.println("fetching location");
    }

    @Override
    public void start() {
//        super.start();
        System.out.println("starting mobile");
    }
}
