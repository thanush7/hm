package com.hospital.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.management.entity.HardwareAsset;
import com.hospital.management.repository.HardwareAssetRepository;

@Controller
@RequestMapping("/assets")
public class HardwareAssetController {

    @Autowired
    private HardwareAssetRepository hardwareAssetRepository;

    @GetMapping
    public String listAssets(Model model) {
        model.addAttribute("assets", hardwareAssetRepository.findAll());
        return "hardware-assets"; // View to display the list of hardware assets
    }

    @GetMapping("/add")
    public String addAssetForm(Model model) {
        model.addAttribute("asset", new HardwareAsset());
        return "add-asset"; // View to display the add asset form
    }

    @PostMapping("/save")
    public String saveAsset(@ModelAttribute("asset") HardwareAsset asset) {
        hardwareAssetRepository.save(asset);
        return "redirect:/assets"; // Redirect back to the list after saving
    }

    @GetMapping("/edit/{id}")
    public String editAssetForm(@PathVariable("id") int id, Model model) {
        hardwareAssetRepository.findById(id).ifPresentOrElse(
                asset -> model.addAttribute("asset", asset),
                () -> model.addAttribute("error", "Asset not found"));
        return "edit-asset"; // View to display the edit asset form
    }

    @PostMapping("/update")
    public String updateAsset(@ModelAttribute("asset") HardwareAsset asset) {
        hardwareAssetRepository.save(asset); // Save updated asset
        return "redirect:/assets"; // Redirect back to the list
    }

    @GetMapping("/delete/{id}")
    public String deleteAsset(@PathVariable("id") int id, Model model) {
        if (hardwareAssetRepository.existsById(id)) {
            hardwareAssetRepository.deleteById(id);
        } else {
            model.addAttribute("error", "Asset not found");
        }
        return "redirect:/assets"; // Redirect back to the list
    }
}
