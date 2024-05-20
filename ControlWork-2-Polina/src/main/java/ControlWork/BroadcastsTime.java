package ControlWork;


import java.util.Comparator;

public class BroadcastsTime implements Comparable<BroadcastsTime> {
    private byte hour;
    private byte minute;

    BroadcastsTime(byte hour, byte minute) {
        this.hour = hour;
        this.minute = minute;
    }

    BroadcastsTime(String t) {
        String[] time = t.split(":");
        this.hour = Byte.parseByte(time[0]);
        this.minute = Byte.parseByte(time[1]);
    }


    @Override
    public int compareTo(BroadcastsTime o) {
        if (this.hour != o.hour) {
            return Byte.compare(this.hour, o.hour);//если this позже, то 1, если одновременно, то 0, если раньше, то -1
        } else {
            return Byte.compare(this.minute, o.minute);
        }
    }

    public boolean after(BroadcastsTime t) {
        return this.compareTo(t) > 0;
    }

    public boolean befor(BroadcastsTime t){
        return this.compareTo(t) < 0;
    }
    public boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        return !this.befor(t1) && !this.after(t2);
    }

    public String toString() {
        return this.hour + ":" + this.minute;
    }
}
