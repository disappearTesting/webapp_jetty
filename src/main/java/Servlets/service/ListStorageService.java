package Servlets.service;

import Servlets.security.DigestHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ListStorageService {

    private final Map<String, String> listsStorage;

    private static ListStorageService instance;

    public static synchronized ListStorageService getInstance() {
        if(instance == null)
            instance = new ListStorageService();
        return instance;
    }

    private ListStorageService() {
        this.listsStorage = new ConcurrentHashMap<>();
    }

    public String addList(String bodyList) {

        String newKey = DigestHelper.getUUID();
        listsStorage.put(newKey, bodyList);
        return newKey;
    }

    public String getList(String key) throws ListNoFoundException {
        if(!listsStorage.containsKey(key)) {
            ListNoFoundException exception = new ListNoFoundException();
            throw exception;
        }
        return listsStorage.get(key);
    }
}
