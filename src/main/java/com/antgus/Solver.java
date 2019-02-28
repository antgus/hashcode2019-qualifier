package com.antgus;

import java.util.*;
import java.util.stream.Collectors;

public class Solver {

    public Solution solve(RawInput input) {
        ArrayList<Photo> photos = new ArrayList<>(input.photos);
        //Collections.shuffle(photos);

        List<Photo> verticals = photos.stream().filter(p -> p.isVertical).collect(Collectors.toList());
        List<Slide> slides = photos.stream().filter(p -> !p.isVertical).map(Slide::new).collect(Collectors.toList());

        slides.addAll(convertVerticalsToSlides(verticals));

        int nMaxChecks = 500;
        List<Slide> slides = new ArrayList<>(photos.size());
        Slide s = new Slide();
        s.p1 = photos.get(0);
        if(s.isVertical()) {
            s.p2 = findLargestUnionVertical(s.p1, photos, 1);
        }
        while(photos.size() > 0) {
            int limit = Math.min(nMaxChecks, photos.size());
            for (int k = 0; k < limit; k++) {
                Sets.intersectionSize(slides.)
//                swap(photos, iBest, photos.size() - 1);
                photos.remove(photos.size() - 1); // remove the last element
            }
        }
        throw new UnsupportedOperationException("TODO");
    }

    private static List<Slide> convertVerticalsToSlides(List<Photo> verticals) {
        List<Slide> slides = new ArrayList<>(verticals.size());
        Collections.shuffle(verticals);
        while(!verticals.isEmpty()) {
            Photo v1 = verticals.get(0);
            findLargestUnionVertical(v1, verticals, 1);
            verticals.set(0, verticals.get(verticals.size()-1));
            verticals.set(0, verticals.get(verticals.size()-1));

        }

    }

    private static int findLargestUnionVertical(Photo p, List<Photo> photos, int iStart) {
        assert(p.isVertical);
        int iMax = iStart;
        int maxUnionSize=0;
        int nMax = Math.max(photos.size(), 400);
        for(int i=iStart; i < nMax; i++) {
            int unionSize = Sets.unionSize(p.tags, photos.get(i).tags);
            if(unionSize > maxUnionSize) {
                maxUnionSize = unionSize;
                iMax = i;
            }
        }
        return iMax;
    }

    private static int transitionScore(Slide a, Slide b) {

    }

    private static void swap(ArrayList<Photo> photos, int i1, int i2) {
        Photo p = photos.get(i1);
        photos.set(i1, photos.get(i2));
        photos.set(i2, p);
    }
}
