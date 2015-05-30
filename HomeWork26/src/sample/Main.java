package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static final int CANVAS_X = 1200;
    public static final int CANVAS_Y = 700;

    private GraphicsContext gc;
    public int index;

    public BaseObject obj;

    private List<BaseObject> list = new ArrayList<BaseObject>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Home Work 26");

        final Canvas canvas = new Canvas(CANVAS_X, CANVAS_Y);
        final BorderPane group = new BorderPane(canvas);
        final Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();

        gc = canvas.getGraphicsContext2D();
        registerOnKeyPresseedListener(scene);
        registerOnMousePressListener(scene);

    }

    public void registerOnKeyPresseedListener(final Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                cleare();
                switch (event.getCode()) {
                    case UP:
                        obj.moveUp();
                        break;
                    case DOWN:
                        obj.moveDown();
                        break;
                    case LEFT:
                        obj.moveLeft();
                        break;
                    case RIGHT:
                        obj.moveRight();
                        break;
                    case DIGIT1:
                        addOval();
                        break;
                    case DIGIT2:
                        addTriangle();
                        break;
                    case DIGIT3:
                        addRect();
                        break;
                    case PAGE_DOWN:
                        next();
                        break;
                    case PAGE_UP:
                        previous();

                }
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).draw();
                }
            }
        });

    }

    public void registerOnMousePressListener(Scene scene) {
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isControlDown()) {
                    Group group1 = new Group( BaseObject.getX(), BaseObject.getY(), gc, list);
                    for (int i = 0; i < obj.size(); i++) {
                        if (list.get(i).isTouched(event.getSceneX(), event.getSceneY())) {
                            BaseObject current = list.get(index);
                            BaseObject selected = list.get(i);
                            if (current == selected) {
                                return;
                            }
                            if (current instanceof Group && selected instanceof Group) {
                                Group group2 = new Group(BaseObject.getX(), BaseObject.getY(), gc, list);
                                group2.addAllGroupElementsToGroup(((Group) selected).getList());
                                group2.addAllGroupElementsToGroup(((Group) current).getList());
                                group1 = group2;
                                group1.draw();
                            } else {
                                group1.addToGroup(current);
                                group1.addToGroup(selected);
                                group1.draw();
                            }
                            list.remove(current);
                            list.remove(selected);
                        }
                    }
                    list.add(group1);
                    index = list.size() - 1;
                    obj = list.get(index);
                }
            }
        });
    }


    public void addOval() {
        obj = new Oval(gc, 30, 30);
        list.add(obj);
        index = list.size() - 1;
    }

    public void addTriangle() {
        obj = new Triangle(gc, 30, 30);
        list.add(obj);
        index = list.size() - 1;
    }

    public void addRect() {
        obj = new Rect(gc, 30, 30);
        list.add(obj);
        index = list.size() - 1;
    }

    private void previous() {
        index--;
        if (index < 0) {
            index = 0;
        }
        obj = list.get(index);
    }

    public void next() {
        index++;
        if (index > list.size() - 1) {
            index = list.size() - 1;
        }
        obj = list.get(index);
    }

    public void cleare() {
        gc.clearRect(0, 0, CANVAS_X, CANVAS_Y);
    }

}