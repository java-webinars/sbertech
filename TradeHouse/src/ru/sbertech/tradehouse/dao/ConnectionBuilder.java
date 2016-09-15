package ru.sbertech.tradehouse.dao;

import java.sql.Connection;

/**
 * Created by anton on 9/15/16.
 */
public interface ConnectionBuilder
{
    Connection getConnection() throws Exception;
}
