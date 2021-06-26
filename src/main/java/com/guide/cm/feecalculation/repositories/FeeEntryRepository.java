package com.guide.cm.feecalculation.repositories;

import com.guide.cm.feecalculation.entities.FeeCalculation;
import com.guide.cm.feecalculation.entities.FeeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeEntryRepository extends JpaRepository<FeeEntry,Long> {

}
