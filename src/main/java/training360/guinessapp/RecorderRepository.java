package training360.guinessapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training360.guinessapp.dto.RecorderShortDto;

import java.util.List;

public interface RecorderRepository extends JpaRepository<Recorder, Long> {

    @Query("select new training360.guinessapp.dto.RecorderShortDto(r.name,r.dateOfBirth) from Recorder r where r.name LIKE 'B%' or r.name like '%e%' order by r.dateOfBirth DESC ")
    List<RecorderShortDto> findAndSort();
}
