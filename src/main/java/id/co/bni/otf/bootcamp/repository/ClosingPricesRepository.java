package id.co.bni.otf.bootcamp.repository;

import id.co.bni.otf.bootcamp.entity.ClosingPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface ClosingPricesRepository extends JpaRepository <ClosingPrice, Long> {
    List<ClosingPrice> findByDateBetween(LocalDate start, LocalDate to);
}
