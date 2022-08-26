package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.mapper.BannerMapper;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService{

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public boolean add(BannerInput bannerInput) {
        Banner b = Banner.builder()
                .name(bannerInput.getName())
                .filePath(bannerInput.getFilePath())
                .linkPath(bannerInput.getLinkPath())
                .openMethod(bannerInput.getOpenMethod())
                .orderNumber(bannerInput.getOrderNumber())
                .createdAt(LocalDateTime.now())
                .isPublic(bannerInput.getIsPublic().equals("true"))
                .build();

        bannerRepository.save(b);
        return true;
    }

    @Override
    public boolean update(BannerInput bannerInput) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<BannerDto> list(BannerParam bannerParam) {
        long totalCount = bannerMapper.selectListCount(bannerParam);
        List<BannerDto> list = bannerMapper.selectList(bannerParam);
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - bannerParam.getPageStart() - i);
                i++;
            }
        }

        return list;
    }
}