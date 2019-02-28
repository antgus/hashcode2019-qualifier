package com.antgus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public long score;
    public List<Slide> slides;

    public String toOutputFormat() {
        StringBuffer buf = new StringBuffer(100000);
        buf.append(slides.size()).append("\n");
        for(Slide s: slides) {
            buf.append(s.p1);
            if (s.isVertical()) {
                buf.append(" ").append(s.p2);
            }
            buf.append("\n");
        }
        return buf.toString();
    }
}
