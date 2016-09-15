package ru.sbertech.tradehouse.dao;

/**
 * Created by anton on 9/15/16.
 */
public class ConnectionBuilderFactory
{
    private static final String CLASS_NAME = "ru.sbertech.tradehouse.dao.StandaloneConnectionBuilder";

    public static ConnectionBuilder getConnectionBuilder() {
        try {
            Class aClass = Class.forName(CLASS_NAME);
            return (ConnectionBuilder) aClass.newInstance();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
