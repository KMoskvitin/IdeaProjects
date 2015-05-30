package sample;

import javafx.scene.canvas.GraphicsContext;

public abstract class BaseObject implements Shape{

    public static final int CANVAS_X = 1200;
    public static final int CANVAS_Y = 700;
    public static final int SIZE = 40;
    public final int MAX_SIZE = 100;
    public final int MIN_SIZE = 5;
    public static final int STEPMOVE = 5;

    GraphicsContext gc;
    public static int x;
    public static int y;
    protected int size = 30;

    public BaseObject(GraphicsContext gc, int x, int y) {
        this.gc = gc;
        this.x = x;
        this.y = y;
    }
    public void moveUp() {
        y -= STEPMOVE;
        if (y <= 0) {
            y = 0;
        }
    }

    public void moveDown() {
        y += STEPMOVE;
        if (y >= CANVAS_Y - SIZE) {
            y = CANVAS_Y - SIZE;
        }
    }

    public void moveLeft() {
        x -= STEPMOVE;
        if (x <= 0) {
            x = 0;
        }
    }

    public void moveRight() {
        x += STEPMOVE;
        if (x >= CANVAS_X - SIZE) {
            x = CANVAS_X - SIZE;
        }
    }

    public void increaseSize() {
        size += STEPMOVE;
        if (size > MAX_SIZE) {
            size = MAX_SIZE;
        }
    }

    public void reduceSize() {
        size -= STEPMOVE;
        if (size < MIN_SIZE) {
            size = MIN_SIZE;
        }
    }

    public abstract boolean isTouched(double clickX, double clickY);

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }


    public abstract void setDraw();


    public abstract void draw();

    public abstract int size();
}
