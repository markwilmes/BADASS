package com.teambadass.csci3308.badass.BluetoothActivityFinal.commons.logger;

/**
 * Created by adam on 11/30/2017.
 */

public interface LogNode {
    public void println(int priority, String tag, String msg, Throwable tr);
}
