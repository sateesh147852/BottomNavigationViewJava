package com.testjava;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.testjava.databinding.FragmentABinding;

public class FragmentA extends Fragment implements View.OnClickListener {

    private static FragmentA fragmentA;
    private static final String TAG = FragmentA.class.getSimpleName();
    private FragmentABinding binding;
    private BluetoothAdapter bluetoothAdapter;

    public static FragmentA newInstance() {
        if (fragmentA == null)
            fragmentA = new FragmentA();
        return fragmentA;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentABinding.inflate(getLayoutInflater());
        initializeView();
        return binding.getRoot();
    }

    private void initializeView() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter.isEnabled())
            binding.btTurnOnBluetooth.setText("Turn off bluetooth");
        else
            binding.btTurnOnBluetooth.setText("Turn on bluetooth");
        binding.btHideKeyboard.setOnClickListener(this);
        binding.btShowKeyboard.setOnClickListener(this);
        binding.btSendSms.setOnClickListener(this);
        binding.btMakeCall.setOnClickListener(this);
        binding.btPlayMp3.setOnClickListener(this);
        binding.btTurnOnBluetooth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btHideKeyboard:
                Utility.hideKeyBoard(binding.btHideKeyboard);
                break;

            case R.id.btShowKeyboard:
                Utility.showKeyBoard(getContext());
                break;

            case R.id.btSendSms:
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:9686025367"));
                intent.putExtra("sms_body", "I am done");
                startActivity(intent);
                break;

            case R.id.btMakeCall:
                String phone = "03131693169";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phone));
                startActivity(callIntent);
                break;

            case R.id.btPlayMp3:
                Uri notification = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.veerzaaraton);
                Ringtone r = RingtoneManager.getRingtone(getContext(), notification);
                r.play();
                break;

            case R.id.btTurnOnBluetooth:
                if (bluetoothAdapter.isEnabled()) {
                    bluetoothAdapter.disable();
                    binding.btTurnOnBluetooth.setText("Turn on Bluetooth");
                } else {
                    bluetoothAdapter.enable();
                    binding.btTurnOnBluetooth.setText("Turn off Bluetooth");
                }
                break;
        }
    }
}