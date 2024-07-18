package org.crawler.shopping;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.crawler.shopping.goods.dao.entity.Good;
import org.crawler.shopping.goods.dao.repo.GoodRepository;

import java.math.BigDecimal;

@SpringBootTest
public class GoodTest {
    @Test
    void simpleTest(){
        System.out.println("simpleTest");
    }

    @Resource
    GoodRepository goodRepository;
    @Test
    void testSimpleSelect(){
        goodRepository.findById(1L);
        goodRepository.findByNameAndDescription("leo","test");
        goodRepository.findBySalesAndDiscountAndRecommend(1,2.0,true);
        goodRepository.findGoodByName("CPU",12000,1L);
        goodRepository.findGoodByNativeSQL(1L,"CPU");
    }

    @Test
    void testInsert(){
        Good good = new Good();
        good.setImgs("/file/74488020672944968462e9e4a9c89096.png");
        good.setName("衬衫");
        good.setDiscount(0.95);
        good.setPrice(new BigDecimal(100.34));
        good.setDescription("高级衬衫");
        good.setRecommend(true);
        good.setSales(2);
        good.setIsDelete(false);
        good.setSaleMoney(new BigDecimal(92.00));
        good.setCategoryId(1L);

        goodRepository.save(good);
    }

    @Test
    void testInsertUpdate(){
        Good good = new Good();
        good.setImgs("/file/74488020672944968462e9e4a9c89096.png");
        good.setName("衬衫2");
        good.setDiscount(0.95);
        good.setPrice(new BigDecimal(100.34));
        good.setDescription("高级衬衫");
        good.setRecommend(true);
        good.setSales(2);
        good.setIsDelete(false);
        good.setSaleMoney(new BigDecimal(92.00));
        good.setCategoryId(1L);
        good.setId(1L);
        goodRepository.save(good);
    }

    @Test
    void testUpdateNoSave(){
        goodRepository.updateNameById("CPU",2L);
    }

    @Test
    void testDelete(){
        Good good = new Good();
        good.setId(1L);
        goodRepository.delete(good);
        goodRepository.deleteById(2L);
    }
}
