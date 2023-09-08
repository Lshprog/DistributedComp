package org.example.ui;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class UI {

    private JFrame jFrame;

    private JSlider jSlider;

    private JButton start1;

    private JButton start2;

    private JButton stop1;

    private JButton stop2;

    public UI() {
        this.setUp();
    }

    private void setUp(){
        this.jFrame = new JFrame("Threads");
        this.jFrame.setLayout(new FlowLayout());
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrame.setSize(500, 600);

        this.jSlider = new JSlider(0, 100, 50);

        this.jSlider.setPaintTrack(true);
        this.jSlider.setPaintTicks(true);
        this.jSlider.setPaintLabels(true);

        this.jSlider.setMajorTickSpacing(10);
        this.jSlider.setMinorTickSpacing(2);


        this.start1 = new JButton("ПУСК 1");
        this.start2 = new JButton("ПУСК 2");
        this.stop1 = new JButton("СТОП 1");
        this.stop2 = new JButton("СТОП 2");

        JPanel newPanel = new JPanel(new GridBagLayout());
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setPreferredSize(new Dimension(400, 100));
        panel2.setPreferredSize(new Dimension(400, 100));
        panel3.setPreferredSize(new Dimension(400, 100));

        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));

        panel1.add(jSlider);
        panel3.add(start1);
        panel3.add(stop1);
        panel3.add(start2);
        panel3.add(stop2);


        verticalPanel.add(panel1);
        verticalPanel.add(panel2);
        verticalPanel.add(panel3);

        this.jFrame.add(verticalPanel);

        this.jFrame.pack();

    }

    public synchronized void updateSliderValue(int value) {

        this.jSlider.setValue(value);

    }

    public void setUiVisible() {
        this.jFrame.setVisible(true);
    }

    public void setStartActionListenerStart1(ActionListener actionListener) {
        this.start1.addActionListener(actionListener);
    }

    public void setStartActionListenerStart2(ActionListener actionListener) {
        this.start2.addActionListener(actionListener);
    }

    public void setStartActionListenerStop1(ActionListener actionListener) {
        this.stop1.addActionListener(actionListener);
    }

    public void setStartActionListenerStop2(ActionListener actionListener) {
        this.stop2.addActionListener(actionListener);
    }

}
