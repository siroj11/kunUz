package org.example.kunuz.controller;

import org.example.kunuz.dto.ProfileDto;
import org.example.kunuz.model.Profile;
import org.example.kunuz.model.Result;
import org.example.kunuz.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProfileCont {
    @Autowired
    ProfileService profileService;

    @GetMapping("/profile")
    public List<Profile> findAll() {
        return profileService.read();
    }

    @PostMapping("/profile")
    public Result add(@RequestBody ProfileDto profileDto) {
        return profileService.create(profileDto);
    }

    @PutMapping("/profile/{id}")
    public Result update(@RequestBody ProfileDto profileDto,@PathVariable Integer id) {
        return profileService.update(profileDto,id);
    }

    @DeleteMapping("/profile/{id}")
    public Result delete(@PathVariable Integer id) {
        return profileService.delete(id);
    }
}