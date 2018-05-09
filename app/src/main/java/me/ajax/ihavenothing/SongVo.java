package me.ajax.ihavenothing;

/**
 * Created by aj on 2018/5/9
 */

public class SongVo {

    private String name;
    private String desc;
    private int bg;

    public SongVo(String name, String desc, int bg) {
        this.name = name;
        this.desc = desc;
        this.bg = bg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }
}
