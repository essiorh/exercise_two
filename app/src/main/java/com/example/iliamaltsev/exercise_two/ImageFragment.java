package com.example.iliamaltsev.exercise_two;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private ImageView imageView;
    private LinearLayout linearLayout;

    public void setScale(String scaleType) {
        ImageView.ScaleType imgScaleType = ImageView.ScaleType.valueOf(scaleType);
        imageView.setScaleType(imgScaleType);
    }

    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex,Drawable drawableIndex);
    }

    public void setBorder(boolean flagBorder) {
        if (flagBorder) {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.primary_dark));
        } else {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.primary_light));
        }
    }

    public void setDescription(Drawable drawableIndex) {
        if (imageView != null)
            imageView.setImageDrawable(drawableIndex);
    }

    public static ImageFragment newInstance(String param1, String param2) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ImageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout inflateView = (LinearLayout) inflater.inflate(R.layout.fragment_image, container, false);
        linearLayout=(LinearLayout) inflateView.findViewById(R.id.fon);
        imageView = (ImageView) inflateView.findViewById(R.id.our_image);
        switch (mParam1) {
            case "1":
                imageView.setImageResource(getResources().getIdentifier("drawable/one", null, getActivity().getPackageName()));
                break;
            case "2":
                imageView.setImageResource(getResources().getIdentifier("drawable/two", null, getActivity().getPackageName()));
                break;
            case "3":
                imageView.setImageResource(getResources().getIdentifier("drawable/three",null,getActivity().getPackageName()));
                break;
            case "4":
                imageView.setImageResource(getResources().getIdentifier("drawable/four",null,getActivity().getPackageName()));
                break;
            case "5":
                imageView.setImageResource(getResources().getIdentifier("drawable/five",null,getActivity().getPackageName()));
                break;
            case "6":
                imageView.setImageResource(getResources().getIdentifier("drawable/six",null,getActivity().getPackageName()));
                break;
        }
        ImageView.ScaleType imgScaleType = ImageView.ScaleType.valueOf(mParam2);
        imageView.setScaleType(imgScaleType);
        imageView.setOnClickListener(this);
        return inflateView;
    }

    @Override
    public void onClick(View v) {
        OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
        listener.onButtonSelected(Integer.valueOf(mParam1),imageView.getDrawable());
    }
}