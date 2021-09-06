package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training360.guinessapp.dto.*;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private WorldRecordRepository repository;
    private RecorderService recorderService;
    private ModelMapper mapper;


    @Transactional
    public WorldRecordDto createRecord(WorldRecordCreateCommand command) {
        WorldRecord worldRecord = new WorldRecord(command.getDescription(), command.getValue(), command.getUnitOfMeasure(), command.getDateOfRecord());
        Recorder recorder = recorderService.getRecorderByID(command.getRecorderId());
        worldRecord.setRecorder(recorder);

        repository.save(worldRecord);

        return mapper.map(worldRecord, WorldRecordDto.class);
    }

    @Transactional
    public BeatWorldRecordDto beatRecord(long id, BeatWorldRecordCommand command) {
        WorldRecord record = getById(id);
        Recorder recorder = recorderService.getRecorderByID(command.getRecorderId());

        if (record.getValue() > command.getValue()) {
            throw new NotBeatenException();
        }
        BeatRecord beatRecord = new BeatRecord(record, recorder, command.getValue());
        record.setRecorder(recorder);
        record.setDateOfRecord(LocalDate.now());
        record.setValue(command.getValue());

        return mapper.map(beatRecord, BeatWorldRecordDto.class);
    }


    public WorldRecord getById(long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("World record not found", "World record not found with id:" + id));
    }
}
