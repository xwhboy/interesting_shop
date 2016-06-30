package com.dao;

import com.entity.Sort;

import java.util.List;

/**
 * Created by ZK on 6/26/16.
 */
public interface SortDAO {
    int saveSort(Sort sort);
    boolean updateSort(Sort sort);
    List<Sort> getSortList(int pagenum, int pagesize);
    boolean delSort(Sort sort);
    List<Sort> getSortBySortName(String sort_name);
    Sort getSortById(int id);
}
