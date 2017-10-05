package pl.tomasz.intents.zadania.zadanie1;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class MusicItemDecorator  extends RecyclerView.ItemDecoration {

    private final int verticalSpaceHeight;

    public MusicItemDecorator(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;
    }
}