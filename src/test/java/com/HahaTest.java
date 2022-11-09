package com;

import lombok.val;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HahaTest {
    private final int i,j,k;

    public HahaTest(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    @Override
    public boolean equals(Object o) {

        return o instanceof HahaTest && ((HahaTest)o).j==j;
    }

    @Override
    public int hashCode() {
        return i;
    }

    @Override
    public String toString() {
        return "HahaTest{" +
                "i=" + i +
                ", j=" + j +
                ", k=" + k +
                '}';
    }

    public static void main(String[] args) {
        Set<HahaTest> hahaTests = new HashSet<HahaTest>();
        hahaTests.add(new HahaTest(1,1,1));
        hahaTests.add(new HahaTest(1,1,2));
        hahaTests.add(new HahaTest(1,2,1));
        hahaTests.add(new HahaTest(1,2,2));
        hahaTests.add(new HahaTest(2,2,1));
        hahaTests.add(new HahaTest(2,2,2));
        for (HahaTest a:hahaTests){
            System.out.println(a);
        }

    }
}
