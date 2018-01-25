package com.emed.shopping.base;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Create with project [hospital]
 * User: 周润斌
 * Date: 2017-06-30
 * Time: 下午 2:55
 * Description:
 */
public interface BaseService<T> {

    /**
     * 根据实体类不为null的字段进行查询,条件全部使用=号and条件
     * @param <T extend T>
     */
    List<T> select(T record);

    List<T> selectByExample(Example example);

    List<T> select(T record, String order);
    /**
     * 根据实体类不为null的字段查询总数,条件全部使用=号and条件
     * @param <T extend T>
     */
    int selectCount(T record);

    /**
     * 根据主键进行查询,必须保证结果唯一
     *  单个字段做主键时,可以直接写主键的值
     *  联合主键时,key可以是实体类,也可以是Map
     * @param <T extend T>
     */
    T selectByPrimaryKey(Object key);

    T selectOne(T record);

     /**
     *  插入一条数据
     *	支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)
     *	优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
     * @param <T extend T>
     */
    int insert(T record);

    /**
     * 插入一条数据,只插入不为null的字段,不会影响有默认值的字段
     *支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)
     *优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
     * @param <T extend T>
     */
    int insertSelective(T record);

    /**
     * 根据实体类不为null的字段进行查询,条件全部使用=号and条件
     * @param <T extend T>
     */
    int delete(T key);

    /**
     * 通过主键进行删除,这里最多只会删除一条数据
     *单个字段做主键时,可以直接写主键的值
     *联合主键时,key可以是实体类,也可以是Map
     * @param <T extend T>
     */
    int deleteByPrimaryKey(Object key);

    /**
     *根据主键进行更新,这里最多只会更新一条数据
     *参数为实体类
     * @param <T extend T>
     */
    int updateByPrimaryKey(T record);

    int updateByExample(T record,Object o);

    /**
     *根据主键进行更新
     *只会更新不是null的数据
     * @param <T extend T>
     */
    int updateByPrimaryKeySelective(T record);

    int updateByExampleSelective(T record, Object o);

    /**
     * 保存或者更新，根据传入id主键是不是null来确认
     * @param record
     * @return 影响行数
     */
    int save(T record);

    <M> int updateDelFlagToDelStatusById(Class<M> bean, Long id);

    <M> int beforeDelete(Class<M> bean, Map<String, Object> params);

    int beforeDeleteTreeStructure(Object id, String Field, Class<?>... beans);

    PageInfo<T> selectPage(int pageNum, int pageSize, T record);
    PageInfo<T> selectPage(int pageNum, int pageSize, T record, String orderStr);

}
