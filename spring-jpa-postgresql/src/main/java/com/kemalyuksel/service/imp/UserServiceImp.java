package com.kemalyuksel.service.imp;

import com.kemalyuksel.dto.UserDto;
import com.kemalyuksel.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserServiceImp {

    UserDto save(UserDto userDto);
    UserDto getById(Long id);
    List<UserDto> getAll();
    Page<User> getAll(Pageable pageable);
    void deleteById(Long id);



}
