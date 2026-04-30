public class TimeSlot {
    private String time_slot_id;
    private String day_ts;
    private String start_time;
    private String end_time;

    public TimeSlot(String time_slot_id, String day_ts,
                    String start_time, String end_time) {
        this.time_slot_id = time_slot_id;
        this.day_ts = day_ts;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public String getTimeSlotId() { return time_slot_id; }
    public String getDayTs()      { return day_ts; }
    public String getStartTime()  { return start_time; }
    public String getEndTime()    { return end_time; }
    public void setEndTime(String end_time) { this.end_time = end_time; }

    public String getDuree() {
        return "De " + start_time + " a " + end_time;
    }

    @Override
    public String toString() {
        return "TimeSlot[" + time_slot_id + ", " + day_ts +
                ", " + getDuree() + "]";
    }
}