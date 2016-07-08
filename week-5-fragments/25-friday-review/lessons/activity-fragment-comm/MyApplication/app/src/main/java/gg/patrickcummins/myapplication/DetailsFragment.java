package gg.patrickcummins.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by patrickcummins on 7/8/16.
 */

public class DetailsFragment extends Fragment {
    TextView textView;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        textView = (TextView) view.findViewById(R.id.detail_text);
        return view;
        }

    public void setTextViewText(String string){
        textView.setText(string);

    }
}
