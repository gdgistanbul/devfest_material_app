package com.gdgistanbul.devfestistanbul;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.gdgistanbul.devfestistanbul.adapter.SwipeAdapter;
import com.gdgistanbul.devfestistanbul.cache.SessionData;
import com.gdgistanbul.devfestistanbul.event.FocusEvent;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import de.greenrobot.event.EventBus;


public class HomeActivity extends Activity {
    public static SparseArray<Bitmap> sPhotoCache = new SparseArray<Bitmap>(4);

    SwipeAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;
    EventBus mEventBus = EventBus.getDefault();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Pager
        mAdapter = new SwipeAdapter(getFragmentManager());

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        TitlePageIndicator indicator = (TitlePageIndicator) findViewById(R.id.titles);
        indicator.setViewPager(mPager);
        indicator.setFooterIndicatorStyle(TitlePageIndicator.IndicatorStyle.Triangle);
        mIndicator = indicator;
        mEventBus.register(this, 0);
//
//        SessionData.sCache.put(0, new Session(0, "Murat Yener", "Le Android", "erjibfvei jrnvjoernv jernvjierbn vijernvie rnvio ernhvue vejirhv eijrnvc vejnrvi ojernovern vejernvjierbn vijernvie rnvioernhvue vejirhveijrnvc", ((BitmapDrawable) getDrawable(R.drawable.photo1)).getBitmap()));
//        SessionData.sCache.put(1, new Session(1, "Murat Yener", "Le Android", "erjibfvei jrnvjoernv jernvjierbn vijernvie rnvio ernhvue vejirhv eijrnvc vejnrvi ojernovern vejernvjierbn vijernvie rnvioernhvue vejirhveijrnvc", ((BitmapDrawable) getDrawable(R.drawable.photo2)).getBitmap()));
//        SessionData.sCache.put(2, new Session(2, "Murat Yener", "Le Android", "erjibfvei jrnvjoernv jernvjierbn vijernvie rnvio ernhvue vejirhv eijrnvc vejnrvi ojernovern vejernvjierbn vijernvie rnvioernhvue vejirhveijrnvc", ((BitmapDrawable) getDrawable(R.drawable.photo3)).getBitmap()));
//        SessionData.sCache.put(3, new Session(3, "Murat Yener", "Le Android", "erjibfvei jrnvjoernv jernvjierbn vijernvie rnvio ernhvue vejirhv eijrnvc vejnrvi ojernovern vejernvjierbn vijernvie rnvioernhvue vejirhveijrnvc", ((BitmapDrawable) getDrawable(R.drawable.photo4)).getBitmap()));

    }

    public void onEvent(final FocusEvent event) {
        mIndicator.setCurrentItem(event.getIndex());
        mEventBus.cancelEventDelivery(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("UnusedDeclaration")
    public void showPhoto(View view) {
        Intent intent = new Intent();
        intent.setClass(this, DetailActivity.class);

        switch (view.getId()) {
            case R.id.show_photo_1:
                intent.putExtra("lat", 37.6329946);
                intent.putExtra("lng", -122.4938344);
                intent.putExtra("zoom", 14.0f);
                intent.putExtra("title", "Pacifica Pier");
                intent.putExtra("description", getResources().getText(R.string.lorem));
                intent.putExtra("photo", R.drawable.photo1);
                break;
            case R.id.show_photo_2:
                intent.putExtra("lat", 37.73284);
                intent.putExtra("lng", -122.503065);
                intent.putExtra("zoom", 15.0f);
                intent.putExtra("title", "Pink Flamingo");
                intent.putExtra("description", getResources().getText(R.string.lorem));
                intent.putExtra("photo", R.drawable.photo2);
                break;
            case R.id.show_photo_3:
                intent.putExtra("lat", 36.861897);
                intent.putExtra("lng", -111.374438);
                intent.putExtra("zoom", 11.0f);
                intent.putExtra("title", "Antelope Canyon");
                intent.putExtra("description", getResources().getText(R.string.lorem));
                intent.putExtra("photo", R.drawable.photo3);
                break;
            case R.id.show_photo_4:
                intent.putExtra("lat", 36.596125);
                intent.putExtra("lng", -118.1604282);
                intent.putExtra("zoom", 9.0f);
                intent.putExtra("title", "Lone Pine");
                intent.putExtra("description", getResources().getText(R.string.lorem));
                intent.putExtra("photo", R.drawable.photo4);
                break;
        }

        ImageView hero = (ImageView) ((View) view.getParent()).findViewById(R.id.photo);

        sPhotoCache.put(intent.getIntExtra("photo", -1),
                ((BitmapDrawable) hero.getDrawable()).getBitmap());

        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(this, hero, "photo_hero");
        startActivity(intent, options.toBundle());
    }


}
