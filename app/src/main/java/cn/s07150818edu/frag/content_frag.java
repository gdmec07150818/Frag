package cn.s07150818edu.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/17.
 */

public class content_frag extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_layout, container, false);
        return view;
    }

    public void refresh(String title,String content){
        View visi=view.findViewById(R.id.visi_layout);
        visi.setVisibility(View.VISIBLE);
        TextView title_T=view.findViewById(R.id.news_title);
        TextView content_T=view.findViewById(R.id.content_c);
        title_T.setText(title);
        content_T.setText(content);


    }

}
