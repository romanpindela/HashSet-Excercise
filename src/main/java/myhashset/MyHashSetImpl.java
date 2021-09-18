package myhashset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.stream.IntStream;

public class MyHashSetImpl implements MyHashSet{
    private final int maxNumberHashElements = 197;


    private LinkedList<Integer> date[] = new LinkedList[197];
    private LinkedList<LinkedList<Integer>> myHashSet;

    public MyHashSetImpl() {
        initMyHashSet();
    }

    private void initMyHashSet() {
        IntStream.range(0, maxNumberHashElements)
                .forEach(hashIndex -> {
                    myHashSet.add(hashIndex, new LinkedList<Integer>());
                });
    }

    @Override
    public void add(Integer i) {
        myHashSet.get(hashCode(i))
                .add(i);
    }

    @Override
    public boolean contains(Integer i) {
        return myHashSet.get(hashCode(i)).contains(i);
    }

    private int hashCode(Integer i){
        return i % maxNumberHashElements;
    }
}
