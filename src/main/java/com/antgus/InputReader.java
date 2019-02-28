package com.antgus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InputReader {
    private static InputReader ourInstance = new InputReader();

    public static InputReader getInstance() {
        return ourInstance;
    }

    private InputReader() {
    }

    public static RawInput readInput(String filename) {
        FastScanner sc;
        try {
            File file = new File(filename);
            sc = new FastScanner(new InputStreamReader(new FileInputStream(file)));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        RawInput input = new RawInput();

        int numPhotos = sc.nextInt(); // <= 10^5

        Map<String, Integer> tags = new HashMap<>(1000);
        int nUniqueTags = 0;
        int totalTags = 0;
        List<Photo> photos = new ArrayList<>(numPhotos);
        for(int i=0; i < numPhotos; i++) {
            boolean isVertical = sc.next().equals("V");
            int numTags = sc.nextInt();
            if(numTags == 0) {
                System.out.println("Photo without tags!");
                throw new AssertionError("?");
            }
            totalTags += numTags;
            int[] photoTags = new int[numTags];
            for(int k=0; k < numTags; k++) {
                String tagStr = sc.next();
                int tag = tags.getOrDefault(tagStr, nUniqueTags);
                if (tag == nUniqueTags) {
                    tags.put(tagStr, nUniqueTags);
                    nUniqueTags++;
                }
                photoTags[k] = tag;
            }
            Photo p = new Photo();
            p.id = i;
            p.isVertical = isVertical;
            p.tags = photoTags;
            Arrays.sort(p.tags);
            photos.add(p);
        }
        System.out.println(filename + " nPhotos=" + numPhotos + "; nUniqueTags=" + nUniqueTags + "; totalTags="+totalTags);
        return input;
    }

}
