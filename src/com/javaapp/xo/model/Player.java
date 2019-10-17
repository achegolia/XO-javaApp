package com.javaapp.xo.model;

public class Player {

    private final String name;
    private final Figure figure;

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }

    public Player(final String name, final Figure figure) {
        this.name = name;
        this.figure = figure;
    }
}
