package com.Vendor.RestDemo.Controller;

import com.Vendor.RestDemo.Entity.VendorEntity;
import com.Vendor.RestDemo.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<VendorEntity> getVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorEntity> getVendorById(@PathVariable("id") int id) {
        VendorEntity vendor = vendorService.getVendorById(id);
        if (vendor != null) {
            return ResponseEntity.ok(vendor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<VendorEntity> createVendor(@RequestBody VendorEntity vendor) {
        VendorEntity savedVendor = vendorService.addVendor(vendor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVendor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorEntity> updateVendor(@PathVariable("id") int id, @RequestBody VendorEntity vendor) {
        VendorEntity existingVendor = vendorService.getVendorById(id);
        if (existingVendor != null) {
            vendor.setId(id);
            return ResponseEntity.ok(vendorService.addVendor(vendor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable("id") int id) {
        VendorEntity existingVendor = vendorService.getVendorById(id);
        if (existingVendor != null) {
            vendorService.deleteVendor(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
