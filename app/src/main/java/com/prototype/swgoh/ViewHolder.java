package com.prototype.swgoh;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder extends RecyclerView.ViewHolder {

    CircleImageView mImage;
    TextView mImageName;
    RelativeLayout mParentLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mImage = itemView.findViewById(R.id.image);
        mImageName = itemView.findViewById(R.id.image_name);
        mParentLayout = itemView.findViewById(R.id.parent_layout);
    }

}
