package cn.s07150818edu.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */

public class title_fra  extends Fragment{
    private boolean isTwoBar;
    private List<News> mnewsList;

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
        public NewsAdapter(List<News> newsList){
            mnewsList=newsList;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_list, parent, false);
            final ViewHolder viewHolder=new ViewHolder(view);

            viewHolder.title_T.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news = mnewsList.get(viewHolder.getAdapterPosition());
                    if (isTwoBar){
                        content_frag con = (content_frag) getFragmentManager().findFragmentById(R.id.content_fra);
                        con.refresh(news.getTitle(),news.getContent());
                    }else {
                        content_act.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView title_T;

            public ViewHolder(View v) {
                super(v);
                title_T=v.findViewById(R.id.news_title);
            }
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.title_frag, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_lay)!=null){
            isTwoBar=true;
        }else {
            isTwoBar=false;
        }
    }
}
