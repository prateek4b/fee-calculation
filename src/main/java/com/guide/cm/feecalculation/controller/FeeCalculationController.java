package com.guide.cm.feecalculation.controller;

import com.guide.cm.feecalculation.entities.FeeCalculation;
import com.guide.cm.feecalculation.entities.FeeEntry;
import com.guide.cm.feecalculation.repositories.FeeCalculationRepository;
import com.guide.cm.feecalculation.repositories.FeeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeeCalculationController {

    @Autowired
    FeeCalculationRepository feeCalculationRepository;


    @Autowired
    FeeEntryRepository feeEntryRepository;


    @PostMapping("/feeEntry/add")
    public FeeCalculation addFeeEntry(@RequestBody FeeEntry feeEntry) {

        FeeCalculation feeCalculation = feeCalculationRepository.findByGstNo(feeEntry.getGstNo());

        if (feeCalculation == null) {
            feeCalculation = new FeeCalculation();
            feeCalculation.setGstNo(feeEntry.getGstNo());

        }

        feeCalculation.getFeeEntries().add(feeEntry);
        feeEntry.setFeeCalculation(feeCalculation);

        return feeCalculationRepository.save(feeCalculation);
    }

    @GetMapping("feeEntry/get/{gstNo}")
    public FeeCalculation getFeeCalculation(@PathVariable String gstNo) {

        FeeCalculation feeCalculation = feeCalculationRepository.findByGstNo(gstNo);
        System.out.println(feeCalculation.getFeeEntries());
        return feeCalculation;

    }

    @GetMapping("feeEntry/getAll")
    public List<FeeCalculation> findAllFeeCalculation() {
        return feeCalculationRepository.findAll();
    }

    @DeleteMapping("feeEntry/delete/feeCalculation/{gstNo}")
    public void deleteFeeCalculation(@PathVariable String gstNo) {
        feeCalculationRepository.deleteByGstNo(gstNo);
    }


    @DeleteMapping("feeEntry/delete/feeCalculation/{gstNo}/feeEntry/{id}")
    public void deleteFeeEntry(@PathVariable long id) {
        feeEntryRepository.deleteById(id);
    }


    @PostMapping("feeEntry/update")
    public void updateFeeEntry(@RequestBody FeeEntry feeEntry) {
        FeeEntry feeEntryDb = feeEntryRepository.findById(feeEntry.getId()).get();

        if (feeEntry.getDate() != null) {
            feeEntryDb.setDate(feeEntry.getDate());
        }

        if (feeEntry.getFeeHead() != null) {
            feeEntryDb.setFeeHead(feeEntry.getFeeHead());
        }


        if (feeEntry.getFees() != 0L) {
            feeEntryDb.setFees(feeEntry.getFees());
        }

        if (feeEntry.getFeeType() != null) {
            feeEntryDb.setFeeType(feeEntry.getFeeType());
        }

        if (feeEntry.getReceiptNo() != 0L) {
            feeEntryDb.setReceiptNo(feeEntry.getReceiptNo());
        }

        if (feeEntry.getAssessMentYear() != null) {
            feeEntryDb.setAssessMentYear(feeEntry.getAssessMentYear());
        }

        feeEntryRepository.save(feeEntryDb);

    }


}
