package com.djason.gridimagesearch.activities.adapters;


import android.content.Context;
import java.util.List;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.djason.gridimagesearch.R;
import com.djason.gridimagesearch.models.ImageResult;
import com.squareup.picasso.Picasso;

/**
 * Created by Ing Djason(Admin) on 16-Jul-15.
 */
public class ImageResultsAdapter extends ArrayAdapter<ImageResult> {
    public ImageResultsAdapter(Context context, List<ImageResult> images) {
        super(context, R.layout.item_image_result, images);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageResult imageInfo = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_image_result, parent, false);
        }
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        // clear out image from last time
        ivImage.setImageResource(0);
        //populate title and remote download image url
        tvTitle.setText(Html.fromHtml(imageInfo.title));
        // Remotely download the image data in the background (With picasso)
        Picasso.with(getContext()).load(imageInfo.thumbUrl).into(ivImage);
        //return the completed view to be displayed
        return convertView;
    }
}
