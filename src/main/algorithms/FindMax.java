package main.algorithms;

import java.util.LinkedList;
import java.util.List;

public class FindMax {

    /**
     * Метод поиска n-го максимума (уникального) в массиве.
     * Если n-го не существует, метод вернет минимальный возможный элемент массива.
     * Если входные параметры пустые вернет -2147483648
     * @param input входной массив;
     * @param nMax n-ый максимум
     */
    public static int findNThMax(int[] input, int nMax) {
        if (input == null || input.length == 0) {
            return Integer.MIN_VALUE;
        }
        List<Integer> maxValues = new LinkedList<>();
        for (int el : input) {
            addElement(maxValues, el, nMax);
        }
        return maxValues.get(maxValues.size()-1);
    }

    private static void addElement(List<Integer> descList, int source, int n) {
        int index = getIndexToPaste(descList, source, n);
        if(index != -1){
            descList.add(index, source);
            if(descList.size() - n > 0){
                descList.remove(descList.size()-1);
            }
        }
    }

    private static int getIndexToPaste(List<Integer> values, int el, int n){
        for (int i = 0; i < values.size(); i++) {
            if (el == values.get(i)) return -1;
            if (el > values.get(i)) {
                return i;
            }
        }
        if(values.size() < n){
            return values.size();
        }
        return -1;
    }
}
