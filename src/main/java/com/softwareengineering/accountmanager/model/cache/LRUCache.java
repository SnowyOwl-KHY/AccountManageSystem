package com.softwareengineering.accountmanager.model.cache;

import com.softwareengineering.accountmanager.model.data.Account;

import java.util.HashMap;

/**
 * Created by kehanyang on 15/6/14.
 */
public class LRUCache {

    CacheList<Account> cacheList = new CacheList<Account>();

    HashMap<String, CacheList.Node<Account>> cacheMap = new HashMap<String, CacheList.Node<Account>>();

    private int capacity = 100;

    public LRUCache() {
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Account accessItem(String accountName) {
        CacheList.Node<Account> node = cacheMap.get(accountName);
        if (node == null) {
            return null;
        }
        cacheList.remove(node);
        cacheList.addFirst(node);
        return node.item;
    }

    private Account deleteEldestItem() {
        String eldestAccountName = cacheList.removeLast().item.getAccountName();
        return cacheMap.remove(eldestAccountName).item;
    }

    public void add(Account account) {
        CacheList.Node<Account> node = cacheList.addFirst(account);
        cacheMap.put(account.getAccountName(), node);
        if (cacheMap.size() > capacity) {
            deleteEldestItem();
        }
    }

    public static void main(String[] args) {

    }

    public static void testCacheList() {
        CacheList<String> test = new CacheList<String>();
        CacheList.Node node = test.addFirst("blabla1");
        test.addLast("test2");
        test.addFirst("addfirst2");
        test.insertBefore(node, "insertBefore1");
        test.insertAfter(node, "insertAfter1");
        System.out.println(test);
        test.remove(node);
        System.out.println(test);
        test.removeFirst();
        System.out.println(test);
        test.removeLast();
        System.out.println(test);
    }

}


