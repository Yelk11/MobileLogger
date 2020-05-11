package m.yelk11.potalogger.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import m.yelk11.potalogger.R;

public class LogEntryListAdapter extends RecyclerView.Adapter<LogEntryListAdapter.ViewHolder> {


    private ArrayList<LogEntry> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    /**
     * data is passed into the constructor
     * @param context
     * @param data
     */
    public LogEntryListAdapter(Context context, ArrayList<LogEntry> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    /**
     * inflates the row layout from xml when needed
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.logbook_list_fragment, parent, false);
        return new ViewHolder(view);
    }

    /**
     * binds the data to the TextView in each row
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LogEntry logEntry = mData.get(position);
        holder.myTextView.setText(logEntry.getName());
    }

    /**
     * total number of rows
     *
     * @return size of data
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }



    /**
     * stores and recycles views as they are scrolled off screen
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.rowTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    /**
     * convenience method for getting data at click position
     *
     * @param id
     * @return
     */
    public LogEntry getItem(int id) {
        return mData.get(id);
    }

    /**
     * allows clicks events to be caught
     *
     * @param itemClickListener
     */
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    /**
     * parent activity will implement this method to respond to click events
     */
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
