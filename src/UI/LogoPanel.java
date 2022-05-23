package UI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LogoPanel extends JPanel implements Runnable{
    private List<JLabel> states;
    private Iterator<JLabel> it;
    public static Thread thread;

    public LogoPanel() {
        JLabel state0 = new JLabel(new ImageIcon("pics/beer-0.png"));
        JLabel state1 = new JLabel(new ImageIcon("pics/beer-1.png"));
        JLabel state2 = new JLabel(new ImageIcon("pics/beer-2.png"));
        JLabel state3 = new JLabel(new ImageIcon("pics/beer-3.png"));


        states = Collections.synchronizedList(new ArrayList<JLabel>());

        states.add(state0);
        states.add(state1);
        states.add(state2);
        states.add(state3);


        it = states.iterator();

        thread = new Thread(this);
        thread.start();


    }

    public void run(){
        while (true){
            try{
                removeAll();
                add(it.next());
                if(!it.hasNext()) it = states.iterator();
                repaint();
                revalidate();
                Thread.sleep(1000);
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
    }









}
