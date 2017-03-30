package com.anvari1313.fscomparator;

import com.anvari1313.fscomparator.gui.MainFrame;

import java.io.File;

/**
 * Created by ahmad on 3/29/17.
 */
public class FSComparator {
    public static void main(String[] args) {
        Comparator comparator = new Comparator();
        MainFrame mainFrame = new MainFrame(comparator);

        comparator.setPath1("/home/ahmad/Untitled Folder/folder1");
        comparator.setPath2("/home/ahmad/Untitled Folder/folder2");

        comparator.compare();

        String[] notCommon1 = comparator.getPath1NotCommonContent();
        String[] notCommon2 = comparator.getPath2NotCommonContent();
        String[] common     = comparator.getPathCommonContent();

        System.out.println("Not Common 1 :");
        for (String s : notCommon1) {
            System.out.println(s);
        }

        System.out.println("Not Common 2 :");
        for (String s : notCommon2) {
            System.out.println(s);
        }

        System.out.println("Common :");
        for (String s : common) {
            System.out.println(s);
        }
    }
}
