package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import java.util.List;

@Service
@AllArgsConstructor
public class RecorderService {

    private RecorderRepository repository;
    private ModelMapper mapper;

    public List<RecorderShortDto> getRecorders() {
        return repository.findAndSort();
    }

    public RecorderDto createRecorder(RecorderCreateCommand command) {
        Recorder recorder = new Recorder(command.getName(), command.getDateOfBirth());
        repository.save(recorder);
        return mapper.map(recorder, RecorderDto.class);
    }

    public Recorder getRecorderByID(long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Recorder not found", "Recorder not found with id: " + id));
    }
}
