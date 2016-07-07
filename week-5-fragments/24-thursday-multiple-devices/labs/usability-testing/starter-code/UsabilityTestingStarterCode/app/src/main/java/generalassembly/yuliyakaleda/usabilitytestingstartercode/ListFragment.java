package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.R.attr.screenSize;


public class ListFragment extends Fragment {
    private static final String SIGN = "sign";
    private ListView listView;
    onSignSelected mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        listView = (ListView) view.findViewById(R.id.list_view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] values = getResources().getStringArray(R.array.signs);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int orientation = getResources().getConfiguration().orientation;
                String itemValue = (String) listView.getItemAtPosition(position);
                if (orientation == Configuration.ORIENTATION_LANDSCAPE){
                    mListener.signSelected("http://www.horoscopedates.com/zodiac-signs/" + itemValue.toLowerCase() + "/");
                }
                else{
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.horoscopedates.com/zodiac-signs/" + itemValue.toLowerCase() + "/"));
                startActivity(browserIntent);}
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (onSignSelected) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement onSignSelected");
        }

    }
}
