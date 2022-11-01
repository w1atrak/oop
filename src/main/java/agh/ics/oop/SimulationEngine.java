package agh.ics.oop;


import javax.swing.*;
import java.awt.*;

public class SimulationEngine extends Component implements IEngine {

    MoveDirection[] directions;
    RectangularMap map;
    Vector2d[] positions;

    public SimulationEngine(MoveDirection[] directions, RectangularMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;

        for(Vector2d postition : this.positions){
            if(this.map.canMoveTo(postition) && !this.map.isOccupied(postition)){
                Animal animal = new Animal(this.map, postition);
                map.place(animal);
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

        //f.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));

        int size = this.map.animals.size();
        for (int i = 0; i < this.directions.length; i++) {
            this.map.animals.get(i%size).move(this.directions[i]);

            try {
                Thread.sleep(800);
                t.setText(map.toString() + "\n" + "Animal " + String.valueOf(1+i%size));
            }catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this,ex);
            }

        }







        //System.out.println(map.toString());
    }


}
