package com.example.joanabeleza.hobbytv;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.joanabeleza.hobbytv.Adapters.MainFragmentAdapter;
import com.example.joanabeleza.hobbytv.Fragments.Main.MoviesFragment;
import com.example.joanabeleza.hobbytv.Fragments.Main.TvShowsFragment;
import com.example.joanabeleza.hobbytv.Models.Movie;
import com.example.joanabeleza.hobbytv.Models.TvShow;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements MoviesFragment.OnListFragmentInteractionListener, TvShowsFragment.OnListFragmentInteractionListener {


    @BindView(R.id.error_message) TextView mErrorMessage;

    @BindView(R.id.pb_loading_indicator) ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vp_pages= findViewById(R.id.vp_pages);
        PagerAdapter pagerAdapter=new MainFragmentAdapter(getSupportFragmentManager());
        vp_pages.setAdapter(pagerAdapter);

        TabLayout tbl_pages= findViewById(R.id.tbl_pages);
        tbl_pages.setupWithViewPager(vp_pages);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onListFragmentInteraction(Movie item) {
        Log.d("FRAGMENT", "Movies");
    }

    @Override
    public void onListFragmentInteraction(TvShow item) {
        Log.d("FRAGMENT", "Movies");
    }

}
