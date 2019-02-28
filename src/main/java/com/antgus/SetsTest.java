package com.antgus;

import org.junit.jupiter.api.Test;

class SetsTest {

    @org.junit.jupiter.api.Test
    void intersectionCount() {
        int[] a = {1,2,3};
        int[] b = {0,2,3,4,5};
        assert(Sets.intersectionSize(a, b) == 2);
        assert(Sets.intersectionSize(b, a) == 2);
    }

    @Test
    void union() {
        int[] a = {1,2,3};
        int[] b = {0,2,3,4,5};
        assert(Sets.union(a, b).length == 6);
        assert(Sets.union(b, a).length == 6);
    }

    @Test
    void unionSize() {
        int[] a = {1,2,3};
        int[] b = {0,2,3,4,5};
        assert(Sets.unionSize(a,b) == 6);
        assert(Sets.unionSize(b,a) == 6);
    }
}