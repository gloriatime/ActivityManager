package service.imp;

import dao.AdminPageDao;
import model.AdminPage;
import service.AdminService;

public class AdminServiceImp implements AdminService {

	private AdminPageDao adminPageDao;
	
	@Override
	public AdminPage getAdminPage() {
		// TODO Auto-generated method stub
		return adminPageDao.getAdminPage();

	}

	public AdminPageDao getAdminPageDao() {
		return adminPageDao;
	}

	public void setAdminPageDao(AdminPageDao adminPageDao) {
		this.adminPageDao = adminPageDao;
	}

}
