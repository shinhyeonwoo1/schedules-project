package quest.quest.API.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import quest.quest.API.DTO.ScheduleCreateRequestDTO;
import quest.quest.API.DTO.ScheduleResponseDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(ScheduleCreateRequestDTO dto) {
        String sql = "INSERT INTO schedule (username, title, content, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
        LocalDateTime now = LocalDateTime.now();

        return jdbcTemplate.update(
                sql,
                dto.getUsername(),
                dto.getTitle(),
                dto.getContent(),
                Timestamp.valueOf(now),
                Timestamp.valueOf(now)
        );
    }

    public List<ScheduleResponseDTO> findAll() {
        String sql = "SELECT * FROM schedule";
        return jdbcTemplate.query(sql, scheduleRowMapper());
    }

    public ScheduleResponseDTO findById(Long id) {
        String sql = "SELECT * FROM schedule WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, scheduleRowMapper(), id);
    }

    public int update(Long id, ScheduleCreateRequestDTO dto) {
        String sql = "UPDATE schedule SET title = ?, content = ?, updated_at = ? WHERE id = ?";
        return jdbcTemplate.update(
                sql,
                dto.getTitle(),
                dto.getContent(),
                Timestamp.valueOf(LocalDateTime.now()),
                id
        );
    }

    public int delete(Long id) {
        String sql = "DELETE FROM schedule WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    private RowMapper<ScheduleResponseDTO> scheduleRowMapper() {
        return new RowMapper<ScheduleResponseDTO>() {
            @Override
            public ScheduleResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDTO(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
            }
        };
    }
}