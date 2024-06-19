package by.tishalovichm.wikimedia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "recent_change")
@Data
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String content;

}
