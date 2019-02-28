package com.antgus;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<String> files = Arrays.asList("a_example.txt", "b_lovely_landscapes.txt", "c_memorable_moments.txt", "d_pet_pictures.txt", "e_shiny_selfies.txt");
        String inputFolder = "/Users/antoniogusmao/projects/hashcode2018-qualifier/input/";
        String outputFolder = "/Users/antoniogusmao/projects/hashcode2018-qualifier/output/";

        //long totalScore = 0;
        try {
            for(String f: files) {
                //totalScore += solve(inputFolder, outputFolder, f).score;
                solve(inputFolder, outputFolder, f);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("Total score= " + totalScore);
    }

    public static void solve(String inputFolder, String outputFolder, String filename) throws java.io.FileNotFoundException {
        String inFile = inputFolder + filename;
        String outFile = outputFolder + filename + ".out";
        RawInput input = InputReader.readInput(inFile);
        //System.out.println(input);
//        System.out.println(filename + ": num vehicles= " + input.numVehicles + "; num rides= " + input.rides.size());
//
//        Solver solver = new Solver(input);
//        Solution solution = solver.solve();
//
//        solution.toString();
//
//        System.out.println(filename + ", score= " + solution.score);
//
//        try (PrintWriter out = new PrintWriter(outFile)) {
//            out.println(solution.toString());
//        }
//        return solution;
        //throw new UnsupportedOperationException("TODO");
    }
}
