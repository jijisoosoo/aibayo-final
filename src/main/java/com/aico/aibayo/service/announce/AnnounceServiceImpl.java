package com.aico.aibayo.service.announce;


import com.aico.aibayo.dto.announce.AnnounceDto;
import com.aico.aibayo.repository.announce.AnnounceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor

public class AnnounceServiceImpl implements AnnounceService{
    private final AnnounceRepository announceRepository;


    @Override
    public AnnounceDto getByAnnounceNo(Long announceNo) {
        return announceRepository.findBy;
    }
}
