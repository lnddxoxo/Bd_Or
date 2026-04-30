public class Classroom {
    private String building;
    private String room_no;
    private int capacity;

    public Classroom(String building, String room_no, int capacity) {
        this.building = building;
        this.room_no = room_no;
        this.capacity = capacity;
    }

    public String getBuilding() { return building; }
    public String getRoomNo()   { return room_no; }
    public int getCapacity()    { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getCapacityLevel() {
        if (capacity < 30)       return "Petite";
        else if (capacity < 100) return "Moyenne";
        else                     return "Grande";
    }

    public void modifierCapacite(int nombre) {
        this.capacity += nombre;
    }

    @Override
    public String toString() {
        return "Classroom[" + building + ", " + room_no +
                ", " + capacity + ", " + getCapacityLevel() + "]";
    }
}