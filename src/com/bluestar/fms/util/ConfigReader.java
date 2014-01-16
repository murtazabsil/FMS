package com.bluestar.fms.util;

import java.util.ResourceBundle;

public class ConfigReader {
    public static ResourceBundle readAppProperties() {
        ResourceBundle bundle = ResourceBundle.getBundle("com.bluestar.fms.resource.app");
        return bundle;
    }

    public static String getMastersConfig() {
        String mastersConfig = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            mastersConfig = bundle.getString("hb_masters_config");
        }

        return mastersConfig;
    }

    public static String getSenderMailId() {
        String senderMailId = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            senderMailId = bundle.getString("sender_mail_address");
        }

        return senderMailId;
    }

    public static String getMailTextMessage() {
        String textMessage = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            textMessage = bundle.getString("auto_generate_password_text_mail");
        }

        return textMessage;
    }

    public static String getPasswordTextMessage() {
        String textMessage = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            textMessage = bundle.getString("auto_generate_password_text");
        }

        return textMessage;
    }

    public static String getSmtpHostKey() {
        String smtpHostKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpHostKey = bundle.getString("mail.smtp.host_key");
        }

        return smtpHostKey;
    }

    public static String getSmtpHostUserName() {
        String smtpHostKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpHostKey = bundle.getString("mail.smtp.username");
        }

        return smtpHostKey;
    }

    public static String getSmtpHostPassword() {
        String smtpHostKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpHostKey = bundle.getString("mail.smtp.password");
        }

        return smtpHostKey;
    }

    public static String getDirectAgentEventCode() {
        String smtpHostKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpHostKey = bundle.getString("event.agent.directregistration");
        }

        return smtpHostKey;
    }

    public static String getAcceptAgentEventCode() {
        String smtpHostKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpHostKey = bundle.getString("event.agent.acceptregistration");
        }

        return smtpHostKey;
    }

    public static String getBooknigSuccessEventCode() {
        String smtpHostKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpHostKey = bundle.getString("event.booking.success");
        }

        return smtpHostKey;
    }

    public static String getBooknigFailerEventCode() {
        String smtpHostKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpHostKey = bundle.getString("event.booking.failer");
        }

        return smtpHostKey;
    }

    public static String getTravellerRegistrationEventCode() {
        String smtpHostKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpHostKey = bundle.getString("event.traveller.registration");
        }

        return smtpHostKey;
    }

    public static String getSecurityDepositEventCode() {
        String smtpHostKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpHostKey = bundle.getString("event.customer.finance.securitydeposit");
        }

        return smtpHostKey;
    }
    public static String getHotelEmailEventCode() {
        String smtpHostKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpHostKey = bundle.getString("event.hotel.reservation.mail");
        }

        return smtpHostKey;
    }
    
    public static String getSmtpHostKeyValue() {
        String smtpHostKeyValue = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpHostKeyValue = bundle.getString("mail.smtp.host_key_value");
        }

        return smtpHostKeyValue;
    }

    public static String getSmtpPortKey() {
        String smtpPortKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpPortKey = bundle.getString("mail.smtp.port_key");
        }

        return smtpPortKey;
    }

    public static String getSmtpPortKeyValue() {
        String smtpPortKeyValue = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpPortKeyValue = bundle.getString("mail.smtp.port_key_value");
        }

        return smtpPortKeyValue;
    }

    public static String getSmtpAuthKey() {
        String smtpAuthKey = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpAuthKey = bundle.getString("mail.smtp.auth_key");
        }

        return smtpAuthKey;
    }

    public static String getSmtpAuthKeyValue() {
        String smtpAuthKeyValue = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            smtpAuthKeyValue = bundle.getString("mail.smtp.auth_key_value");
        }

        return smtpAuthKeyValue;
    }

    public static String getUserName() {
        String userName = null;

        ResourceBundle bundle = readAppProperties();

        if (bundle != null) {
            userName = bundle.getString("user_name");
        }

        return userName;
    }
}
