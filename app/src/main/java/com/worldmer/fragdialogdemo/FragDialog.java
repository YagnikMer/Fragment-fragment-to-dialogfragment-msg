package com.worldmer.fragdialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Yagnik on 15-Oct-18.
 */

public class FragDialog extends DialogFragment {

    EditText editText;
    Button button;
    MainFragment mainFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainFragment = (MainFragment)getTargetFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = getActivity().getLayoutInflater().inflate(R.layout.frag_dialog, null);
        editText = view.findViewById(R.id.edtfragmsg);
        editText.setText(mainFragment.getMsg());
        button = view.findViewById(R.id.btnfrag);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragment.setMsg(editText.getText().toString());
                dismiss();
            }
        });
        builder.setView(view);
        return builder.create();
    }
}
