package com.example.android.fragments;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

/**Created by jamieywong on 4/6/15.
  This activity is only used in single pane mode.
  Support ActionBar capability for older versions, use ...support.v7.. library
*/

public class FlowerDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_detail);

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        if (savedInstanceState == null) {
        //Create the fragment, set its args, add it to the detail container
            FlowerDetailFragment fragment = new FlowerDetailFragment();

            Bundle b = getIntent().getBundleExtra(MainActivity.Flower_Bundle);
            fragment.setArguments(b);

            getFragmentManager().beginTransaction()
                    .add(R.id.detailContainer, fragment)
                    .commit();
        }

    }

    //  Returns to the list activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

}
