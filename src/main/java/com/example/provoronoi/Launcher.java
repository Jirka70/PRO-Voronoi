package com.example.provoronoi;


import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        Application.launch(VoronoiApp.class);
    }
}
