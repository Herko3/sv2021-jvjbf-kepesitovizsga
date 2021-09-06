package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeatWorldRecordDto {

    private String description;
    private String unitOfMeasure;
    private String oldRecorderName;
    private double oldRecordValue;
    private String newRecorderName;
    private double newRecordValue;
    private double recordDifference;
    ;
}
