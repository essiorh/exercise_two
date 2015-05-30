package com.example.iliamaltsev.exercise_two;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class ImageFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView imageView;

    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex);
    }

    public void setDescription(int buttonIndex) {
        if (imageView != null)
            switch (buttonIndex) {
                case 1:
                    imageView.setImageResource(R.drawable.one);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.two);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.three);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.four);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.five);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.six);
                    break;

                default:
                    break;
            }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageFragment newInstance(String param1, String param2) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ImageFragment() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment
        LinearLayout inflateView = (LinearLayout) inflater.inflate(R.layout.fragment_image, container, false);
        imageView = (ImageView) inflateView.findViewById(R.id.our_image);
        switch (mParam1) {
            case "1":
                imageView.setImageResource(R.drawable.one);
                break;
            case "2":
                imageView.setImageResource(R.drawable.two);
                break;
            case "3":
                imageView.setImageResource(R.drawable.three);
                break;
            case "4":
                imageView.setImageResource(R.drawable.four);
                break;
            case "5":
                imageView.setImageResource(R.drawable.five);
                break;
            case "6":
                imageView.setImageResource(R.drawable.six);
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
        listener.onButtonSelected(Integer.valueOf(mParam1));

    }
    // Временный код для получения индекса нажатой кнопки
    //Toast.makeText(getActivity(), String.valueOf(mParam1),
    //      Toast.LENGTH_SHORT).show();
}

