package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends BaseObject {
    public Rect(GraphicsContext gc, int x, int y) {
        super(gc, x, y);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= x + size) && (clickX >= x) && (clickY <= y + size) && (clickY >= y)) {
            return true;
        }
        return false;
    }

    @Override
    public void setDraw() {

    }

    @Override
    public void draw() {
        gc.setFill(Color.BLUE);
        gc.fillRect(10, 10, SIZE, SIZE);
    }

    @Override
    public void dec() {

    }

    @Override
    public void inc() {

    }

    @Override
    public void setActive(boolean active) {

    }

    @Override
    public Shape copy() {
        return null;
    }

    @Override
    public boolean consistPoint(int sceneX, int sceneY) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
