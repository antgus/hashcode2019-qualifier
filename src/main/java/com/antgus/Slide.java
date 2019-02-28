package com.antgus;

public class Slide {
    public Photo p1;
    public Photo p2 = null;

    public Slide(Photo p1) {
        this.p1 = p1;
    }

    public Slide(Photo p1, Photo p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean isVertical() {
        return p1.isVertical;
    }
}
