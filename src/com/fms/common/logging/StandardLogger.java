package com.fms.common.logging;

import org.apache.log4j.Logger;


/**
 *@author prakash.harigopal
 */
public class StandardLogger {
    //~ Instance variables -----------------------------------------------------

    /** TODO DOCUMENT ME! */
    private Logger logger = null;

    //~ Constructors -----------------------------------------------------------

    /**
     * TODO Creates a new StandardLogger object.
     */
    public StandardLogger() {
        super();
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Method to find if trace is enabled
     *
     * @param debug DOCUMENT ME!
     */

    //public boolean isTraceEnabled(){
    //return log.is
    //}
    /**
     * Method to log debug statement
     *
     * @param debug DOCUMENT ME!
     */
    public void debug(final String debug) {
        logger.debug(debug);
    }


    /**
     * Method to log error statement
     *
     * @param error DOCUMENT ME!
     */
    public void error(final String error) {
        logger.error(error);
    }


    /**
     * Method to log error statement
     *
     * @param error DOCUMENT ME!
     * @param e DOCUMENT ME!
     */
    public void error(
        final String    error,
        final Exception e) {
        logger.error(error, e);
    }


    /**
     * Method to log fatal statement
     *
     * @param fatal DOCUMENT ME!
     */
    public void fatal(final String fatal) {
        logger.fatal(fatal);
    }


    /**
     * Method to log fatal statement
     *
     * @param fatal DOCUMENT ME!
     * @param e DOCUMENT ME!
     */
    public void fatal(
        final String    fatal,
        final Exception e) {
        logger.fatal(fatal, e);
    }


    //Create a new constructor with class name as parameter
    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Logger getLogger() {
        return logger;
    }


    /**
     * Method to log info statement
     *
     * @param info DOCUMENT ME!
     */
    public void info(final String info) {
        logger.info(info);
    }


    /**
     * Method to find if debug is enabled
     *
     * @return boolean
     */
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }


    /**
     * Method to find if info is enabled
     *
     * @return boolean
     */
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }


    /**
     * DOCUMENT ME!
     *
     * @param msg DOCUMENT ME!
     */
    public void logAuditLevel(final String msg) {
        logger.log(AuditLevel.AUDIT_LEVEL, msg);
    }


    /**
     * Method to log method entry
     *
     * @param methodName DOCUMENT ME!
     */
    public void methodEntry(final String methodName) {
        logger.debug("Entering method: " + methodName);
    }


    /**
     * Method to log method entry
     *
     * @param methodName DOCUMENT ME!
     */
    public void methodExit(final String methodName) {
        logger.debug("Exiting method: " + methodName);
    }


    /**
     * DOCUMENT ME!
     *
     * @param clazz DOCUMENT ME!
     */
    public void setLogger(final Class clazz) {
        this.logger = Logger.getLogger(clazz);
    }


    /**
     * DOCUMENT ME!
     *
     * @param trace DOCUMENT ME!
     */
    public void trace(final String trace) {
        logger.trace(trace);
    }


    /**
     * Method to log warn statement
     *
     * @param warn DOCUMENT ME!
     */
    public void warn(final String warn) {
        logger.warn(warn);
    }
}
