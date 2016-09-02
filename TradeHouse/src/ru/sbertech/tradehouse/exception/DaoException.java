package ru.sbertech.tradehouse.exception;

/**
 * Created by anton on 9/1/16.
 */
public class DaoException extends Exception
{
    private String errorDescription;
    private Long errorCode;

    public DaoException(String errorDescription, Long errorCode) {
        this.errorDescription = errorDescription;
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public Long getErrorCode() {
        return errorCode;
    }
}
