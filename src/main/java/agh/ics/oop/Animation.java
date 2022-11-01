package agh.ics.oop;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Animation extends JPanel {
    int x = 0;
    int y = 100;
    int a = 400;
    int b = 200;

    public void paint(Graphics gp) {
        super.paint(gp);
        Graphics2D g2d = (Graphics2D) gp;
        g2d.setColor(Color.red);
        g2d.setFont(new Font("BOLD", BOLD, 35));

        g2d.drawString("Welcome TO", x, y);
        g2d.drawString("CodeGuid.Com", a, b);
        g2d.drawString("THANKS ", x, 300);
        try {
            Thread.sleep(200);
            x += 20;
            a -= 20;

            if (x > getWidth()) {

                x = 0;
            }
            if (a < 0) {

                a = 500;
            }
            repaint();

        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }


    }

    public static void main(String[] args) {

        JFrame jf = new JFrame();
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(new Animation());
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
