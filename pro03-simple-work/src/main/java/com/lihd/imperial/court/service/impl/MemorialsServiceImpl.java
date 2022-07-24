package com.lihd.imperial.court.service.impl;

import com.lihd.imperial.court.dao.api.MemorialsDAO;
import com.lihd.imperial.court.dao.impl.MemorialsDAOImpl;
import com.lihd.imperial.court.entity.Memorials;
import com.lihd.imperial.court.service.api.MemorialsService;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 20:05
 */
public class MemorialsServiceImpl implements MemorialsService {
    private MemorialsDAO memorialsDAO = new MemorialsDAOImpl();
    @Override
    public List<Memorials> txAllMemorials() {
        return memorialsDAO.selectAllMemorials();
    }

    @Override
    public Memorials txMemorialsById(int id) {
        return memorialsDAO.selectMemorialsById(id);
    }

    @Override
    public void txToReply(int id, String reply) {
        memorialsDAO.updateToReply(id, reply);
    }

    @Override
    public void txUpdateStatus(int id) {
        memorialsDAO.updateStatus(id);
    }

    @Override
    public void txUpdateRenew() {
        memorialsDAO.updateRenew();
    }
}
