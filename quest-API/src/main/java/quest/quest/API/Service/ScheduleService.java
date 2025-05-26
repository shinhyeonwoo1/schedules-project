package quest.quest.API.Service;

import org.springframework.stereotype.Service;
import quest.quest.API.DTO.ScheduleCreateRequestDTO;
import quest.quest.API.DTO.ScheduleResponseDTO;
import quest.quest.API.Repository.ScheduleRepository;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public int createSchedule(ScheduleCreateRequestDTO dto) {
        return scheduleRepository.save(dto);
    }

    public List<ScheduleResponseDTO> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public ScheduleResponseDTO getSchedule(Long id) {
        return scheduleRepository.findById(id);
    }

    public int updateSchedule(Long id, ScheduleCreateRequestDTO dto) {
        return scheduleRepository.update(id, dto);
    }

    public int deleteSchedule(Long id) {
        return scheduleRepository.delete(id);
    }
}
