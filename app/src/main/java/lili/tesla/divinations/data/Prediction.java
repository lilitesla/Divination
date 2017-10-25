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

}
