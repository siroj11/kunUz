package org.example.kunuz.service;

import org.example.kunuz.dto.CategoryDto;
import org.example.kunuz.dto.RegionDto;
import org.example.kunuz.model.Category;
import org.example.kunuz.model.Region;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.CategoryRepo;
import org.example.kunuz.repository.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    RegionRepo regionRepo;
    public List<Region> read() {
        return regionRepo.findAll();
    }

    public Result create(RegionDto regionDto) {
        Region region = new Region();
        region.setCreated_date(regionDto.getCreated_date());
        region.setVisible(regionDto.getVisible());
        region.setName_uz(regionDto.getName_uz());
        region.setName_ru(regionDto.getName_ru());
        region.setName_eng(regionDto.getName_eng());
        region.setOrder_number(regionDto.getOrder_number());
        regionRepo.save(region);
        return new Result(true,"Region created successfully");
    }

    public Result update(RegionDto regionDto,Integer id){
        Optional<Region> optionalRegion = regionRepo.findById(id);
        if(optionalRegion.isPresent()){
            Region region = optionalRegion.get();
            region.setName_eng(regionDto.getName_eng());
            region.setName_uz(regionDto.getName_uz());
            region.setName_ru(regionDto.getName_ru());
            region.setOrder_number(regionDto.getOrder_number());
            region.setCreated_date(regionDto.getCreated_date());
            region.setVisible(regionDto.getVisible());
            regionRepo.save(region);
            return new Result(true,"Region updated successfully");
        }
        return new Result(false,"Region not found");
    }

    public Result delete(Integer id){
        regionRepo.deleteById(id);
        return new Result(true,"Region deleted successfully");
    }
}
