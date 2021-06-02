package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {

}
