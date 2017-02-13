package com.hansion.hble.sample.adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hansion.hble.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Author: Hansion
 * Time: 2017/2/13 11:23
 */
public class DeviceListAdapter extends BaseAdapter {

    private List<BluetoothDevice> bluetoothDevices = new ArrayList<BluetoothDevice>();
    private Context mContext;

    public DeviceListAdapter(Context context,List<BluetoothDevice> bluetoothDevices) {
        mContext = context;
        this.bluetoothDevices = bluetoothDevices;
    }

    @Override
    public int getCount() {
        return bluetoothDevices.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        BaseViewHolder holder = BaseViewHolder.
                getViewHolder(mContext, convertView, viewGroup, R.layout.item_device_list, position);
        TextView name = holder.getView(R.id.mDeviceName);
        TextView address = holder.getView(R.id.mDeviceMacAddress);
        name.setText(bluetoothDevices.get(position).getName());
        address.setText(bluetoothDevices.get(position).getAddress());
        return holder.getConvertView();
    }
}
