package jayt.com.apnabegun.model;

public class AdsList {

    String id;
    String imageurl;
    String expired;
    String startdate;
    String enddate;
    String impressionlimit;
    String impressionfreq;
    String priority;

    public AdsList() {
    }

    public AdsList(String id, String imageurl, String expired, String startdate, String enddate,
                   String impressionlimit, String impressionfreq, String priority) {
        this.id = id;
        this.imageurl = imageurl;
        this.expired = expired;
        this.startdate = startdate;
        this.enddate = enddate;
        this.impressionlimit = impressionlimit;
        this.impressionfreq = impressionfreq;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getImpressionlimit() {
        return impressionlimit;
    }

    public void setImpressionlimit(String impressionlimit) {
        this.impressionlimit = impressionlimit;
    }

    public String getImpressionfreq() {
        return impressionfreq;
    }

    public void setImpressionfreq(String impressionfreq) {
        this.impressionfreq = impressionfreq;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
