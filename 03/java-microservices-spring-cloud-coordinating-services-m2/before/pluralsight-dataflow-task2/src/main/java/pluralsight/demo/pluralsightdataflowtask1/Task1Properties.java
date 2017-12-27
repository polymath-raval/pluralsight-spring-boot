package pluralsight.demo.pluralsightdataflowtask1;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("task1")
public class Task1Properties {

  /**
   * Path to get the source document
   */
  private String sourceFilePath;
  /**
   * Path to put the destination document
   */
  private String destinationFilePath;
  /**
   * property to drive the control message
   */
  private String controlMessage;

  public Task1Properties() {
  }

  public Task1Properties(String sourceFilePath, String destinationFilePath,
      String controlMessage) {
    this.sourceFilePath = sourceFilePath;
    this.destinationFilePath = destinationFilePath;
    this.controlMessage = controlMessage;
  }

  public String getSourceFilePath() {
    return sourceFilePath;
  }

  public void setSourceFilePath(String sourceFilePath) {
    this.sourceFilePath = sourceFilePath;
  }

  public String getDestinationFilePath() {
    return destinationFilePath;
  }

  public void setDestinationFilePath(String destinationFilePath) {
    this.destinationFilePath = destinationFilePath;
  }

  public String getControlMessage() {
    return controlMessage;
  }

  public void setControlMessage(String controlMessage) {
    this.controlMessage = controlMessage;
  }

  @Override
  public String toString() {
    return "Task1Properties{" +
        "sourceFilePath='" + sourceFilePath + '\'' +
        ", destinationFilePath='" + destinationFilePath + '\'' +
        ", controlMessage='" + controlMessage + '\'' +
        '}';
  }
}
