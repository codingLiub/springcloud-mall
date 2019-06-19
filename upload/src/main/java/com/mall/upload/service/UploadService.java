package com.mall.upload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/25 10:14
 * @ Description：图片上传逻辑接口
 * @ Modified By：
 */

public interface UploadService {
    /**
     * 文件上传
     * @param file
     * @return
     */
    String upload(MultipartFile file);
}
