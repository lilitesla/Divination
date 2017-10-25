package lili.tesla.divinations.data;

/**
 * Created by Лилия on 24.10.2017.
 */

public class Prediction {
    private int id;
    private int index_id;
    private String caption;
    private String description;
    private String china_caption;
    private String slogan;

    public Prediction(int predId, int predIndex, String predCaption, String predDescription, String predChinaCaption, String predSlogan) {
        id = predId;
        index_id = predIndex;
        caption = predCaption;
        description = predDescription;
        china_caption = predChinaCaption;
        slogan = predSlogan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIndex_id(int index_id) {
        this.index_id = index_id;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setChina_caption(String china_caption) {
        this.china_caption = china_caption;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
