package com.xwkj.cost.service.Impl;

import com.xwkj.cost.service.FileUploadsService;
import com.xwkj.cost.util.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description:TODO
 * @Author wanglei
 * @Create 2019-12-10 17:20
 * @Version 1.0
 */
@Service
public class FileUploadsServiceImpl implements FileUploadsService {

	@Value("${UPLOAD_FILE_PATH}")
	private String UPLOAD_FILE_PATH;
	/***
	 * @description: 多文件上传接口实现
	 * @methodName: fileUploads
	 * @param: [file]
	 * @return: java.lang.String
	 * @exception:
	 * @date: 2019-12-10 17:20
	 * @author: wanglei
	 * @param file
	 */
	@Override
	public String fileUploads(MultipartFile file) throws IOException {
		Date date = new Date();
		if (!file.isEmpty())
		{
			String fileName = DateUtil.dateToString(date, "yyyyMMddHHmmss") + UUID.randomUUID().toString().substring(0, 5);

			String fileType = file.getContentType();

			String originalFilename = file.getOriginalFilename();
			int i = originalFilename.lastIndexOf(".");
			String ext = originalFilename.substring(i + 1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String basedir = sdf.format(date);

			fileName = this.UPLOAD_FILE_PATH + "/" + fileName + "." + ext;
			File filePath = new File(this.UPLOAD_FILE_PATH);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}
			file.transferTo(new File(fileName));
			return fileName + ",";
		}
		return "";
	}
}
