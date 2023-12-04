package readexceltomysql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
public class ServiceGuide {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long categoryId;

    private Long vehicleType;

    @Column(columnDefinition = "Text")
    private String htmlContent;
}
