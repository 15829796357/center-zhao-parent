package com.zhao.center.web.controller;

import com.zhao.center.returnUtils.CommonResult;
import com.zhao.center.web.utils.FastDFSClientUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author ZCH
 * @Description
 * @since 2020/12/10$ 14:56$
 */
@RestController
@RequestMapping("api")
public class UploadFileCOntroller {

    @Resource
    private FastDFSClientUtil fastDFSClientUtil;

    @ApiOperation(value="上传⽂件", notes="测试FastDFS⽂件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public CommonResult uploadFile (@RequestParam("file") MultipartFile file){
        String result = null;
        try{
            String path = fastDFSClientUtil.uploadImage(file) ;
            if (!StringUtils.isEmpty(path)){
                result = path ;
            } else {
                result = "上传失败" ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "服务异常";
        }
        return CommonResult.success(result);
    }

    @RequestMapping(value = "/deleteImage", method = RequestMethod.GET)
    public CommonResult downloadFile(@RequestParam("fileUrl") String fileUrl){
        String result = null;
        try{
            fastDFSClientUtil.deleteFile(fileUrl);
            result = "success" ;
        } catch (Exception e){
            e.printStackTrace() ;
            result = "服务异常" ;
        }
        return CommonResult.success(result);
    }
}
