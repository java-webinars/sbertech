package ru.sbertech.tradehouse.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by anton on 12/5/16.
 */
@WebService
//(targetNamespace = "ru.sbertech.webservice")
public class JSEBean01
{
    @WebMethod()
//    @WebResult(name = "echoResult")
    public String echo(String input) {  //@WebParam(name = "inputParameter")
        return "Hello " + input;
    }
}