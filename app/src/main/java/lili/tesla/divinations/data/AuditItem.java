package lili.tesla.divinations.data;

/**
 * Created by Лилия on 25.10.2017.
 */

public class AuditItem {
    private int id;
    private String date;
    private String predictionIndex;
    private String predictionCaption;

    public AuditItem(int auditId, String auditDate, String auditPredictionIndex, String auditPredictionCaption) {
        id = auditId;
        date = auditDate;
        predictionIndex = auditPredictionIndex;
        predictionCaption = auditPredictionCaption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPredictionIndex() {
        return predictionIndex;
    }

    public void setPredictionIndex(String predictionIndex) {
        this.predictionIndex = predictionIndex;
    }

    public String getPredictionCaption() {
        return predictionCaption;
    }

    public void setPredictionCaption(String predictionCaption) {
        this.predictionCaption = predictionCaption;
    }
}
