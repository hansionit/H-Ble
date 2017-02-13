package com.hansion.h_ble.callback;

import android.bluetooth.BluetoothDevice;

/**
 * Description：
 * Author: Hansion
 * Time: 2016/10/11 12:11
 */
public interface ScanCallback {
    /**
     * 扫描完成,成功回调
     */
    void onSuccess();

    /**
     * 扫描过程中,每扫描到一个设备回调一次
     *
     * @param device     扫描到的设备
     * @param rssi       设备的信息强度
     * @param scanRecord
     */
    void onScanning(final BluetoothDevice device, int rssi, byte[] scanRecord);

}
