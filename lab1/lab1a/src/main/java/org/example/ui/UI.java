package org.example.ui;

import org.example.common.MyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class UI {

    private JFrame jFrame;

    private JSlider jSlider;

    private JSpinner jSpinner1;

    private JSpinner jSpinner2;

    private JButton start;

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

        SpinnerModel sm1 = new SpinnerNumberModel(1, 1, 10, 1);
        SpinnerModel sm2 = new SpinnerNumberModel(1, 1, 10, 1);

        this.jSpinner1 = new JSpinner(sm1);
        this.jSpinner2 = new JSpinner(sm2);

        this.start = new JButton("Пуск");

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
        panel2.add(jSpinner1);
        panel2.add(jSpinner2);
        panel3.add(start);


        verticalPanel.add(panel1);
        verticalPanel.add(panel2);
        verticalPanel.add(panel3);

        this.jFrame.add(verticalPanel);

        this.jFrame.pack();

    }

    public synchronized void updateSliderValue(int value) {
        int curv = this.jSlider.getValue();

        if(curv + value < 90 && curv + value > 10)
            this.jSlider.setValue(this.jSlider.getValue() + value);

    }

    public void setUiVisible() {
        this.jFrame.setVisible(true);
    }


    public void setjSpinner1ChangeListener(ChangeListener myChangeListener) {

        this.jSpinner1.addChangeListener(myChangeListener);

    }
    public void setjSpinner2ChangeListener(ChangeListener myChangeListener) {

        this.jSpinner2.addChangeListener(myChangeListener);

    }

    public void setStartActionListener(ActionListener actionListener) {
        this.start.addActionListener(actionListener);
    }

}
