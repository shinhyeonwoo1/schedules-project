package quest.quest.API.Controller;

import org.springframework.web.bind.annotation.*;
import quest.quest.API.DTO.ScheduleRequestDTO;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    //속



    //생



    //기
    @PostMapping("/schedules")
    public String scheduleAPI(@RequestBody ScheduleRequestDTO scheduleRequestDTO){

        return "";



    }
    @GetMapping("/schedules/{scheduleID}")
    public void scheduleInquiry(){


    }
    @GetMapping("/schedules")
    public void scheduleinquiry(){


    }
    @PutMapping("/schedules/{scheduleID}")
    public void scheduleUpdate(){


    }
    @DeleteMapping("/schedules/{scheduleID}")
    public void scheduledelete(){

    }

}
