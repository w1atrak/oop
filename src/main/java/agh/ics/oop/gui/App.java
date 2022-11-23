package agh.ics.oop.gui;

import agh.ics.oop.*;
import agh.ics.oop.MapBoundary.*;
import agh.ics.oop.GrassField.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class App extends Application {
    GrassField map;

    public void init(){
        String[] args = getParameters().getRaw().toArray(new String[0]);
        String[] input = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f"}; // (2,0) S  oraz (3,5) N
        if (args.length == 0) {
            args = input;
        }

        MoveDirection[] directions = new OptionsParser().parse(args);
        this.map = new GrassField(10);

        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }

    public void start(Stage primaryStage){

        GridPane grid = new GridPane();
        Vector2d lowerLeft = this.map.getLowerLeft();
        Vector2d upperRight = this.map.getUpperRight();

        grid.getColumnConstraints().add(new ColumnConstraints(25));   //
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.setGridLinesVisible(true);



        for (int i = upperRight.y + 1; i >= lowerLeft.y; i--){
            for (int j = lowerLeft.x-1; j <= upperRight.x; j++){
                if (i== upperRight.y + 1 && j == lowerLeft.x -1){
                    Label label = new Label("y/x");
                    GridPane.setHalignment(label, HPos.CENTER);
                    grid.add(label,0,0,1,1);
                }
                else if (i == upperRight.y+1){
                    Label label = new Label(Integer.toString(j));
                    GridPane.setHalignment(label, HPos.CENTER);
                    grid.add(label,j-lowerLeft.x+1,0,1,1);
                    grid.getColumnConstraints().add(new ColumnConstraints(30));
                }
                else if (j == lowerLeft.x -1){
                    Label label = new Label(Integer.toString(i));
                    GridPane.setHalignment(label, HPos.CENTER);
                    grid.add(label,0,upperRight.y-i+1,1,1);
                    grid.getRowConstraints().add(new RowConstraints(30));
                }
                else{
                    if(map.isOccupied(new Vector2d(j,i))){
                        Label labelObject = new Label(map.objectAt(new Vector2d(j,i)).toString());
                        grid.add(labelObject,j-lowerLeft.x+1,upperRight.y-i+1,1,1);
                        GridPane.setHalignment(labelObject, HPos.CENTER);

                    }
                }

            }
        }
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
