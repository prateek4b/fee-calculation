package com.guide.cm.feecalculation.repositories;

import com.guide.cm.feecalculation.entities.FeeCalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeCalculationRepository extends JpaRepository<FeeCalculation,Long> {

    FeeCalculation findByGstNo(String gstNo);

    void deleteByGstNo(String gstNo);
}
