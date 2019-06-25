package com.jonstites.algorithms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashSetTest {

    @Test
    public void isEmptyTest() {
        HashSet<Integer> hash_set = new HashSet<>();
        assert(hash_set.isEmpty());

        hash_set.add(42);
        assert(!hash_set.isEmpty());

        hash_set.remove(42);
        assert(hash_set.isEmpty());
    }

    @Test
    public void containsTest() {
        HashSet<Integer> hash_set = new HashSet<>();
        assert(!hash_set.contains(42));

        hash_set.add(42);
        assert(hash_set.contains(42));

        assert(!hash_set.contains(111));

        hash_set.remove(42);
        assert(!hash_set.contains(42));
    }

    @Test
    public void sizeTest() {
        HashSet<Integer> hash_set = new HashSet<>();
        assertEquals(hash_set.size(), 0);

        hash_set.add(123);
        assertEquals(hash_set.size(), 1);

        hash_set.add(456);
        assertEquals(hash_set.size(), 2);

        hash_set.remove(123);
        assertEquals(hash_set.size(), 1);

        hash_set.remove(456);
        assertEquals(hash_set.size(), 0);
    }    

    @Test
    public void clearTest() {
        HashSet<String> hash_set = new HashSet<>();
        hash_set.clear();

        assertEquals(hash_set.size(), 0);

        hash_set.add("abc");
        hash_set.clear();

        assertEquals(hash_set.size(), 0);
        assert(!hash_set.contains("abc"));
    }

    @Test
    public void removeTest() {
        HashSet<String> hash_set = new HashSet<>();
        assert(!hash_set.remove("abc"));

        hash_set.add("abc");
        assert(!hash_set.remove("123"));
        assert(hash_set.remove("abc"));
        assert(!hash_set.remove("abc"));
    }

    @Test
    public void addTest() {
        HashSet<Integer> hash_set = new HashSet<>();
        
        assert(hash_set.add(42));
        assert(!hash_set.add(42));

        assert(hash_set.add(123));
        assert(!hash_set.add(123));

        hash_set.remove(42);
        assert(!hash_set.add(123));
        assert(hash_set.add(42));
    }
}