package me.ajax.ihavenothing;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aj on 2018/5/09
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    private ArrayList<SongVo> myData = new ArrayList<>();

    public CardAdapter() {
        myData.add(new SongVo("一无所有", "《一无所有》由崔健作词、作曲。崔健表示这首歌曲的创作他没有花很长的时间  ", R.drawable.bg_card_1));
        myData.add(new SongVo("新长征路上的摇滚", "是由崔健作词，崔健作曲，崔健演唱的歌曲，该歌曲收录于崔健1989年发行的专辑《新长征路上的摇滚》中。", R.drawable.bg_card_2));
        myData.add(new SongVo("快让我在雪地上撒点儿野", "是崔健填词，崔健、王勇谱曲，崔健演唱的一首歌曲，收录在崔健1991年2月1日发行的专辑《解决》中", R.drawable.bg_card_3));
        myData.add(new SongVo("红旗下的蛋", "《红旗下的蛋》，是崔健于1994年8月出版发行的音乐专辑，为崔健最具争议的一张唱片。", R.drawable.bg_card_4));
        myData.add(new SongVo("蓝色骨头", "蓝色骨头，是一首由崔健演唱歌曲。收录在崔健2005年的专辑《给你一点颜色》之中。", R.drawable.bg_card_5));
        myData.add(new SongVo("从头再来", "原版收录于崔健1989年的专辑《新长征路上的摇滚》和海外版《一无所有》", R.drawable.bg_card_1));
        myData.add(new SongVo("一块红布", "是崔健作词作曲并演唱的一首歌，于1991年发行，词曲时长为4分40秒，收录于1991年专辑《解决》中。", R.drawable.bg_card_2));
        myData.add(new SongVo("浪子归", "《浪子归》由崔健1986年演唱的一首音乐作品。", R.drawable.bg_card_3));
        myData.add(new SongVo("鱼鸟之恋", "这是崔健执导的电影《蓝色骨头》中的插曲。该歌词曲由崔健一手包办，由央吉玛演唱。", R.drawable.bg_card_4));
        myData.add(new SongVo("无能的力量", "《无能的力量》是由崔健作词作曲并演唱的一首歌曲，收录于同名专辑《无能的力量》。", R.drawable.bg_card_5));

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_card, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setSong(myData.get(position));
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    //自定义Holder
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView someNameTextView;
        private TextView someDescTextView;
        private View itemBoxView;


        public MyViewHolder(View itemView) {
            super(itemView);
            someNameTextView = itemView.findViewById(R.id.song_name);
            someDescTextView = itemView.findViewById(R.id.song_desc);
            itemBoxView = itemView.findViewById(R.id.item_box);
        }

        public void setSong(SongVo song) {
            someNameTextView.setText(song.getName());
            someDescTextView.setText(song.getDesc());
            itemBoxView.setBackgroundResource(song.getBg());
        }

    }
}

