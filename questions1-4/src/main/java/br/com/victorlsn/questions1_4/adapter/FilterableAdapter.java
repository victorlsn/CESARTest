package br.com.victorlsn.questions1_4.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.victorlsn.questions1_4.Questions;
import br.com.victorlsn.questions1_4.R;

public class FilterableAdapter extends RecyclerView.Adapter<FilterableAdapter.ViewHolder>
        implements Filterable {
    private Context context;
    private List<String> items;
    private List<String> itemsFiltered;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.tvName);
        }
    }

    public FilterableAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
        this.itemsFiltered = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String name = itemsFiltered.get(position);
        holder.name.setText(name);
    }

    @Override
    public int getItemCount() {
        return itemsFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();

                List<String> filtered = new ArrayList<>();

                if (query.isEmpty()) {
                    filtered = items;
                } else {
                    for (String item : items) {
                        if ((Questions.hasZeroOrOneTypos(item, query) && !Questions.isPartialPermutation(item, query)) ||
                                (!Questions.hasZeroOrOneTypos(item, query) && Questions.isPartialPermutation(item, query))) {
                            filtered.add(item);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.count = filtered.size();
                results.values = filtered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                itemsFiltered = (ArrayList<String>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}