package com.pilot.demo.domain.services;

import com.pilot.demo.domain.interfaces.TrackerInterface;

public class Tracker implements TrackerInterface {
    private String message;

    public Tracker(String message) {
        this.message = message;
    }

    public void stt() {
        System.out.println(this.message);
    }

}
