package com.ziggeo.pagerDemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.ziggeo.androidsdk.widgets.cameraview.CameraView;

/**
 * Created by Alexander Bedulin on 07-Oct-19.
 * Ziggeo, Inc.
 * alexb@ziggeo.com
 */
public class BlankFragmentTestCamera extends Fragment {
    private static final String TAG = BlankFragmentTestCamera.class.getSimpleName();

    public static final String[] VIDEO_PERMISSIONS = {
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private CameraView cvCamera;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test_camera, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
        cvCamera = getActivity().findViewById(R.id.cv);
        if (isCameraAccessGranted() && isRecordAudioGranted() && isWriteStorageGranted()) {
            cvCamera.start();
        } else {
            ActivityCompat.requestPermissions(getActivity(), VIDEO_PERMISSIONS, 0);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
        cvCamera.stop();
    }

    private boolean isCameraAccessGranted() {
        return isPermissionGranted(Manifest.permission.CAMERA);
    }

    private boolean isRecordAudioGranted() {
        return isPermissionGranted(Manifest.permission.RECORD_AUDIO);
    }

    private boolean isWriteStorageGranted() {
        return isPermissionGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    private boolean isPermissionGranted(@NonNull String permission) {
        return ActivityCompat.checkSelfPermission(getContext(), permission) == PackageManager.PERMISSION_GRANTED;
    }

}
