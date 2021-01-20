package org.dsadowsky;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    ArrayList<String> cloneGenetics = new ArrayList<String>();
	    ArrayList<Pair> result = new ArrayList<Pair>();
	    while(scanner.hasNext()) {
	        String temp = scanner.next();
	        if(temp.equals("end")) {
	            break;
            }
	        cloneGenetics.add(temp);
        }
	    int numX = 0, numY = 0, numG = 0, numH = 0, numW = 0;
	    for(int i = 0; i < cloneGenetics.size() - 3; i++) {
	        for(int j = i + 1; j < cloneGenetics.size() - 2; j++) {
	            for(int k = j + 1; k < cloneGenetics.size() - 1; k++) {
	                String singleCloneGene = "";
	                for(int l = k + 1; l < cloneGenetics.size(); l++) {
                        for(int m = 0; m < 6; m++) {
                            numX = 0; numY = 0; numG = 0; numH = 0; numW = 0;
                            ArrayList<Integer> geneCounts = new ArrayList<Integer>();
                            if(cloneGenetics.get(i).charAt(m) == 'g')
                                numG++;
                            else if(cloneGenetics.get(i).charAt(m) == 'x')
                                numX++;
                            else if(cloneGenetics.get(i).charAt(m) == 'y')
                                numY++;
                            else if(cloneGenetics.get(i).charAt(m) == 'h')
                                numH++;
                            else numW++;

                            if(cloneGenetics.get(j).charAt(m) == 'g')
                                numG++;
                            else if(cloneGenetics.get(j).charAt(m) == 'x')
                                numX++;
                            else if(cloneGenetics.get(j).charAt(m) == 'y')
                                numY++;
                            else if(cloneGenetics.get(j).charAt(m) == 'h')
                                numH++;
                            else
                                numW++;

                            if(cloneGenetics.get(k).charAt(m) == 'g')
                                numG++;
                            else if(cloneGenetics.get(k).charAt(m) == 'x')
                                numX++;
                            else if(cloneGenetics.get(k).charAt(m) == 'y')
                                numY++;
                            else if(cloneGenetics.get(k).charAt(m) == 'h')
                                numH++;
                            else
                                numW++;

                            if(cloneGenetics.get(l).charAt(m) == 'g')
                                numG++;
                            else if(cloneGenetics.get(l).charAt(m) == 'x')
                                numX++;
                            else if(cloneGenetics.get(l).charAt(m) == 'y')
                                numY++;
                            else if(cloneGenetics.get(l).charAt(m) == 'h')
                                numH++;
                            else
                                numW++;
                            geneCounts.add(numX);
                            geneCounts.add(numG);
                            geneCounts.add(numH);
                            geneCounts.add(numW);
                            geneCounts.add(numY);
                            String gene = "";
                            int maxCnt = 0;
                            for(int o = 0; o < geneCounts.size(); o++) {
                                if(geneCounts.get(o) > maxCnt) {
                                    if(o == 0)
                                        gene = "x";
                                    else if(o == 1) {
                                        gene = "g";
                                    }
                                    else if(o == 2) {
                                        gene = "h";
                                    }
                                    else if(o == 3) {
                                        gene = "w";
                                    }
                                    else {
                                        gene = "y";
                                    }
                                    maxCnt = geneCounts.get(o);
                                }
                                else if(geneCounts.get(o) == maxCnt) {
                                    if(o == 0)
                                        gene += "x";
                                    else if(o == 1) {
                                        gene += "g";
                                    }
                                    else if(o == 2) {
                                        gene += "h";
                                    }
                                    else if(o == 3) {
                                        gene += "w";
                                    }
                                    else {
                                        gene += "y";
                                    }
                                    maxCnt = geneCounts.get(o);
                                }
                            }
                            if(gene.contains("w"))
                                gene = "w";
                            if(gene.contains("x")) {
                                if(gene.contains("w"))
                                    gene += "x";
                                else
                                    gene = "x";
                            }
                            singleCloneGene += gene + " ";
                        }
                        result.add(new Pair(new String[] { cloneGenetics.get(i), cloneGenetics.get(j), cloneGenetics.get(k), cloneGenetics.get(l) }, singleCloneGene));
                        singleCloneGene = "";
                    }
                }
            }
        }
	    Iterator<Pair> it = result.iterator();
	    long gCount;
	    long yCount;
	    while(it.hasNext()) {
            System.out.print("\u001B[0m");
	        Pair temp = it.next();
	        String res = (String) temp.getValue();
	        String[] tempClones = (String[]) temp.getKey();
	        for(int i = 0; i < 4; i++) {
	            System.out.println(tempClones[i]);
            }
	        gCount = res.chars().filter(ch -> ch == 'g').count();
            yCount = res.chars().filter(ch -> ch == 'y').count();
            if(gCount >= 3 || yCount >= 3)
                System.out.println("\u001B[32m" + temp.getValue());
            else
	            System.out.println(temp.getValue());
        }
    }
}
