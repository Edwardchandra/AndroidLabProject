package com.example.user.breadstalk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PopularListViewAdapter extends BaseAdapter {

    private Context context;
    private int[] images = {R.drawable.baguette, R.drawable.croutons,
            R.drawable.focaccia, R.drawable.panettone, R.drawable.sourdough};
    private String[] titles = {"Baguette","Croutons","Focaccia","Panettone","Sourdough"};
    private String[] description = {"Long and thin loaf of French bread.",
            "Cube piece of sautéed or rebaked bread.",
            "Flat oven-baked Italian bread product.",
            "Italian type of bread loaf originally from Milan. Sweet and delicious.",
            "Made by the fermentation of dough using naturally occurring lactobacilli and yeast."};


    public PopularListViewAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.popular_list_layout, parent, false);
        }

        ImageView popularImage = view.findViewById(R.id.popularImageView);
        TextView popularTitle = view.findViewById(R.id.popularTitle);
        TextView popularDesc = view.findViewById(R.id.popularDesc);
        popularImage.setImageResource(images[position]);
        popularTitle.setText(titles[position]);
        popularDesc.setText(description[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PopularDetailActivity.class);
                intent.putExtra("itemname", titles[position]);
                intent.putExtra("itemdesc", description[position]);
                intent.putExtra("itemimage", Integer.toString(images[position]));
                v.getContext().startActivity(intent);
            }
        });

        return view;
    }
}
