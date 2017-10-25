package lili.tesla.divinations.data;

/**
 * Created by Лилия on 25.10.2017.
 */

public class AuditItem {
    private int id;
    private String date;
    private int predictionIndex;

    public AuditItem(int auditId, String auditDate, int auditPredictionIndex) {
        id = auditId;
        date = auditDate;
        predictionIndex = auditPredictionIndex;
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

    public int getPredictionIndex() {
        return predictionIndex;
    }

    public void setPredictionIndex(int predictionIndex) {
        this.predictionIndex = predictionIndex;
    }
}
