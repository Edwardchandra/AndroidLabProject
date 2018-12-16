package com.example.user.breadstalk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private int[] images = {R.drawable.muffins, R.drawable.buns, R.drawable.baguette, R.drawable.croutons, R.drawable.doughnuts,
            R.drawable.focaccia, R.drawable.panettone, R.drawable.sourdough};
    private String[] titles = {"Muffins","Bun","Baguette","Croutons","Doughnuts","Focaccia","Panettone","Sourdough"};
    private String[] description = {"Originated in North America during 19th century. Fresh baked.",
                                    "Enriched with sugar, butter and egg. Sweet and Round.",
                                    "Long and thin loaf of French bread.",
                                    "Cube piece of sautéed or rebaked bread.",
                                    "Deep fried and ring-shaped bread. Creamy chocolate.",
                                    "Flat oven-baked Italian bread product.",
                                    "Italian type of bread loaf originally from Milan. Sweet and delicious.",
                                    "Made by the fermentation of dough using naturally occurring lactobacilli and yeast."};

    public ListViewAdapter(Context context){
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
            view = LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false);
        }

        final ImageView itemImage = view.findViewById(R.id.itemImageView);
        final TextView itemTitle = view.findViewById(R.id.itemTitle);
        final TextView itemDesc = view.findViewById(R.id.itemDesc);
        itemImage.setImageResource(images[position]);
        itemTitle.setText(titles[position]);
        itemDesc.setText(description[position]);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainDetailActivity.class);
                intent.putExtra("itemname", titles[position]);
                intent.putExtra("itemdesc", description[position]);
                intent.putExtra("itemimage", Integer.toString(images[position]));
                v.getContext().startActivity(intent);
            }
        });

        return view;
    }
}
