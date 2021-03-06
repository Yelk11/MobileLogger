package m.yelk11.mobilelogbook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import m.yelk11.mobilelogbook.R;
import m.yelk11.mobilelogbook.dbc.entity.Entry;

public class EntryListAdapter extends ListAdapter<Entry, EntryListAdapter.EntryHolder> {

    private OnItemClickListener listener;
    private Context context;


    public EntryListAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }
    private static final DiffUtil.ItemCallback<Entry> DIFF_CALLBACK = new DiffUtil.ItemCallback<Entry>() {
        @Override
        public boolean areItemsTheSame(Entry oldItem, Entry newItem) {
            return oldItem.getId() == newItem.getId();
        }
        @Override
        public boolean areContentsTheSame(Entry oldItem, Entry newItem) {
            return oldItem.getmCallsignTx().equals(newItem.getmCallsignTx());
        }
    };
    @NonNull
    @Override
    public EntryListAdapter.EntryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.entry_list_item, parent, false);
        return new EntryListAdapter.EntryHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull EntryListAdapter.EntryHolder holder, int position) {

        Entry currentEntry = getItem(position);
        holder.callsign.setText(currentEntry.getmCallsignTx());
        holder.frequency.setText(currentEntry.getmFrequency());
        holder.mode.setText(currentEntry.getmMode());
        holder.band.setText("BAND");
        holder.date.setText(currentEntry.getmDate());
        holder.time.setText(currentEntry.getmTime());


        if(position % 2 == 0){
            holder.layout.setBackgroundResource(R.color.entryPrimary);

        }else{
            holder.layout.setBackgroundResource(R.color.entrySecondary);
        }
    }



    public Entry getEntryAt(int position) {
        return getItem(position);
    }

    public Entry getNoteAt(int position) {
        return getItem(position);
    }

    class EntryHolder extends RecyclerView.ViewHolder {
        private TextView callsign;
        private TextView frequency;
        private TextView mode;
        private TextView band;
        private TextView date;
        private TextView time;



        private ConstraintLayout layout;

        public EntryHolder(View itemView) {
            super(itemView);

            callsign = itemView.findViewById(R.id.entry_callsign);
            frequency  = itemView.findViewById(R.id.entry_frequency);
            mode = itemView.findViewById(R.id.entry_mode);
            band = itemView.findViewById(R.id.entry_band);
            date = itemView.findViewById(R.id.entry_date);
            time = itemView.findViewById(R.id.entry_time);




            layout = itemView.findViewById(R.id.entry_list_constraintlayout);
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
