package com.fms.common.logging;

import org.apache.log4j.*;

import java.util.Locale;


/**
 * 
 *
 * @author prakash.harigopal
 * 
 */
public class AuditLevel
    extends Level {
    //~ Static variables/initializers ------------------------------------------

    /**
     * Value of my trace level. This value is lesser than {@link
     * org.apache.log4j.Priority#DEBUG_INT} and higher than {@link
     * org.apache.log4j.Level#TRACE_INT}
     */
    public static final int AUDIT_LEVEL_INT = DEBUG_INT + 10;

    /** {@link Level} representing my log level */
    public static final Level AUDIT_LEVEL =
        new AuditLevel(AUDIT_LEVEL_INT, "AUDIT_LEVEL", 7);

    /**  */
    private static final long serialVersionUID = 4293563692977038285L;

    //~ Constructors -----------------------------------------------------------

/**
     * Constructor
     *
     * @param arg0
     * @param arg1
     * @param arg2
     */
    protected AuditLevel(
        final int    arg0,
        final String arg1,
        final int    arg2) {
        super(arg0, arg1, arg2);
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Checks whether sArg is "AUDIT_LEVEL" level. If yes then returns {@link
     * AuditLevel#AUDIT_LEVEL}, else calls {@link AuditLevel#toLevel(String, Level)}
     * passing it {@link Level#DEBUG} as the defaultLevel.
     *
     * @param sArg DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @see Level#toLevel(java.lang.String)
     * @see Level#toLevel(java.lang.String, org.apache.log4j.Level)
     */
    public static Level toLevel(final String sArg) {
        if (
            (sArg != null)
            && sArg.toUpperCase(Locale.getDefault()).equals("AUDIT_LEVEL")) {
            return AUDIT_LEVEL;
        }

        return (Level) toLevel(sArg, Level.DEBUG);
    }


    /**
     * Checks whether val is {@link AuditLevel#AUDIT_LEVEL_INT}. If yes then
     * returns {@link AuditLevel#AUDIT_LEVEL}, else calls {@link AuditLevel#toLevel(int,
     * Level)} passing it {@link Level#DEBUG} as the defaultLevel
     *
     * @param val DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @see Level#toLevel(int)
     * @see Level#toLevel(int, org.apache.log4j.Level)
     */
    public static Level toLevel(final int val) {
        if (val == AUDIT_LEVEL_INT) {
            return AUDIT_LEVEL;
        }

        return (Level) toLevel(val, Level.DEBUG);
    }


    /**
     * Checks whether val is {@link AuditLevel#AUDIT_LEVEL_INT}. If yes then
     * returns {@link AuditLevel#AUDIT_LEVEL}, else calls {@link Level#toLevel(int,
     * org.apache.log4j.Level)}
     *
     * @see Level#toLevel(int, org.apache.log4j.Level)
     */
    public static Level toLevel(
        final int   val,
        final Level defaultLevel) {
        if (val == AUDIT_LEVEL_INT) {
            return AUDIT_LEVEL;
        }

        return Level.toLevel(val, defaultLevel);
    }


    /**
     * Checks whether sArg is "AUDIT_LEVEL" level. If yes then returns {@link
     * AuditLevel#AUDIT_LEVEL}, else calls {@link Level#toLevel(java.lang.String,
     * org.apache.log4j.Level)}
     *
     * @see Level#toLevel(java.lang.String, org.apache.log4j.Level)
     */
    public static Level toLevel(
        final String sArg,
        final Level  defaultLevel) {
        if (
            (sArg != null)
            && sArg.toUpperCase(Locale.getDefault()).equals("AUDIT_LEVEL")) {
            return AUDIT_LEVEL;
        }

        return Level.toLevel(sArg, defaultLevel);
    }
}
