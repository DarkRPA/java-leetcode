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

            result[i] = arr[queries[i][0]];
            for(int subIndice = queries[i][0]+1; subIndice <= queries[i][1]; subIndice++){
                result[i] ^= arr[subIndice];
            }

            mapaCache.put(claveMap, result[i]);
            
        }

        return result;
    }
}
