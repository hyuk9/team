package com.example.simpledms.service;

import com.example.simpledms.model.Free;
import com.example.simpledms.model.Profile;
import com.example.simpledms.repository.FreeRepository;
import com.example.simpledms.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : QnaService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository; // JPA CRUD 함수가 있는 인터페이스


    // 부서번호(no)로 삭제하는 함수
    public boolean removeById(int pno) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if (profileRepository.existsById(pno) == true) {
            profileRepository.deleteById(pno);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }


    public Profile createUploadImage(MultipartFile blobFile) throws IOException {

        String imageFileName = "";
        Profile profile = null;
        //            업로드 파일에서 파일명 얻기
        if (blobFile != null) {
            imageFileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

             profile = Profile.builder()
                    .imageFileName(imageFileName)
                    .blobFile(blobFile.getBytes())
                    .build();
        }else {

             profile = Profile.builder()
                    .imageFileName(imageFileName)
                    .build();

        }
        Profile createProfile = profileRepository.save(profile);
        return createProfile;
    }

    public Profile updateUploadFile(int pno,MultipartFile blobFile) throws IOException {

        //            업로드 파일에서 파일명 얻기
        String imageFileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

        Profile profile = Profile.builder()
                .pno(pno)
                .imageFileName(imageFileName)
                .blobFile(blobFile.getBytes())
                .build();

        Profile createProfile = profileRepository.save(profile);

        return createProfile;
    }

//    //    부서번호로 조회하는 함수
//    public Optional<Profile> findById(int pno) {
////        findById(기본키속성)
//        Optional<Profile> optionalProfile = profileRepository.findById(pno);
//
//        return optionalProfile;
//    }

    public Optional<Profile> findId(int pno) {

        //            findById : parameter 값 - ID, return  값 - Optional
        Optional<Profile> courseOptional = profileRepository.findById(pno);

        return courseOptional;
    }

    public Page<Profile> findAllDesc(Pageable pageable) {

        Page<Profile> profileList = profileRepository.findAllByOrderByInsertTimeDesc(pageable);

        return profileList;
    }

}









