package org.example.ui;

import org.example.common.MyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UI {

    private JFrame jFrame;

    private JSlider jSlider;

    private JSpinner jSpinner1;

    private JSpinner jSpinner2;

    private JButton start;

    // Dont know if i need it
    private final Object sliderLock = new Object();


    public UI() {
        this.setUp();
    }

    private void setUp(){
        this.jFrame = new JFrame("Threads");
        this.jFrame.setSize(500, 600);
        this.jSlider = new JSlider(10, 90, 50);

        SpinnerModel sm1 = new SpinnerNumberModel(1, 1, 10, 1);
        SpinnerModel sm2 = new SpinnerNumberModel(1, 1, 10, 1);

        this.jSpinner1 = new JSpinner(sm1);
        this.jSpinner2 = new JSpinner(sm2);

        this.start = new JButton("Start!");


        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                // Perform cleanup and close the application when the window is closed
//                // You can signal your thread to stop here
//                System.exit(0); // Exit the application
//            }
//        });

//        this.jFrame.add(this.jSlider);
//        this.jFrame.add(this.jSpinner1);
//        this.jFrame.add(this.jSpinner2);

        JPanel jPanel = new JPanel();
        jPanel.add(this.jSlider);
        jPanel.add(this.jSpinner1);
        jPanel.add(this.jSpinner2);

        this.jFrame.add(jPanel);

    }

//    public synchronized void setSliderValue(int value) {
//
//        jSlider.setValue(value);
//
//    }
//
//    public synchronized int getSliderValue() {
//
//        return jSlider.getValue();
//
//    }

    public synchronized void updateSliderValue(int value) {
        this.jSlider.setValue(this.jSlider.getValue() + value);
    }

    public Object getSliderLock() {
        return sliderLock; // Provide access to the shared lock object
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

}
