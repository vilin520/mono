package com.mo.sys.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

/**
 * 图片上传的工具类
 * 
 * @author so123
 *
 */
public class UploadUtil {
	private static Logger logger = Logger.getLogger(UploadUtil.class);

	public static HashMap<String, String> upload(HttpServletRequest request) {
		HashMap<String, String> tempHashMap = new HashMap<String, String>();
		try {
			request.setCharacterEncoding("UTF-8"); // 设置编码
			// 获得磁盘文件条目工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
			factory.setSizeThreshold(1024 * 1024 * 50);
			// 高水平的API文件上传处理
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 可以上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				// 如果获取的 表单信息是普通的 文本 信息
				if (item.isFormField()) {
					String valueName = item.getFieldName();// 获取表单的属性名字
					String value = item.getString("UTF-8");
					tempHashMap.put(valueName, value);
				} else {
					// 提交的是文件
					// 获取文件后缀名
					
					String valueName = item.getFieldName();// 获取表单的属性名字
					String fileNameExtension = item.getName();
					String extention = fileNameExtension.substring(fileNameExtension.lastIndexOf("."));
					String filename = Constant.getImageAddress() /*+ extention*/;
					InputStream in = item.getInputStream();
					String filePath = save(in, filename + extention);
					tempHashMap.put(valueName, filePath);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			logger.info(e);
		} catch (Exception e) {
		}
		return tempHashMap;
	}

	public static String save(InputStream in, String filename) {
		/*	Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		*/
		//String uri = "/anmoyi/upload/" + Integer.toString(year) + "/" + Integer.toString(month) + "/"+ Integer.toString(day) + "/";// 按照年月日进行组织文件目录
		/*String uri = SysConst.SAVE_IMG_PATH+ Integer.toString(year) + "/" + Integer.toString(month) + "/"+ Integer.toString(day) + "/"*/;
		String uri = SysConst.SAVE_IMG_PATH;
		String filePath = /*uri +*/ filename.substring(0,filename.indexOf('.'));//文件名带后缀
		File file = new File(uri); 
		try {
			if (!file.exists()) {
				file.mkdirs();
			}
			File file2 = new File(uri, filename);
			if (!file2.exists()) {
				file2.createNewFile();
			}

			FileOutputStream out = new FileOutputStream(file2); // 如果追加方式用true
			byte[] b = new byte[1024];
			while ((in.read(b)) != -1) {
				out.write(b);
			}
			out.flush();
			in.close();
			out.close();
			return filePath;
		} catch (SecurityException e) {
			logger.debug("写入文件错误");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
