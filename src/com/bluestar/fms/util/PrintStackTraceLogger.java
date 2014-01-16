package com.bluestar.fms.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintStackTraceLogger {

    public static String getStackTrace(Exception e)
    {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }

}
