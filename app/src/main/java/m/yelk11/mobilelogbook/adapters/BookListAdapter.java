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
import m.yelk11.mobilelogbook.dbc.entity.Book;


public class BookListAdapter extends ListAdapter<Book, BookListAdapter.LogbookHolder> {

    private OnItemClickListener listener;
    private Context context;
    public BookListAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
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
        if(position % 2 == 0){
            holder.layout.setBackgroundResource(R.color.bookPrimary);

        }else{
            holder.layout.setBackgroundResource(R.color.bookSecondary);
        }
    }

    public Book getNoteAt(int position) {
        return getItem(position);
    }




    class LogbookHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ConstraintLayout layout;

        public LogbookHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.rowTextView);
            layout = itemView.findViewById(R.id.logbook_list_item_constraintlayout);
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