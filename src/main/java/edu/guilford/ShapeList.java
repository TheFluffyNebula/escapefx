package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

//shapeList is a list of shapes so let's have it extend ArrayList<Shape>
public class ShapeList extends ArrayList<Shape> {
    // Instantiate a Random object
    Random rand = new Random();

    // Method to return random color with any possible value
    public Color getRandomColor() {
        // return a random color with any possible value
        // red, green, blue, alpha (opacity between 0 adn 1)
        return Color.color(rand.nextDouble(), rand.nextDouble(),
                rand.nextDouble(), rand.nextDouble());
    }

    // constructor to add random shapes to the list
    public ShapeList() {
        super();
        // init empty arrayList
    }

    // method to return a random shape
    // modify so that we don't get a random shape
    public Shape getRandomShape() {
        int shapeChoice = rand.nextInt(5);
        switch (shapeChoice) {
            case 0:
                // centerX, centerY, radius
                Circle circle = new Circle(rand.nextDouble() * 800,
                        rand.nextDouble() * 600, rand.nextDouble() * 100);
                return circle;
            case 1:
                // generate a new ellipse
                Ellipse ellipse = new Ellipse(
                rand.nextDouble() * 800, rand.nextDouble() * 600, 
                rand.nextDouble() * 100, rand.nextDouble() * 100);
                // set fill color to random
                ellipse.setFill(getRandomColor());
                return ellipse;
            case 2:
                // generate random rectangle
                Rectangle rectangle = new Rectangle(
                rand.nextDouble() * 800, rand.nextDouble() * 600,
                rand.nextDouble() * 100, rand.nextDouble() * 100);
                // set the fill color to a random color
                rectangle.setFill(getRandomColor());
                return rectangle;
            case 3:
                Line line = new Line(
                rand.nextDouble() * 800, rand.nextDouble() * 600,
                rand.nextDouble() * 800, rand.nextDouble() * 600);
                // set the fill color to a random color
                line.setFill(getRandomColor());
                line.setStrokeWidth(rand.nextInt(10) + 2);
            case 4:
            // generate a random polygon with 3 to 10 sides
                int nSides = rand.nextInt(8) + 3;
            // create an array of doubles to hold the x and y coordinates
                double[] vertices = new double[nSides * 2];
            // fill the array with random x and y coordinates
                for (int i = 0; i < nSides * 2; i++) {
                    vertices[i] = rand.nextDouble() * 800;
                }
                Polygon polygon = new Polygon(vertices);
                // set the fill color to a random color
                polygon.setFill(getRandomColor());
                return polygon;
            default:
                return null;
        }
    }

    // add a toString method() to return a string representation of this list

    @Override
    public String toString() {
        // go through list, pring out something relevant about each shape
        StringBuilder s = new StringBuilder();

        // asking each kind of shape to do something, each shape responds in a different way
        // example of *polymorphism*
        // instanceof is a keyword that checks if an object is an instance of a specified class
        // using instance of is an example of object reflection
        for (Shape shape: this) {
            if (shape instanceof Circle) {
                // tell java the shape we're looking at is a circle via cast
                // way of removing the cast from everything else
                Circle circle = (Circle)shape;
                s.append("Circle: ");
                s.append("Center: ");
                s.append(circle.getCenterX());
                s.append(", ");
                s.append(circle.getCenterY());
                s.append(" Radius: ");
                s.append(circle.getRadius());
                s.append("\n");
            } else if (shape instanceof Ellipse) {
                s.append("Ellipse: ");
                s.append("Center: ");
                s.append(((Ellipse) shape).getCenterX());
                s.append(", ");
                s.append(((Ellipse) shape).getCenterY());
                s.append(" Radius: ");
                s.append(((Ellipse) shape).getRadiusX());
                s.append(", ");
                s.append(((Ellipse) shape).getRadiusY());
                s.append("\n");
            } else if (shape instanceof Rectangle) {
                s.append("Rectangle: ");
                s.append("Upper Left: ");
                s.append(((Rectangle) shape).getX());
                s.append(", ");
                s.append(((Rectangle) shape).getY());
                s.append(" Width: ");
                s.append(((Rectangle) shape).getWidth());
                s.append(" Height: ");
                s.append(((Rectangle) shape).getHeight());
                s.append("\n");
            } else if (shape instanceof Line) {
                s.append("Line: ");
                s.append("Start: ");
                s.append(((Line) shape).getStartX());
                s.append(", ");
                s.append(((Line) shape).getStartY());
                s.append(" End: ");
                s.append(((Line) shape).getEndX());
                s.append(", ");
                s.append(((Line) shape).getEndY());
                s.append("\n");
            } else if (shape instanceof Polygon) {
                s.append("Polygon: ");
                s.append("Vertices: ");
                for (int i = 0; i < ((Polygon) shape).getPoints().size(); i++) {
                    s.append(((Polygon) shape).getPoints().get(i));
                    s.append(", ");
                }
                s.append("\n");
            } else {
                s.append("Unknown Shape\n");
            }
        }
        return s.toString();
    }
}
