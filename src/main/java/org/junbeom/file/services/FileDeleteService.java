package org.junbeom.file.services;


import lombok.RequiredArgsConstructor;
import org.junbeom.file.constants.FileStatus;
import org.junbeom.file.entities.FileInfo;
import org.junbeom.file.repositories.FileInfoRepository;
import org.junbeom.global.exceptions.UnAuthorizedException;
import org.junbeom.member.MemberUtil;
import org.junbeom.member.entities.Member;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileDeleteService {
    private final FileInfoService infoService;
    private final FileInfoRepository infoRepository;
    private final MemberUtil memberUtil;

    public FileInfo delete(Long seq) {
        FileInfo data = infoService.get(seq);
        String filepath = data.getFilePath();
        String createBy = data.getCreateBy(); // 업로드한 회원 이메일

        Member member = memberUtil.getMember();
        if (!memberUtil.isAdmin() && StringUtils.hasText(createBy) && memberUtil.isLogin() && !member.getEmail().equals(createBy)) {
            throw new UnAuthorizedException();
        }

        // 파일 삭제
        File file = new File(filepath);
        if(file.exists()) {
            file.delete();
        }

        //파일 정보 삭제
        infoRepository.delete(data);
        infoRepository.flush();

        return data;
    }

    public List<FileInfo> delete(String gid, String location, FileStatus status)
    {

    List<FileInfo> items = infoService.getList(gid, location, status);
    items.forEach(i -> delete(i.getSeq()));


    return items;
}

public List<FileInfo>delete(String gid, String location) {
        return delete(gid, location, FileStatus.ALL);
  }

  public List<FileInfo> delete(String gid) {
        return delete(gid, null);
  }
}
