package com.jonstites.algorithms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashSetTest {

    @Test
    public void IsEmptyTest() {
        HashSet hash_set = new HashSet();
        assert(hash_set.isEmpty());

        hash_set.add(42);
        assert(!hash_set.isEmpty());

        hash_set.remove(42);
        assert(hash_set.isEmpty());
    }

    @Test
    public void ContainsTest() {
        HashSet hash_set = new HashSet();
        assert(!hash_set.contains(42));

        hash_set.add(42);
        assert(hash_set.contains(42));

        assert(!hash_set.contains(111));

        hash_set.remove(42);
        assert(!hash_set.contains(42));
    }

    
}