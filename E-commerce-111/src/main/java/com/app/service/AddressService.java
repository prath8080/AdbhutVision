package com.app.service;

import com.app.pojo.Address;
import com.app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Address> updateAddress(Long id, Address address) {
        if (!addressRepository.existsById(id)) {
            return Optional.empty();
        }
        address.setId(id); // Ensure the ID matches the path variable ID
        return Optional.of(addressRepository.save(address));
    }

    public boolean deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            return false;
        }
        addressRepository.deleteById(id);
        return true;
    }

}
