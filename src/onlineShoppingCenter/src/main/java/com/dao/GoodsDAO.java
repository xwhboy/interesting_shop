package com.dao;

import com.entity.Goods;

/**
 * Created by Administrator on 2016/6/27.
 */
public interface GoodsDao {
    int saveGoods(Goods goods);
    boolean updateGoods(Goods goods);
    boolean delGoods(Goods goods);
    Goods getGoodsById(int id);
    boolean updateGoodsCountsByAttris(int attri_id1, int attri_id2, int count);

}
