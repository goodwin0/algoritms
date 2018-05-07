package test;

import main.algorithms.FindMax;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FindMaxTest {

    @Test
    public void findNThMaxTest(){

        final int[] dataError = new int[]{};
        assertEquals(FindMax.findNThMax(dataError,1),Integer.MIN_VALUE);

        final int[] dataError2 = null;
        assertEquals(FindMax.findNThMax(dataError2,1),Integer.MIN_VALUE);

        final int [] dataSingleElement = new int[]{1};
        assertEquals(FindMax.findNThMax(dataSingleElement,1),1);
        assertEquals(FindMax.findNThMax(dataSingleElement,10),1);

        final int[] data1 = new int[]{10,10,10,7,6,5,4,3,2,1};
        assertEquals(FindMax.findNThMax(data1,1),10);
        assertEquals(FindMax.findNThMax(data1,2),7);
        assertEquals(FindMax.findNThMax(data1,10),1);

        final int[] data2 = new int[]{10,10,10,10};
        assertEquals(FindMax.findNThMax(data2,1),10);
        assertEquals(FindMax.findNThMax(data2,5),10);
        assertEquals(FindMax.findNThMax(data2,10),10);

        // Тест на рандомном наборе
        final int size = 100;
        List <Integer> helperList = new ArrayList<>(size);
        Random random =  new Random();
        for(int i = 0 ; i<size; i++){
            helperList.add(random.nextInt());
        }

        //
        int [] dataRandomNumbers = new int [size];
        for (int i = 0; i<helperList.size(); i++){
            dataRandomNumbers[i] = helperList.get(i);
        }

        // избавляемся дубликатов
        Set<Integer> helperSet = new HashSet<>();
        helperSet.addAll(helperList);
        helperList.clear();
        helperList.addAll(helperSet);
        helperList.sort((o1, o2) -> (o2 > o1) ? +1 : -1);

        for(int i = 0; i < helperList.size(); i++){
            assertEquals(FindMax.findNThMax(dataRandomNumbers,i+1),(int) helperList.get(i));
        }
    }
}
