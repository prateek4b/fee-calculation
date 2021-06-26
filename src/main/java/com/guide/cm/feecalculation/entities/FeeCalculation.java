package com.guide.cm.feecalculation.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FeeCalculation {

    @OneToMany(mappedBy = "feeCalculation" , cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    List<FeeEntry> feeEntries = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String gstNo;

    public List<FeeEntry> getFeeEntries() {
        return feeEntries;
    }

    public void setFeeEntries(List<FeeEntry> feeEntries) {
        this.feeEntries = feeEntries;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }
}
