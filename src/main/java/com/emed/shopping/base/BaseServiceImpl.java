package com.emed.shopping.base;

import com.emed.shopping.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Create with project [hospital]
 * User: 周润斌
 * Date: 2017-06-30
 * Time: 下午 2:57
 * Description:
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected Mapper<T> mapper;

    @Override
    public List<T> select(T record) {

        return mapper.select(record);
    }

    @Override
    public List<T> select(T record, String order) {
        Example example = new Example(record.getClass(), false);
        Example.Criteria criteria = example.createCriteria();
        dealWithExample(record, criteria);
        example.setOrderByClause(order);
        return mapper.selectByExample(example);
    }

    @Override
    public int selectCount(T record) {
        return mapper.selectCount(record);
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public T selectOne(T record) {
        List<T> list = mapper.select(record);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }


    @Override
    public int insert(T record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int delete(T key) {
        return mapper.delete(key);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int save(T record) {
        int count = 0;
        Class clazz = record.getClass();
        //获取类中的所有属性
        Field[] fs = clazz.getDeclaredFields();
        Object id = null;
        for (int i = 0; i < fs.length; i++) {
            try {
                Field f = fs[i];
                f.setAccessible(true); //设置些属性是可以访问的
                if (f.getName().equals("deleteStatus")) {
                    f.set(record, "0");
                }
                if(f.getName().equals("createTime")){
                    f.set(record,new Date());
                }
                if (f.getName().equals("id")) {
                    id = f.get(record);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (CommonUtil.isEmpty(id)) {
            insert(record);
        } else {
            updateByPrimaryKeySelective(record);
        }
        return count;
    }

    @Override
    public PageInfo<T> selectPage(int pageNum, int pageSize, T record, String orderStr) {
        Example example = new Example(record.getClass(), false);
        Example.Criteria criteria = example.createCriteria();
        dealWithExample(record, criteria);
        example.setOrderByClause(orderStr);
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = mapper.selectByExample(example);
        return new PageInfo<T>(list);
    }

    public void dealWithExample(T record, Example.Criteria criteria) {
        Class clazz = record.getClass();
        //获取类中的所有属性
        Field[] fs = clazz.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); //设置些属性是可以访问的
            try {
                if (StringUtils.isEmpty(f.get(record))) {
                    continue;
                }
                criteria.andEqualTo(f.getName(), f.get(record));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public PageInfo<T> selectPage(int pageNum, int pageSize, T record) {

        PageHelper.startPage(pageNum, pageSize);
        List<T> list = mapper.selectByExample(null);
        return new PageInfo<T>(list);
    }

    private T notNullStrVerify(T record) {
        return null;
    }

    @Override
    public <M> int updateDelFlagToDelStatusById(Class<M> bean, Long id) {
        return 0;
    }

    @Override
    public <M> int beforeDelete(Class<M> bean, Map<String, Object> params) {
        return 0;
    }

    @Override
    public int beforeDeleteTreeStructure(Object id, String Field, Class<?>[] beans) {
        return 0;
    }
}
