package com.jfeinstein.jazzyviewpager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.habzy.image.tools.ImageTools;
import com.jfeinstein.jazzyviewpager.JazzyViewPager.TransitionEffect;

public class MainActivity extends Activity {

    JazzyViewPager mJazzy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupJazziness(TransitionEffect.Tablet);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Toggle Fade");
        String[] effects = this.getResources().getStringArray(R.array.jazzy_effects);
        for (String effect : effects)
            menu.add(effect);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().toString().equals("Toggle Fade")) {
            mJazzy.setFadeEnabled(!mJazzy.getFadeEnabled());
        } else {
            TransitionEffect effect = TransitionEffect.valueOf(item.getTitle().toString());
            setupJazziness(effect);
        }
        return true;
    }

    private void setupJazziness(TransitionEffect effect) {
        mJazzy = (JazzyViewPager) findViewById(R.id.jazzy_pager);
        mJazzy.setTransitionEffect(effect);
        mJazzy.setImagePath(ImageTools.getGalleryPhotos(getContentResolver()));
        mJazzy.setPageMargin(30);
    }
}
