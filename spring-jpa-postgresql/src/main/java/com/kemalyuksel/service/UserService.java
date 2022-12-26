package com.kemalyuksel.service;
import com.kemalyuksel.entity.Address;
import java.util.ArrayList;

import com.kemalyuksel.dto.UserDto;
import com.kemalyuksel.entity.User;
import com.kemalyuksel.repository.AddressRepository;
import com.kemalyuksel.repository.UserRepository;
import com.kemalyuksel.service.imp.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceImp {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {

        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());

        userRepository.save(user);
        List<Address> addressList = new ArrayList<>();

        userDto.getAddressList().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            address.setUser(user);
            addressList.add(address);
        });
        addressRepository.saveAll(addressList);
        userDto.setId(user.getId());

        return userDto;
    }

    @Override
    public UserDto getById(Long id) {

        return null;
    }

    @Override
    public List<UserDto> getAll()
    {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setSurname(user.getSurname());
            userDto.setAddressList(user.getAddressList().stream().map(Address::getAddress)
                    .collect(Collectors.toList()));
            userDtos.add(userDto);
        });

        return userDtos;
    }

    @Override
    public Page<User> getAll(Pageable pageable) {

        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
