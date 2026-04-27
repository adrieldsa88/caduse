package com.adrieldsa88.caduse.business.converter;

import com.adrieldsa88.caduse.business.dto.AddressDTO;
import com.adrieldsa88.caduse.business.dto.PhoneDTO;
import com.adrieldsa88.caduse.business.dto.UserDTO;
import com.adrieldsa88.caduse.infrastructure.entity.Address;
import com.adrieldsa88.caduse.infrastructure.entity.Phone;
import com.adrieldsa88.caduse.infrastructure.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    public User toUser(UserDTO userDTO){
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .addresses(userDTO.getAddresses() != null ?
                        toAddressList(userDTO.getAddresses()) : null)
                .phones(userDTO.getPhones() != null ?
                        toPhoneList(userDTO.getPhones()) : null)
                .build();
    }

    public List<Address> toAddressList(List<AddressDTO> addressDTOs){
        List<Address> addresses = new ArrayList<>();

        for(AddressDTO addressDTO : addressDTOs){
            addresses.add(toAddress(addressDTO));
        }

        return addresses;
    }

    public Address toAddress(AddressDTO addressDTO){
        return Address.builder()
                .street(addressDTO.getStreet())
                .number(addressDTO.getNumber())
                .city(addressDTO.getCity())
                .cep(addressDTO.getCep())
                .state(addressDTO.getState())
                .build();
    }

    public List<Phone> toPhoneList(List<PhoneDTO> phoneDTOs){
        return phoneDTOs.stream()
                .map(this::toPhone)
                .toList();
    }

    public Phone toPhone(PhoneDTO phoneDTO){
        return Phone.builder()
                .number(phoneDTO.getNumber())
                .ddd(phoneDTO.getDdd())
                .build();
    }

    public UserDTO toUserDTO(User user){
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .addresses(user.getAddresses() != null ?
                        toAddressDTOList(user.getAddresses()) : null)
                .phones(user.getPhones() != null ?
                        toPhoneDTOList(user.getPhones()) : null)
                .build();
    }

    public List<AddressDTO> toAddressDTOList(List<Address> addresses){
        List<AddressDTO> addressDTOs = new ArrayList<>();

        for(Address address : addresses){
            addressDTOs.add(toAddressDTO(address));
        }

        return addressDTOs;
    }

    public AddressDTO toAddressDTO(Address address){
        return AddressDTO.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .city(address.getCity())
                .cep(address.getCep())
                .state(address.getState())
                .build();
    }

    public List<PhoneDTO> toPhoneDTOList(List<Phone> phones){
        return phones.stream()
                .map(this::toPhoneDTO)
                .toList();
    }

    public PhoneDTO toPhoneDTO(Phone phone){
        return PhoneDTO.builder()
                .number(phone.getNumber())
                .ddd(phone.getDdd())
                .build();
    }

    public User updateUser(UserDTO userDTO, User entity){
        return User.builder()
                .id(entity.getId())
                .name(userDTO.getName() != null ?
                        userDTO.getName() : entity.getName())
                .password(userDTO.getPassword() != null ?
                        userDTO.getPassword() : entity.getPassword())
                .email(userDTO.getEmail() != null ?
                        userDTO.getEmail() : entity.getEmail())
                .addresses(entity.getAddresses())
                .phones(entity.getPhones())
                .build();
    }

    public Address updateAddress(AddressDTO dto, Address entity){
        return Address.builder()
                .id(entity.getId())
                .street(dto.getStreet() != null ?
                        dto.getStreet() : entity.getStreet())
                .number(dto.getNumber() != null ?
                        dto.getNumber() : entity.getNumber())
                .city(dto.getCity() != null ?
                        dto.getCity() : entity.getCity())
                .cep(dto.getCep() != null ?
                        dto.getCep() : entity.getCep())
                .state(dto.getState() != null ?
                        dto.getState() : entity.getState())
                .build();
    }

    public Phone updatePhone(PhoneDTO dto, Phone entity){
        return Phone.builder()
                .id(entity.getId())
                .ddd(dto.getDdd() != null ?
                        dto.getDdd() : entity.getDdd())
                .number(dto.getNumber() != null ?
                        dto.getNumber() : entity.getNumber())
                .build();
    }

    public Address toAddressEntity(AddressDTO dto, Long userId){
        return Address.builder()
                .street(dto.getStreet())
                .city(dto.getCity())
                .cep(dto.getCep())
                .state(dto.getState())
                .number(dto.getNumber())
                .build();
    }

    public Phone toPhoneEntity(PhoneDTO dto, Long userId){
        return Phone.builder()
                .number(dto.getNumber())
                .ddd(dto.getDdd())
                .build();
    }
}