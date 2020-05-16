package m.yelk11.potalogger.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import m.yelk11.potalogger.R;
import m.yelk11.potalogger.dbc.entity.Entry;

public class LogEntryListAdapter extends ListAdapter<Entry, LogEntryListAdapter.EntryHolder> {

    private OnItemClickListener listener;

    private List<Entry> entries = new ArrayList<Entry>();

    public LogEntryListAdapter() {
        super(DIFF_CALLBACK);


    }
    private static final DiffUtil.ItemCallback<Entry> DIFF_CALLBACK = new DiffUtil.ItemCallback<Entry>() {
        @Override
        public boolean areItemsTheSame(Entry oldItem, Entry newItem) {
            return oldItem.getId() == newItem.getId();
        }
        @Override
        public boolean areContentsTheSame(Entry oldItem, Entry newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    };
    @NonNull
    @Override
    public LogEntryListAdapter.EntryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.entry_list_item, parent, false);
        return new LogEntryListAdapter.EntryHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull LogEntryListAdapter.EntryHolder holder, int position) {

        Entry currentEntry = getItem(position);
        holder.callsign.setText(currentEntry.getTitle());
    }



    public Entry getEntryAt(int position) {
        return getItem(position);
    }

    public Entry getNoteAt(int position) {
        return getItem(position);
    }

    class EntryHolder extends RecyclerView.ViewHolder {
        private TextView callsign;


        public EntryHolder(View itemView) {
            super(itemView);

            callsign = itemView.findViewById(R.id.entry_callsign);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(Entry entry);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
