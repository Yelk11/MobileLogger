package m.yelk11.potalogger.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


import m.yelk11.potalogger.R;
import m.yelk11.potalogger.dbc.entity.Book;


public class BookListAdapter extends ListAdapter<Book, BookListAdapter.LogbookHolder> {

    private OnItemClickListener listener;

    public BookListAdapter() {
        super(DIFF_CALLBACK);
    }
    private static final DiffUtil.ItemCallback<Book> DIFF_CALLBACK = new DiffUtil.ItemCallback<Book>() {
        @Override
        public boolean areItemsTheSame(Book oldItem, Book newItem) {
            return oldItem.getId() == newItem.getId();
        }
        @Override
        public boolean areContentsTheSame(Book oldItem, Book newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    };

    @NonNull
    @Override
    public LogbookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.logbook_list_item, parent, false);
        return new LogbookHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LogbookHolder holder, int position) {
        Book currentBook = getItem(position);
        holder.title.setText(currentBook.getTitle());
    }

    public Book getNoteAt(int position) {
        return getItem(position);
    }




    class LogbookHolder extends RecyclerView.ViewHolder {
        private TextView title;


        public LogbookHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.rowTextView);

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
        void onItemClick(Book book);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}