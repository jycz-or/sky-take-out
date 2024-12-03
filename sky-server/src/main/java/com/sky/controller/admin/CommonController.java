package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import jdk.jpackage.internal.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.management.ObjectName;
import java.io.IOException;
import java.util.UUID;

/**
 * 通用接口
 */
@Slf4j
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
public class CommonController {

    private final AliOssUtil aliOssUtil;
    private final HttpMessageConverters messageConverters;


    public CommonController(AliOssUtil aliOssUtil, HttpMessageConverters messageConverters) {
        this.aliOssUtil = aliOssUtil;
        this.messageConverters = messageConverters;
    }

/*
    private final MinioUtill minioUtill;

    public CommonController(MinioUtill minioUtill) {
         this.minioUtill = minioUtill;
    }*/


    /**
     * 文件上传
     * @param file
     * @return
     */
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){
        log.info("文件上传:{}",file);

        try {
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取原始文件名的后缀png
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //拼接文件名
            String objectName = UUID.randomUUID().toString() + extension;
            //文件的请求路径
            String filePath = aliOssUtil.upload(file.getBytes(), objectName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("文件上传失败:{}",e);
        }

        /*try {
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取原始文件名的后缀png
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //拼接文件名
            String objectName = UUID.randomUUID().toString() + extension;
            //文件的请求路径
            String filePath = minioUtill.upload(file.getBytes(), objectName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("文件上传失败:{}",e);
        }*/
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
