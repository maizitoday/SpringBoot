package com.example.demo;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author yubo
 * @version V2.0
 * @Description:   相同的属性不要去管的， 不同的属性需要明确确定映射关系
 * @date 2018/7/13 下午4:17
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Mapper
public interface PeopleMapper {

    PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    /**
     * PO转DTO
     *
     * @param entity PO
     * @return DTO
     */
    @Mapping(target = "phoneNumber", source = "callNumber")
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.age", source = "age")
    PeopleDTO entityToDTO(PeopleEntity entity);


    /**
     * DTO转PO
     *
     * @param peopleDTO DTO
     * @param entity    PO
     */
    @Mapping(target = "callNumber", source = "phoneNumber")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "age", source = "user.age")
    void updateEntityFromDto(PeopleDTO peopleDTO, @MappingTarget PeopleEntity entity);

}
