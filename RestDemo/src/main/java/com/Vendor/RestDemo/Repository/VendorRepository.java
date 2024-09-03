package com.Vendor.RestDemo.Repository;

import com.Vendor.RestDemo.Entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<VendorEntity, Integer> {
}
