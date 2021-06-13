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
//    private FragmentManager fragmentManager;
    private Context context;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        fragmentManager = getParentFragmentManager();
        context = BaseApplication.getContext();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
//        Button home_test = getActivity().findViewById(R.id.home_test);
//        home_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DRouter.build("/my_activity").start();
//            }
//        });
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
        TextView wdg_iv = getActivity().findViewById(R.id.wdg_iv);
        wdg_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/iv_activity").start();
            }
        });
        TextView wdg_btn = getActivity().findViewById(R.id.wdg_btn);
        wdg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/btn_activity").start();
            }
        });
        TextView wdg_check = getActivity().findViewById(R.id.wdg_check);
        wdg_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/check_activity").start();
            }
        });
        TextView wdg_switch = getActivity().findViewById(R.id.wdg_switch);
        wdg_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/switch_activity").start();
            }
        });
        TextView wdg_date_picker = getActivity().findViewById(R.id.wdg_date_picker);
        wdg_date_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/date_picker_activity").start();
            }
        });
        TextView wdg_time_picker = getActivity().findViewById(R.id.wdg_time_picker);
        wdg_time_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/time_picker_activity").start();
            }
        });
        TextView wdg_progress = getActivity().findViewById(R.id.wdg_progress);
        wdg_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/progress_activity").start();
            }
        });
        TextView wdg_seek = getActivity().findViewById(R.id.wdg_seek);
        wdg_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/seek_activity").start();
            }
        });
        TextView wdg_rating_bar = getActivity().findViewById(R.id.wdg_rating_bar);
        wdg_rating_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/rating_bar_activity").start();
            }
        });
        TextView wdg_menu = getActivity().findViewById(R.id.wdg_menu);
        wdg_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/menu_activity").start();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}