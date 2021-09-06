package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.Recorder;
import training360.guinessapp.WorldRecord;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeatRecord {

    private String description;
    private String unitOfMeasure;
    private Recorder oldRecorder;
    private double oldRecordValue;
    private Recorder newRecorder;
    private double newRecordValue;
    private double recordDifference;

    public BeatRecord(WorldRecord worldRecord, Recorder newRecorder, double newRecordValue) {
        description = worldRecord.getDescription();
        unitOfMeasure = worldRecord.getUnitOfMeasure();
        oldRecorder = worldRecord.getRecorder();
        oldRecordValue = worldRecord.getValue();
        this.newRecorder = newRecorder;
        this.newRecordValue = newRecordValue;
        recordDifference = newRecordValue - oldRecordValue;
    }
}
