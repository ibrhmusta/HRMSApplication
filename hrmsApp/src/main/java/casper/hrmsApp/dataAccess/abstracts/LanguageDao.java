package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language,Integer> {
}
