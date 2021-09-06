package training360.guinessapp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/recorders")
@RequiredArgsConstructor
public class RecorderController {

    private final RecorderService service;

    @GetMapping
    public List<RecorderShortDto> getRecorders() {
        return service.getRecorders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecorderDto createRecorder(@Valid @RequestBody RecorderCreateCommand command){
        return service.createRecorder(command);
    }
}
