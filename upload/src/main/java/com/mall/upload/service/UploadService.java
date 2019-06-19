package com.mall.upload.service;

import com.mall.common.enums.ExceptionEnum;
import com.mall.upload.web.UploadController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/25 10:14
 * @ Description：${description}
 * @ Modified By：
 */
@Service
public class UploadService {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    /** 支持的文件类型 */
    private static final List<String> ALLOW_TYPES = Arrays.asList("image/png", "image/jpeg");

    public String upload(MultipartFile file){
        try {
            // 1、图片信息校验
            // 1)校验文件类型
            String type = file.getContentType();
            if(!ALLOW_TYPES.contains(type)){
                logger.info("文件类型无效");
                throw new MallException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            // 2)校验图片内容
            BufferedImage image=ImageIO.read(file.getInputStream());
            if (image == null) {
                logger.info("上传失败，文件内容不符合要求");
                throw new MallException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            // 2、保存图片
            // 2.1、生成保存目录
            File dir = new File("F:\\mall\\upload");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 2.2、保存图片
            file.transferTo(new File(dir, file.getOriginalFilename()));
            // 2.3、拼接图片地址
            String url = "http://image.mall.com/upload/" + file.getOriginalFilename();

            return url;
        } catch (Exception e) {
            return null;
        }
    }
}
