package quest.quest.API.Controller;

import org.springframework.web.bind.annotation.*;
import quest.quest.API.DTO.ScheduleCreateRequestDTO;
import quest.quest.API.DTO.ScheduleResponseDTO;
import quest.quest.API.Service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public String createSchedule(@RequestBody ScheduleCreateRequestDTO dto) {
        int result = scheduleService.createSchedule(dto);
        return result == 1 ? "일정 생성 성공" : "일정 생성 실패";
    }

    @GetMapping
    public List<ScheduleResponseDTO> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{scheduleId}")
    public ScheduleResponseDTO getSchedule(@PathVariable Long id) {
        return scheduleService.getSchedule(id);
    }

    @PatchMapping("/{scheduleId}")
    public String updateSchedule(@PathVariable Long id, @RequestBody ScheduleCreateRequestDTO dto) {
        int result = scheduleService.updateSchedule(id, dto);
        return result == 1 ? "일정 수정 성공" : "일정 수정 실패";
    }

    @DeleteMapping("/{scheduleId}")
    public String deleteSchedule(@PathVariable Long id) {
        int result = scheduleService.deleteSchedule(id);
        return result == 1 ? "일정 삭제 성공" : "일정 삭제 실패";
    }
}
