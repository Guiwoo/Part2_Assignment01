package com.zerobase.fastlms.admin;

import java.io.File;

public class Testing {
    public static void main(String[] args) {
        File file = new File("");
        String currentpath = file.getAbsolutePath()+"/src/main/resources";
        System.out.println(currentpath);
    }
}
