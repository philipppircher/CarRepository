package cc.car.phil;

public class DrivingMirror {
    // Membervariables
    //
    private int position;

    // Constructor
    //
    public DrivingMirror(int position) {
        setPosition(position);
    }

    // Getter - Setter
    //
    public void setPosition(int position) {
        if (position >= 25 && position <= 75){
            this.position = position;
        }
        else {
            this.position = 50;     // Centered
        }
    }

    public int getPosition() {
        return position;
    }
}
