package com.hansion.h_ble.callback;

/**
 * 描述:写操作回调接口
 */
public interface OnWriteCallback {

    /**
     * 蓝牙未开启
     */
    int FAILED_BLUETOOTH_DISABLE = 1;
    /**
     * 服务无效
     */
    int FAILED_INVALID_SERVICE = 2;
    /**
     * 特征无效
     */
    int FAILED_INVALID_CHARACTER = 3;
    /**
     * 操作失败
     */
    int FAILED_OPERATION = 5;

    /**
     * 写入成功
     */
    void onSuccess();

    /**
     * 写入失败
     *
     * @param state
     */
    void onFailed(int state);
}
