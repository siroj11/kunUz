package org.example.kunuz.service;

import org.example.kunuz.dto.ProfileDto;
import org.example.kunuz.model.Profile;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.ProfileRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ProfileService {
    @Autowired
    ProfileRep profileRepository;

    public List<Profile> read() {
        return profileRepository.findAll();
    }

    public Result create(ProfileDto profileDto){
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setSurname(profileDto.getSurname());
        profile.setEmail(profileDto.getEmail());
        profile.setPassword(profileDto.getPassword());
        profile.setStatus(profileDto.getStatus());
        profile.setRole(profileDto.getRole());
        profile.setVisible(profileDto.getVisible());
        profile.setCreated_data(profileDto.getCreated_data());
        profile.setPhoto_id(profileDto.getPhoto_id());
        profileRepository.save(profile);
        return new Result(true,"Profile created successfully");
    }

    public Result update(ProfileDto profileDto,Integer id){
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if(optionalProfile.isPresent()){
            Profile profile = optionalProfile.get();
            profile.setName(profileDto.getName());
            profile.setSurname(profileDto.getSurname());
            profile.setEmail(profileDto.getEmail());
            profile.setPassword(profileDto.getPassword());
            profile.setStatus(profileDto.getStatus());
            profile.setRole(profileDto.getRole());
            profile.setPhoto_id(profileDto.getPhoto_id());
            profileRepository.save(profile);
            return new Result(true,"Profile updated successfully");
        }
        return new Result(false,"Profile not found");
    }

    public Result delete(Integer id){
        profileRepository.deleteById(id);
        return new Result(true,"Profile deleted successfully");
    }
}