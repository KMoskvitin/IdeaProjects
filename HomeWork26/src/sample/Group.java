package sample;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Group extends BaseObject {

    private List<BaseObject> list = new ArrayList<BaseObject>();

    public Group(int x, int y, GraphicsContext gc, List<BaseObject> obj) {
        super(gc, x, y);
    }

    public boolean isTouched(double mouseX, double mouseY) {
        for (BaseObject aList : list) {
            if (aList.isTouched(mouseX, mouseY)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setDraw() {
        for (BaseObject aList : list) {
            aList.setDraw();
        }
    }

    @Override
    public void draw() {
        for (BaseObject aList : list) {
            aList.draw();
        }
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

    public void increaseSize() {
        for (BaseObject aList : list) {
            aList.increaseSize();
        }
    }

    public void reduceSize() {
        for (BaseObject aList : list) {
            aList.reduceSize();
        }
    }

    public List<BaseObject> getList() {
        return list;
    }


    public void addToGroup(BaseObject model) {
        list.add(model);
    }

    public void addAllGroupElementsToGroup(List<BaseObject> list) {
        this.list.addAll(list);
    }


}
