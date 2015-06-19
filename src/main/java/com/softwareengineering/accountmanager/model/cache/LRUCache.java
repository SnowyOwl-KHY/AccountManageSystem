package com.softwareengineering.accountmanager.model.cache;

import com.softwareengineering.accountmanager.model.data.Account;

import java.util.HashMap;

/**
 * Created by kehanyang on 15/6/14.
 */
public class LRUCache {

    CacheList<Account> cacheList = new CacheList<Account>();

    HashMap<String, CacheList.Node<Account>> cacheMap = new HashMap<String, CacheList.Node<Account>>();

    private int capacity = 500;

    private static LRUCache instance = null;

    public static LRUCache getLRUCache() {
        if (instance == null) {
            instance = new LRUCache();
        }
        return instance;
    }

    private LRUCache() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
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
        CacheList.Node<Account> node =  cacheMap.remove(eldestAccountName);
        Account account = node.item;
        return account;
    }

    public Account add(Account account) {
        CacheList.Node<Account> node = cacheList.addFirst(account);
        cacheMap.put(account.getAccountName(), node);
        if (cacheMap.size() > capacity) {
            return deleteEldestItem();
        }
        return null;
    }

    public static void main(String[] args) {

    }
}


