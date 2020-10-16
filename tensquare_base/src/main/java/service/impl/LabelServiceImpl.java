package service.impl;

import dao.LabelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Label;
import service.ILabelService;
import utils.IdWorker;

import java.util.List;

/**
 * 标签处理实现
 * @author chenshuai
 */
@Service
public class LabelServiceImpl implements ILabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    @Override
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    @Override
    public void add(Label label) {
        //设置ID
        label.setId( idWorker.nextId()+"" );
        labelDao.save(label);
    }

    @Override
    public void update(Label label) {
        labelDao.save(label);
    }

    @Override
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }
}
