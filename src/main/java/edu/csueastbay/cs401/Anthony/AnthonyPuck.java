package edu.csueastbay.cs401.Anthony;

import edu.csueastbay.cs401.pong.Puckable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class AnthonyPuck extends Circle implements Puckable {

    public static final double STARTING_SPEED = 5.0;
    public static final int STARTING_RADIUS = 30;
    private final double fieldWidth;
    private final double fieldHeight;
    private String id;
    private Double speed;
    private Double direction;
    private Color color;
    private int radius;

    // Create starting puck
    public AnthonyPuck( double fieldWidth, double fieldHeight ) {
        super();
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.color = Color.WHITE;
        this.radius = STARTING_RADIUS;
        reset();
    }

    @Override
    public void reset() {
        Random random = new Random();
        setCenterX( fieldWidth / 2 );
        setCenterY( fieldHeight / 2 );
        setRadius( this.radius );
        setFill( color );

        setRadius(radius);
        speed = STARTING_SPEED;
        if (random.nextInt(2) == 0 ) {
            direction = ( random.nextDouble() * 90 ) - 45;
        } else {
            direction = ( random.nextDouble() * 90 ) + 115;
        }
    }

    // increase the puck speed when called by 1.5
    public void increaseSpeed(){ this.speed = ( 1.5 * this.speed ) ; }

    // reduce the size of the puck when called
    public void reduceRadius()
    {
        this.radius = ( int ) ( 0.75 * this.radius );
    }

    // increase radius of puck twice the size when called
    public void IncreaseRadius()
    {
        this.radius = ( int ) ( 2 * this.radius );
    }

    // randomly create changing colors of puck when called
    public void changeColor() {
        // Randomly assign a color to the puck
        Color[] newColors = { Color.PINK, Color.WHITE, Color.LIMEGREEN, Color.LIGHTBLUE };
        int colorIndex = ( int ) ( Math.random() * newColors.length );
        this.setColor( newColors[ colorIndex ] );
        this.reset();

    }

    // set color of starting puck
    public void setColor( Color color ) {
        this.color = color;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public void setID(String id) {
        this.id = id;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public double getDirection() {
        return direction;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void setDirection(double angle) {
        this.direction = angle;
    }

    @Override
    public void move() {
        double deltaX = speed * Math.cos(Math.toRadians(direction));
        double deltaY = speed * Math.sin(Math.toRadians(direction));
        setCenterX(getCenterX() + deltaX);
        setCenterY(getCenterY() + deltaY);
    }
}