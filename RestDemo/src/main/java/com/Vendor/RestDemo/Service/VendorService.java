package com.Vendor.RestDemo.Service;

import com.Vendor.RestDemo.Entity.VendorEntity;
import com.Vendor.RestDemo.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public VendorEntity getVendorById(int id) {
        return vendorRepository.findById(id).orElse(null);
    }

    public List<VendorEntity> getAllVendors() {
        return vendorRepository.findAll();
    }

    public VendorEntity addVendor(VendorEntity vendor) {
        return vendorRepository.save(vendor);
    }

    public void deleteVendor(int id) {
        vendorRepository.deleteById(id);
    }
}
