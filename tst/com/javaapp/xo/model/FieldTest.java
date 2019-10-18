package com.javaapp.xo.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getFieldSize() {

        final Field field = new Field();

        assertEquals(3, field.getFieldSize());
    }

    @Test
    public void setFigure() {

        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure,actualFigure);
    }
}