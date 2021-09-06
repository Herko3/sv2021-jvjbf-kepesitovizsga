package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldRecordDto {

    private long id;
    private String description;
    private double value;
    private String unitOfMeasure;
    private LocalDate dateOfRecord;
    private String recorderName;

}
