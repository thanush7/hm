package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.management.entity.HardwareAsset;

@Repository
public interface HardwareAssetRepository extends JpaRepository<HardwareAsset, Integer> {}

