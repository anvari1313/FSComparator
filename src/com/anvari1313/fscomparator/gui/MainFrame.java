package com.anvari1313.fscomparator.gui;

import com.anvari1313.fscomparator.Comparator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ahmad on 3/29/17.
 */
public class MainFrame extends JFrame {
    private Comparator comparator;

    private DefaultListModel listModel1;
    private DefaultListModel listModel2;
    private JList list1;
    private JList list2;


    public MainFrame(Comparator comparator){
        this.setTitle("File System Comparator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.comparator = comparator;

        listModel1 = new DefaultListModel();
        listModel2 = new DefaultListModel();


        list1 = new JList(listModel1);
        list2 = new JList(listModel2);

        setSize(640,480);
        setLayout(new GridLayout(1, 2));
        add(list1);
        add(list2);
        setVisible(true);
    }

    public void addToList1(String item){
        listModel1.addElement(item);
    }

    public void addToList2(String item){
        listModel2.addElement(item);
    }
}
