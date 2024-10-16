package com.pilot.demo.domain.models;

import com.pilot.demo.domain.interfaces.TrackerFox23Interface;

public class TrackerFox23Model implements TrackerFox23Interface {
    private String message;

    public TrackerFox23Model(String message) {
        this.message = message;
    }

    public void pos() {
        System.out.println(this.message);
    }

}
