package com.antgus;

import java.util.Arrays;

public class Sets {
    private static int[] buf = new int[1000];
    private static int bufLen = 0;

    public static int intersectionSize(int[] tags1, int[] tags2) {
        // note:: assumes tags1 and tags2 are sorted
        int count = 0;
        int i1 = 0;
        int i2 = 0;

        while(i1 < tags1.length && i2 < tags2.length) {
            while (i1 < tags1.length && tags1[i1] < tags2[i2]) i1++;
            if (i1 == tags1.length) break;
            while (i2 < tags2.length && tags2[i2] < tags1[i1]) i2++;
            if (i2 == tags2.length) break;
            count++;
            i1++;
            i2++;
        }
        return count;
    }

    public static int unionSize(int[] a, int[] b) {
        unionBuf(a, b);
        return bufLen;
    }

    public static int[] union(int[] a , int[] b) {
        unionBuf(a, b);
        return Arrays.copyOf(buf, bufLen);
    }

    private static void unionBuf(int[] a, int[] b) {
        int iB = 0;
        int iA = 0;

        if(buf.length < a.length + b.length) {
            buf = new int[a.length + b.length + 100];
        }

        int len = 0;

        while(iA < a.length && iB < b.length) {
            while (iA < a.length && a[iA] < b[iB]) {
                buf[len++] = a[iA];
                iA++;
            }
            if (iA == a.length) break;
            while (iB < b.length && b[iB] < a[iA]) {
                buf[len++] = b[iB];
                iB++;
            }
            if (iB == b.length) break;
            // they are the same
            while(iA < a.length && iB < b.length && a[iA] == b[iB]) {
                buf[len++] = a[iA];
                iA++;
                iB++;
            }
        }
        while (iA < a.length) {
            buf[len] = a[iA];
            iA++;
            len++;
        }
        while (iB < b.length) {
            buf[len] = b[iB];
            iB++;
            len++;
        }
        bufLen = len;
    }
}
