package br.com.victorlsn.questions1_4.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import br.com.victorlsn.questions1_4.R;
import br.com.victorlsn.questions1_4.adapter.FilterableAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by victorlsn on 27/08/18.
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private FilterableAdapter adapter;
    private List<String> items;

    @BindView(R.id.svItems)
    SearchView searchView;
    @BindView(R.id.rvItems)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ButterKnife.bind(this);

        items = new ArrayList<>();
        items.add("Pale");
        items.add("Misspelling");
        items.add("Lunatic");
        items.add("Homage");
        items.add("Cesar");
        items.add("Cataclysm");
        items.add("Hypothesis");

        adapter = new FilterableAdapter(this, items);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        searchView.setActivated(true);
        searchView.setQueryHint("Type your seach query here");
        searchView.onActionViewExpanded();
        searchView.setIconified(false);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        // close search view on back button pressed
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
}
