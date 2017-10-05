package pl.tomasz.intents.prezentacje.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pl.tomasz.intents.R;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    private TextView text;
    private Context context;
    private MyAdapter adapter;

    public MyViewHolder(View itemView, Context context, MyAdapter adapter) {
        super(itemView);
        this.adapter= adapter;
        this.context = context;
        text = (TextView) itemView.findViewById(R.id.text);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void bindData(int data){
        text.setText(data+" - element");
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, text.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View view) {
        adapter.removeItem(getAdapterPosition());
        return false;
    }
}
