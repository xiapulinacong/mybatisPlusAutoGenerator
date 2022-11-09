package com;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HahaTest2 {
    private final int i,j,k;

    public HahaTest2(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HahaTest2 hahaTest2 = (HahaTest2) o;
        return i == hahaTest2.i && j == hahaTest2.j && k == hahaTest2.k;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j, k);
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
        Set<HahaTest2> hahaTests = new HashSet<HahaTest2>();
        hahaTests.add(new HahaTest2(1,1,1));
        hahaTests.add(new HahaTest2(1,1,2));
        hahaTests.add(new HahaTest2(1,2,1));
        hahaTests.add(new HahaTest2(1,2,2));
        hahaTests.add(new HahaTest2(2,2,1));
        hahaTests.add(new HahaTest2(2,2,2));
        for (HahaTest2 a:hahaTests){
            System.out.println(a);
        }

    }
}
