package com.example.demolivescore.fragments.news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demolivescore.R;
import com.example.demolivescore.adapter.NewsAdapter;
import com.example.demolivescore.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<News> newsList;
    private NewsAdapter mNewsAdapter;

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        recyclerView = view.findViewById(R.id.news_recycler_view);
        newsList = new ArrayList<>();
        mNewsAdapter = new NewsAdapter(newsList, getActivity());

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mNewsAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        fetchNewsItems();

        return view;
    }

    private void fetchNewsItems(){
        ArrayList<News> items = new ArrayList<>();
        items.add(new News(R.drawable.p1,"Barca star Alba bemoans 'bad point' after Alaves draw", "15 hours ago"));
        items.add(new News(R.drawable.p2,"Mourinho having 'fun' despite admitting Roma job is 'tough'\n" +
                "\n", "16 hours ago"));
        items.add(new News(R.drawable.p3,"'Dizzy' Aguero taken to hospital for cardiac exam, Barcelona confirm", "1 days ago"));
        items.add(new News(R.drawable.p4,"Barcelona 1-1 Deportivo Alaves: Barca held as Aguero forced off injured", "1 days ago"));
        items.add(new News(R.drawable.p5,"Malmo 0-1 Chelsea: Ziyech edges defending champions closer to last 16", "1 days ago"));
        items.add(new News(R.drawable.p6,"Juventus 4-2 Zenit: Dybala brace helps Bianconeri secure last-16 spot", "2 days ago"));
        items.add(new News(R.drawable.p7,"In Focus: Leo's PSG switch is turning into a bit of a Mess", "2 days ago"));
        items.add(new News(R.drawable.p8,"Transfer Talk: Conte plots Serie A raid as six Spurs targets revealed", "2 days ago"));
        newsList.addAll(items);
        // refreshing recycler view
        mNewsAdapter.notifyDataSetChanged();
    }
}