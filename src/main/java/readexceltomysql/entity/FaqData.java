package readexceltomysql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ServiceFAQ")
public class FaqData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long categoryId;

    @Column(length = 320212)
    private String category;
    @Column(length = 320212)
    private String question;
    @Column(length = 320212)
    private String answer;

    public FaqData(Long id, Long categoryId, String category, String question, String answer) {
        this.id = id;
        this.categoryId = categoryId;
        this.question = question;
        this.answer = answer;
    }

    public FaqData() {
    }
}
