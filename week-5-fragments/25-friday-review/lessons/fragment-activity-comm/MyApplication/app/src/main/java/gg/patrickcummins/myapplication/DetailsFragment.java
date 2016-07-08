package gg.patrickcummins.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by patrickcummins on 7/8/16.
 */

public class DetailsFragment extends Fragment {
    TextView textView;
    View view;
    Button button;
    OnSendStringListener onSendStringListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        textView = (TextView) view.findViewById(R.id.detail_text);
        button = (Button) view.findViewById(R.id.detailFragButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder mStringBuilder = new StringBuilder(textView.getText().toString());
                mStringBuilder.reverse();
                String help = mStringBuilder.toString();
                onSendStringListener.onStringSent(help);
            }
        });
        return view;
    }


    public void setTextViewText(String string) {
        textView.setText(string);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onSendStringListener = (OnSendStringListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("IMPLEMENT onSendStringListener PLS");
        }
    }
}