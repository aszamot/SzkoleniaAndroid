package pl.tomasz.intents.prezentacje.pv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class PagerExample extends AppCompatActivity {

    private ViewPager pager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_example);

        List<Integer> data = new LinkedList<>();
        data.add(R.drawable.android2);
        data.add(R.drawable.android3);
        data.add(R.drawable.android4);
        data.add(R.drawable.android5);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(this, data));
    }
}
