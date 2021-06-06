package com.example.main.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.didi.drouter.annotation.Router;
import com.didi.drouter.api.DRouter;
import com.example.common.BaseApplication;
import com.example.main.R;

@Router(path = "/home_fragment")
public class HomeFragment extends Fragment {
    private FragmentManager fragmentManager;
    private Context context;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getParentFragmentManager();
        context = BaseApplication.getContext();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button home_test = getActivity().findViewById(R.id.home_test);
        home_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/my_activity").start();
            }
        });
        TextView wdg_tv = getActivity().findViewById(R.id.wdg_tv);
        wdg_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/tv_activity").start();
            }
        });
        TextView wdg_ev = getActivity().findViewById(R.id.wdg_ev);
        wdg_ev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/ev_activity").start();

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}