package com.example.android.fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.fragments.data.Flower;


public class MainActivity extends ActionBarActivity
    implements FlowerListFragment.Callbacks {

    private static final int REQUEST_CODE = 100;
    protected static final String Flower_Bundle = "Flower_bundle";
    private boolean isTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //not adding programmatically, but through xml layouts
       /* FlowerListFragment frag = new FlowerListFragment();

        getFragmentManager().beginTransaction()
                .add(R.id.myContainer, frag)
                .commit();*/

        //show action bar and icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        if (findViewById(R.id.detailContainer) != null) {
            isTwoPane = true;
        }
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {

                ScreenUtility utility = new ScreenUtility(this);

                String output = "Width: " + utility.getWidth() + ", " + "Height: " + utility.getHeight()
                        + "\n"+ " HeightPixels: " + utility.getMyHeightPixels() + "\n" +
                        "WidthPixels: " + utility.getMyWidthPixels() + "\n" +
                        "Density: " + utility.getDensity();

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage(output).setTitle("Dimensions").create().show();

                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onItemSelected (Flower flower){
            Bundle b = flower.toBundle();

            if (isTwoPane == true) {
                FlowerDetailFragment fragment = new FlowerDetailFragment();
                fragment.setArguments(b);
                getFragmentManager().beginTransaction().replace(R.id.detailContainer, fragment).commit();
            }
            else {
                Intent intent = new Intent(this, FlowerDetailActivity.class);
                intent.putExtra(Flower_Bundle, b);
                startActivityForResult(intent, REQUEST_CODE);

            }

        }
    }
