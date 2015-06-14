package com.softwareengineering.accountmanager.model;

import com.softwareengineering.accountmanager.model.data.Account;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by kehanyang on 15/6/13.
 */
public class CacheManager {

    LinkedHashMap<String, Account> cache = new LinkedHashMap<String, Account>() {

        private int capacity = 100;

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    };

    public static void test() {

        new CacheManager().cache.put("test", new Account("root"));
        LinkedList test = new LinkedList();
        test.remove(1);
    }
}
