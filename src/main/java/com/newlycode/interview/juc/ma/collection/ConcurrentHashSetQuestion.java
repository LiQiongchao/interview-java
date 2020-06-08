package com.newlycode.interview.juc.ma.collection;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 利用ConcurrentHashMap 实现 ConcurrentSet
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/8 20:00
 */
public class ConcurrentHashSetQuestion {

    public static void main(String[] args) {

    }


//    private static class ConcurrentHashSet<E> extends AbstractSet<E> {
    private static class ConcurrentHashSet<E> implements Set<E> {

        private final Object OBJET = new Object();

        ConcurrentHashMap<E, Object> hashMap = new ConcurrentHashMap<E, Object>();

        private Set<E> keySet() {
            return hashMap.keySet();
        }

        @Override
        public int size() {
            return keySet().size();
        }

        @Override
        public boolean isEmpty() {
            return keySet().isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public boolean add(E o) {
            return hashMap.putIfAbsent(o, OBJET) == null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean removeAll(Collection c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection c) {
            return false;
        }

        @Override
        public boolean containsAll(Collection c) {
            return false;
        }

        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }
    }

}
