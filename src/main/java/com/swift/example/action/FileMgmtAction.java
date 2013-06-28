package com.swift.example.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.model.FileMgmt;
import com.swift.example.service.FileMgmtService;

public class FileMgmtAction extends ActionSupport implements ModelDriven<FileMgmt> {

	private static final long serialVersionUID = 6240811845390875062L;
	private static final Logger log = Logger.getLogger(FileMgmtAction.class.getName());
	private static final String PATH = "/Users/swift/Desktop/";
	
	@Inject("fileMgmt")
	private FileMgmtService fileMgmtService;
	private FileMgmt fileMgmt = new FileMgmt();
	private List<FileMgmt> fileList = new ArrayList<FileMgmt>();
	private File userImage;
	private String userImageContentType;
    private String userImageFileName;
    
	public String addFile() {
		log.info("Inside Add File...");
		try {
            log.info("Server path:" + PATH);
            File fileToCreate = new File(PATH, this.userImageFileName);
            FileUtils.copyFile(this.userImage, fileToCreate);
            fileMgmt.setImageFile(userImageFileName);
            fileMgmt.setContentImageType(userImageContentType);
            fileMgmt.setFilePath(PATH + this.userImageFileName);
            fileMgmt.setCreatedOn(new Date());
            fileMgmtService.addFile(fileMgmt);
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String listFile() {
		log.info("Inside List File...");
		log.info("Size: " + fileMgmtService.listFiles().size());
		fileList = fileMgmtService.listFiles();
		return SUCCESS;
	}
	
	public String removeFile() {
		log.info("Inside Remove File...");
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		long id = Long.parseLong(request.getParameter("id"));
		FileMgmt fileMgmt = fileMgmtService.getFileById(id);
		File fileToDelete = new File(fileMgmt.getFilePath());
		if(fileToDelete.delete()) {
			fileMgmtService.removeFile(id);
			log.info("File Deleted Successfully....");
		} else {
			log.info("Error while deleting....");
		}
		return SUCCESS;
	}

	@Override
	public FileMgmt getModel() {
		return fileMgmt;
	}
	
	public FileMgmt getFileMgmt() {
		return fileMgmt;
	}

	public void setFileMgmt(FileMgmt fileMgmt) {
		this.fileMgmt = fileMgmt;
	}

	public List<FileMgmt> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileMgmt> fileList) {
		this.fileList = fileList;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}
}
