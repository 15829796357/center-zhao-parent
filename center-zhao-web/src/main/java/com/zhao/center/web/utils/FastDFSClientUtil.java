package com.zhao.center.web.utils;

/**
 * @author ZCH
 * @Description fastDFS上传文件
 * @since 2020/12/10$ 14:55$
 */

import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.dubbo.common.utils.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class FastDFSClientUtil {
    //fast dfs stroage 客户端
    @Resource
    private FastFileStorageClient fastFileStorageClient;
    //fastdfs web 服务器
    @Resource
    private FdfsWebServer fdfsWebServer;

    /**
     * 上传图⽚
     *
     * @return
     */
    public String uploadImage(MultipartFile multipartFile) throws IOException {
        String oriageinalFileName = multipartFile.getOriginalFilename()
                .substring(multipartFile.getOriginalFilename().indexOf(".") + 1);
        StorePath storePath = this.fastFileStorageClient .uploadImageAndCrtThumbImage(multipartFile.getInputStream(), multipartFile.getSize(), oriageinalFileName, null);
//        StorePath storePath1 = fastFileStorageClient.uploadFile(multipartFile.getInputStream(), multipartFile.getSize(), oriageinalFileName, null);
        return this.getResAccessUrl(storePath);
    }

    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        StorePath storePath = StorePath.parseFromUrl(fileUrl);

        this.fastFileStorageClient.deleteFile(storePath.getGroup(), storePath.getPath(
        ));
    }

    /**
     * 封装图⽚完整URL路径
     *
     * @param storePage
     * @return
     */
    private String getResAccessUrl(StorePath storePage) {
        return fdfsWebServer.getWebServerUrl() + storePage.getFullPath();
    }
}