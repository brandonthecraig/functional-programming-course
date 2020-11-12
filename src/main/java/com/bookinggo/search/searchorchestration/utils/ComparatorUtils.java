package com.bookinggo.search.searchorchestration.utils;

import com.bookinggo.search.searchorchestration.service.vehicle.suitcases.AcrissSuitcaseDataEntry;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ComparatorUtils {

    public static Comparator<AcrissSuitcaseDataEntry> acrissSuitcaseDataComparator() {
        return (o1, o2) -> {
            int bigSuitCasesComparison = Integer.compare(o1.getLargeSuitcase(), o2.getLargeSuitcase());
            if (bigSuitCasesComparison == 0) {
                return Integer.compare(o1.getSmallSuitcase(), o2.getSmallSuitcase());
            }
            return bigSuitCasesComparison;
        };
    }
}
