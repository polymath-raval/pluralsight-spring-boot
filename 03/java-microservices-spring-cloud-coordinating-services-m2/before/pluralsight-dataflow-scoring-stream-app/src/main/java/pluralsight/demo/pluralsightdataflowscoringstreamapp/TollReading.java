package pluralsight.demo.pluralsightdataflowscoringstreamapp;

public class TollReading {
  private Integer customerid;
  private Integer stationid;
  private String timestamp;
  private Boolean isFraud;

  public TollReading() {
  }

  public TollReading(Integer customerid, Integer stationid, String timestamp,
      Boolean isFraud) {
    this.customerid = customerid;
    this.stationid = stationid;
    this.timestamp = timestamp;
    this.isFraud = isFraud;
  }

  public Integer getCustomerid() {
    return customerid;
  }

  public void setCustomerid(Integer customerid) {
    this.customerid = customerid;
  }

  public Integer getStationid() {
    return stationid;
  }

  public void setStationid(Integer stationid) {
    this.stationid = stationid;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public Boolean getFraud() {
    return isFraud;
  }

  public void setFraud(Boolean fraud) {
    isFraud = fraud;
  }

  @Override
  public String toString() {
    return "TollReading{" +
        "customerid=" + customerid +
        ", stationid=" + stationid +
        ", timestamp='" + timestamp + '\'' +
        ", isFraud=" + isFraud +
        '}';
  }
}
