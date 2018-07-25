package com.example.demo;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/13 下午5:19
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class MapperTestTest {

    @Test
    public void show(){
        //PO转DTO
        PeopleEntity peopleEntity = new PeopleEntity(18, "yoyo", "13215849",
                "shanghai ", "fdhf@163.com");
        PeopleDTO peopleDTO = PeopleMapper.INSTANCE.entityToDTO(peopleEntity);
        log.info("PO转DTO peopleEntity==>" + peopleEntity.toString() + "\n peopleDTO==>" + peopleDTO.toString());

        //DTO转PO
        User user = new User(21, "jack");
        PeopleDTO newP = new PeopleDTO("000000",
                "changsha ", "jack@163.com", user);
        PeopleEntity newEntity = new PeopleEntity();
        PeopleMapper.INSTANCE.updateEntityFromDto(newP, newEntity);


        log.info("DTO转PO PeopleDTO==>" + newP.toString() + "\n peopleDTO==>" + newEntity.toString());
    }

}