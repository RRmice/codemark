package ru.codemark.test.codemark.mappes;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.codemark.test.codemark.dto.RoleDto;
import ru.codemark.test.codemark.entities.Role;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleMapper MAPPER = Mappers.getMapper(RoleMapper.class);

    Role toRole(RoleDto roleDto);

    @InheritInverseConfiguration
    RoleDto fromRole(Role role);

    List<Role> toRoleList(List<RoleDto> roleDtos);
    List<RoleDto> fromRoleList(List<Role> roles);

}
