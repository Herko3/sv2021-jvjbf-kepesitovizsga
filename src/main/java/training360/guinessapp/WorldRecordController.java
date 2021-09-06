package training360.guinessapp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/worldrecords")
@RequiredArgsConstructor
public class WorldRecordController {

    private final WorldRecordService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorldRecordDto createRecord(@Valid @RequestBody WorldRecordCreateCommand command) {
        return service.createRecord(command);
    }

    @PutMapping("/{id}/beatrecords")
    public BeatWorldRecordDto beatRecord(@PathVariable("id") long id, @RequestBody BeatWorldRecordCommand command) {
        return service.beatRecord(id, command);
    }

}
