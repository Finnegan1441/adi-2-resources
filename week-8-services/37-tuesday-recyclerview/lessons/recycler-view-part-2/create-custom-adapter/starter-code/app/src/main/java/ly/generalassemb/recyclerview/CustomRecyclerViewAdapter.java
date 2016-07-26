package ly.generalassemb.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom RecyclerView Adapter for rv_list_item.xml list item
 *
 * Created by alex on 6/17/16.
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder> {
    private ArrayList<String> data;
    private static OnRecyclerViewItemClickListener onItemClickListener;

    public CustomRecyclerViewAdapter(ArrayList<String> data, OnRecyclerViewItemClickListener listener) {
       this.onItemClickListener = listener;
        if (data != null) {
            this.data = data;
        }else{
            this.data = new ArrayList<String>();
        }
    }

    public static class SampleViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public SampleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
            imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(getLayoutPosition());
                }
            });

        }
    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View listItemLayout = layoutInflater.inflate(R.layout.rv_list_item, parent, false);

        SampleViewHolder sampleViewHolder = new SampleViewHolder(listItemLayout);
        return sampleViewHolder;
    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {
        String currentItem = data.get(position);

        holder.textView.setText(currentItem);
        holder.imageView.setImageResource(R.mipmap.ic_launcher);



    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnRecyclerViewItemClickListener{
        void onItemClick(int position);
    }



}
