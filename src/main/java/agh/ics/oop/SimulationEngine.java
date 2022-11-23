package agh.ics.oop;

import agh.ics.oop.*;

import javax.swing.*;
import java.awt.*;

public class SimulationEngine extends Component implements IEngine {

    MoveDirection[] directions;
    GrassField map;
    Vector2d[] positions;

    public SimulationEngine(MoveDirection[] directions, GrassField map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;

        for(Vector2d postition : this.positions){
            if((this.map.canMoveTo(postition) && !this.map.isOccupied(postition)) || this.map.occupiedByGrass(postition)){
                MapObject animal = new Animal(this.map, postition);
                map.place(animal);
            }
            else{
                throw new IllegalArgumentException(postition.toString() + " isn't a valid position to place an object");
            }
        }

    }

    public void run(){
        String te = map.toString();
        JFrame f = new JFrame();
        JTextArea t = new JTextArea(te);
        t.setBounds(200, 200, 400, 400);
        f.setSize(600, 600);
        f.setVisible(true);
        f.add(t);


        int size = this.map.animals.size();


        Animal[] anims = new Animal[size];
        int j = 0;
        for(var entry : this.map.animals.entrySet()){
            anims[j] = entry.getValue();
            j++;
        }

        for(int i = 0; i < directions.length; i++){


            anims[i%size].move(this.directions[i]);
            try {
                Thread.sleep(0);

                t.setText(this.map.toString() + "\n" + "Animal " + String.valueOf(1+i%size));

            }catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this,ex);
            }
        }

      //  for (int i = 0; i < this.directions.length; i++) {
        //    this.map.animals.get(i%size).move(this.directions[i]);
       // }







        //System.out.println(map.toString());
    }


}
