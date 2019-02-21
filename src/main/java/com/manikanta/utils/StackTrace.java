package com.manikanta.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Manikanta Tummalapenta on 21 Feb 2019
 */
public class StackTrace {

    public static String print(Exception ex) {

        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));

        return sw.toString();
    }
}
