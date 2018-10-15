package com.worldmer.fragdialogdemo;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Yagnik on 15-Oct-18.
 */

public class MainFragment extends Fragment {
    Button btnFrag;
    EditText edtFrag;
    public static final int FRAG_ID = 100;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main, container, false);
        btnFrag = view.findViewById(R.id.btnfrag);
        edtFrag = view.findViewById(R.id.edtfragmsg);
        btnFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        return view;
    }

    public void showDialog() {
        DialogFragment dialogFragment = new FragDialog();
        dialogFragment.setTargetFragment(this, FRAG_ID);
        dialogFragment.show(getFragmentManager(), dialogFragment.getClass().getName());
    }
    public void setMsg(String msg)
    {
        edtFrag.setText(msg);
    }
    public String getMsg()
    {
        return edtFrag.getText().toString();
    }
}
