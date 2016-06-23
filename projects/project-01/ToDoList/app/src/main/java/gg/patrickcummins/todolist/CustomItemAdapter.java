package gg.patrickcummins.todolist;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static gg.patrickcummins.todolist.R.id.mainList;

/**
 * Created by patrickcummins on 6/22/16.
 */

public class CustomItemAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ListItem> currentList;


    public CustomItemAdapter(Context context, ArrayList<ListItem> currentList) {
        this.context = context;
        this.currentList = currentList;
    }

    @Override
    public int getCount() {
        return currentList.size();
    }

    @Override
    public Object getItem(int position) {
        return currentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final ListItem currentItem = currentList.get(position);

        viewHolder.nameTextView.setText(currentItem.getmName());
        viewHolder.descriptionTextView.setText(currentItem.getDescription());
        setColor(viewHolder, currentItem);


        viewHolder.deleteImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                currentList.remove(position);
                notifyDataSetChanged();
                return false;
            }
        });



        viewHolder.itemCheckBox.setTag(position);
        viewHolder.itemCheckBox.setChecked(currentItem.isItemChecked());

        viewHolder.itemCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.getTag() == null) return;
                int positionCheck = (int) buttonView.getTag();
                ListItem checkItem = currentList.get(positionCheck);
                checkItem.setItemChecked(isChecked);
            }
        });
        return convertView;
    }

    private void setColor(ViewHolder viewHolder, ListItem currentItem) {
        if (currentItem.getColor() != null) {

            if (currentItem.getColor().equals("blue")) {
                viewHolder.mLinearLayout.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_blue_light));
            } else if (currentItem.getColor().equals("red")) {
                viewHolder.mLinearLayout.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light));
            } else if (currentItem.getColor().equals("green")) {
                viewHolder.mLinearLayout.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_green_light));
            } else if (currentItem.getColor().equals("orange")) {
                viewHolder.mLinearLayout.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_orange_light));
            } else if (currentItem.getColor().equals("white")) {
                viewHolder.mLinearLayout.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white));
            }
        }
    }


    private class ViewHolder {
        TextView nameTextView;
        TextView descriptionTextView;
        LinearLayout mLinearLayout;
        ImageView deleteImageView;
        CheckBox itemCheckBox;

        public ViewHolder(View itemLayout) {
            this.nameTextView = (TextView) itemLayout.findViewById(R.id.itemNameTextView);
            this.descriptionTextView = (TextView) itemLayout.findViewById(R.id.itemDescriptionTextView);
            this.mLinearLayout = (LinearLayout) itemLayout.findViewById(R.id.itemLayout);
            this.deleteImageView = (ImageView) itemLayout.findViewById(R.id.deleteImageView);
            this.itemCheckBox = (CheckBox) itemLayout.findViewById(R.id.itemCheckBox);
        }
    }
}