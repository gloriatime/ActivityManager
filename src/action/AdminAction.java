package action;

import com.opensymphony.xwork2.ActionSupport;

import model.AdminPage;
import service.AdminService;

public class AdminAction extends ActionSupport{
	private AdminPage adminPage;
	private AdminService adminService;

	public AdminPage getAdminPage() {
		return adminPage;
	}

	public void setAdminPage(AdminPage adminPage) {
		this.adminPage = adminPage;
	}
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String showAdminPage() {
		
		adminPage = adminService.getAdminPage();
		
		return "admin_page";
	}
}
