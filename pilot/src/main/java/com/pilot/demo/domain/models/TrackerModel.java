package com.pilot.demo.domain.models;

import java.util.ArrayList;

public record TrackerModel(
    String rawMessage, 
    String rabbitMessage,
    String date,
    ArrayList<String> tasks
) {}
