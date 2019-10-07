package com.ziggeo.pagerDemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ziggeo.pagerDemo.R;


/**
 * Created by Alexander Bedulin on 07-Oct-19.
 * Ziggeo, Inc.
 * alexb@ziggeo.com
 */
public class BlankFragmentTest1 extends Fragment{

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_test_1, container, false);
        }
}
