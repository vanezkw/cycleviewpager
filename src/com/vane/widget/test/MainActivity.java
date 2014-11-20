package com.vane.widget.test;

import com.example.cycleviewpager.R;
import com.vane.widget.cycleviewpager.CycleViewPager;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private PagerAdapter adapter = new PagerAdapter() {

        private int count = 5;

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public int getCount() {
            return count;
        }

        public Object instantiateItem(android.view.ViewGroup container, int position) {
            TextView item = new TextView( MainActivity.this);
            item.setText( "page " + position);
            container.addView( item);
            return item;
        }

        public void destroyItem(android.view.ViewGroup container, int position, Object object) {
            container.removeView( (View)object);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView( R.layout.activity_main);
        CycleViewPager pager = (CycleViewPager)findViewById( R.id.pager);
        pager.setAdapter( adapter);
    }

}
