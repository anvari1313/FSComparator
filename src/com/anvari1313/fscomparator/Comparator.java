package com.anvari1313.fscomparator;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Anvari1313 on 3/29/17.
 */
public class Comparator {
    private File path1;
    private File path2;

    private File[] path1NotCommon;
    private File[] path2NotCommon;
    private File[] common;

    public String getPath1() {
        return path1.getPath();
    }

    public void setPath1(String path1) {
        this.path1 = new File(path1);
    }

    public String getPath2() {
        return path2.getPath();
    }

    public void setPath2(String path2) {
        this.path2 = new File(path2);
    }

    public void compare(){
        ArrayList common = new ArrayList<File>();
        ArrayList notCommon1 = new ArrayList<File>();
        ArrayList notCommon2 = new ArrayList<File>();

        File[] listOfContentPath1 = path1.listFiles();
        File[] listOfContentPath2 = path2.listFiles();
        boolean[] notCommon1Flags = new boolean[listOfContentPath2.length];
        Arrays.fill(notCommon1Flags, false);
        boolean[] notCommon2Flags = new boolean[listOfContentPath2.length];
        Arrays.fill(notCommon2Flags, false);

        int r = 0;
        for (File file1 : listOfContentPath1) {
            int index = 0;

            for (File file2 : listOfContentPath2) {
                if (file1.getName().equals(file2.getName())) {
                    common.add(file1);
                }else{
                    if(!notCommon1Flags[r]){
                        notCommon1.add(file2);
                        notCommon1Flags[r] = true;
                    }
                    if(!notCommon2Flags[index]){
                        notCommon2.add(file2);
                        notCommon2Flags[index] = true;
                    }
                }
                index++;
            }

            r++;
        }

        this.common         = (File[])common.toArray(new File[common.size()]);
        this.path1NotCommon = (File[])notCommon1.toArray(new File[notCommon1.size()]);
        this.path2NotCommon = (File[])notCommon2.toArray(new File[notCommon2.size()]);
    }

    public String[] getPath1NotCommonFile(){
        return null;
    }

    public String[] getPath1NotCommonDirectory(){
        return null;
    }

    public String[] getPath2NotCommonFile(){
        return null;
    }

    public String[] getPath2NotCommonDirectory(){
        return null;
    }

    public String[] getPath1NotCommonContent(){
        String[] res = new String[this.path1NotCommon.length];

        for (int i = 0; i < path1NotCommon.length; i++) {
            res[i] = path1NotCommon[i].getPath();
        }

        return res;
    }

    public String[] getPath2NotCommonContent(){
        String[] res = new String[this.path2NotCommon.length];

        for (int i = 0; i < path2NotCommon.length; i++) {
            res[i] = path2NotCommon[i].getPath();
        }

        return res;
    }

    public String[] getPathCommonContent(){
        String[] res = new String[this.common.length];

        for (int i = 0; i < common.length; i++) {
            res[i] = common[i].getPath();
        }

        return res;
    }
}
