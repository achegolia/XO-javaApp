package com.javaapp.xo.model;

import com.javaapp.xo.model.exceptions.AlreadyOccupiedException;
import com.javaapp.xo.model.exceptions.InvalidPointException;
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
    public void setFigure() throws AlreadyOccupiedException, InvalidPointException {

        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void getFigureWhenFigureIsNotSet() throws InvalidPointException {

        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void getFigureWhenXIsLessThanZero() {

        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenYIsLessThanZero() {

        final Field field = new Field();
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenXIsMoreThanMaxFieldSize() {

        final Field field = new Field();
        final Point inputPoint = new Point(field.getFieldSize() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenYIsMoreThanMaxFieldSize() {

        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getFieldSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenAlreadyOccupied() throws AlreadyOccupiedException, InvalidPointException {

        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (AlreadyOccupiedException e) {}
    }
}