package by.tishalovichm.wikimedia.repository;

import by.tishalovichm.wikimedia.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
