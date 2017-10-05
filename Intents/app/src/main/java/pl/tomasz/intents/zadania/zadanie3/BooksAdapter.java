package pl.tomasz.intents.zadania.zadanie3;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 01.10.2017.
 */

public class BooksAdapter extends PagerAdapter {

    private List<Book> books;
    private Context context;

    public BooksAdapter(Context context, List books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_pager_zadanie3, container, false);

        TextView title;
        TextView desc;

        title = (TextView) view.findViewById(R.id.title);
        desc = (TextView) view.findViewById(R.id.desc);

        Book book = books.get(position);

        title.setText(book.getTitle());
        desc.setText(book.getDesc());

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
