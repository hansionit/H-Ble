package com.hansion.h_ble.request;

/**
 * 描述:请求队列
 */
public interface IRequestQueue<T> {

    void set(String key, T t);

    T get(String key);
}
