package com.eggip.lock;

import java.util.ArrayList;
import java.util.List;

public class CachedFactor {

    private volatile OneValueCache cache;  // 9 [3, 3]

    public List<Integer> service(int i) {
        if (cache != null && cache.getFactors(i) != null) {
            // 缓存命中
            return cache.getFactors(i);
        } else {
            List<Integer> intList = factor(i);
            cache = new OneValueCache(i, intList);
            return intList;
        }

    }

    public static class OneValueCache {
        private final int cachedI;
        private final List<Integer> cachedFactors;

        public OneValueCache(int cachedI, List<Integer> cachedFactors) {
            this.cachedI = cachedI;
            this.cachedFactors = cachedFactors;
        }

        public List<Integer> getFactors(int i) {
            if (cachedI == i) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(cachedFactors);
                return temp;
            } else {
                return null;
            }
        }
        
    }


    public List<Integer> factor(int i) {
        return null;
    }


    
    
}