package com.lihd.imperial.court.dao.api;

import com.lihd.imperial.court.entity.Memorials;

import java.util.List;

public interface MemorialsDAO {

    List<Memorials> selectAllMemorials();


    Memorials selectMemorialsById(int id);


    void updateToReply(int id , String reply);

    void updateStatus(int id);

    void updateRenew();

}
