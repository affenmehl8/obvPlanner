package com.example.obvplanner;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Timer;

public class Quest implements Serializable {
    public String title;
    public String description;
    public double longitude;
    public double latitude;
    public boolean active;
    //private Timestamp start;
    //private Timestamp end;

    public Quest(String title, String description, double longitude, double latitude) {
        this.title = title;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        active = true;
    }
}
