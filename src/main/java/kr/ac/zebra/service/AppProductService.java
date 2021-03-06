package kr.ac.zebra.service;

import java.util.List;

import kr.ac.zebra.dao.AppApplyDAO;
import kr.ac.zebra.dao.AppProductDAO;
import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppProductService {

	private AppProductDAO appProductDAO;
	private AppApplyDAO appApplyDAO;
	
	@Autowired
	public void setDAO(AppProductDAO appProductDAO, AppApplyDAO appApplyDAO){
		this.appProductDAO = appProductDAO;
		this.appApplyDAO = appApplyDAO;
	}
	
	public List<Product> getProductByCategory(String category){
		return appProductDAO.getProductByCategory(category);
	}
	
	public List<Product> getProductBySearch(String keyword){
		return appProductDAO.getProductBySearch(keyword);
	}
	
	public Product getProductByBarcode(String barcode){
		return appProductDAO.getProductByBarcode(barcode);
	}
	
	public boolean isExist(String barcode){
		return appProductDAO.isExist(barcode);
	}
	
	public boolean insertProduct(String email, String barcode, String productName, String companyName){
		return appApplyDAO.insertProduct(email, barcode, productName, companyName);
	}
	
	public AppApply getApply(String barcode){   
	    AppApply apply = appApplyDAO.getApply(barcode);
	    if (apply == null) {
	      return null;
	    }
	    return apply;
	}

	public void scanCounting(String barcode){
		appProductDAO.scanCounting(barcode);
	}
}