package com.lihd.imperial.court.service.api;

import com.lihd.imperial.court.entity.Memorials;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 20:04
 */
public interface MemorialsService {
    List<Memorials> txAllMemorials();

    Memorials txMemorialsById(int id);


    void txToReply(int id , String reply);

    void txUpdateStatus(int id);

    void txUpdateRenew();
}
