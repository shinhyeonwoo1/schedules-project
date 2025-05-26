package quest.quest.API.DTO;

import quest.quest.API.Controller.ScheduleController;

public class ScheduleCreateRequestDTO {
    private long id;
    private String title;
    private String username;
    private String content;


    public ScheduleCreateRequestDTO(long id, String title, String username, String content) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }
    public long getId(){
        return id;
    }
}

