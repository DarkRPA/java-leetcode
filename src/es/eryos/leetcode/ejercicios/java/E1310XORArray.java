package es.eryos.leetcode.ejercicios.java;

import java.util.HashMap;

public class E1310XORArray {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1,3,4,8};
        int[][] queries = new int[][]{new int[]{0,1}, new int[]{1,2}, new int[]{0,3},new int[]{3,3}};

        int[] resultado = xorQueries(arr, queries);

        System.out.println();
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        HashMap<String, Integer> mapaCache = new HashMap<>();


        for(int i = 0; i < queries.length; i++){
            String claveMap = String.format("%d%d", queries[i][0], queries[i][1]);

            if(mapaCache.containsKey(claveMap)){
                result[i] = mapaCache.get(claveMap);
                continue;
            }

            result[i] = getXORQuery(queries[i][0], 0, queries[i][1], arr);
            mapaCache.put(claveMap, result[i]);
            
        }

        return result;
    }

    public static int getXORQuery(int i, int bitActual, int max, int[] arr){
        if(i < max) return getXORQuery(i+1, (bitActual==0)?arr[i]:(bitActual ^ arr[i]), max, arr);
        return bitActual ^ arr[i];
    }
}
