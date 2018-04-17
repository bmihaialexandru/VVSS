package controller;

import model.Product;
import repository.StoreRepository;

import java.io.IOException;
import java.util.ArrayList;

public class StoreController { 
	StoreRepository io =new StoreRepository();	
	public void readProducts(String f){
		try {
			io.readFile(f);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String addProduct(Product p){
		try {

			return io.addNewProduct(p);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return "error";
	}
	public ArrayList<Product> getProductsCategory(String cat){
		return io.getProductsCategory(cat);
	}
	
	public ArrayList<Product> stockSituationProduct(String pname){
		return io.stockSituationProduct(pname);
	}
	public ArrayList<Product> stockSituation(){
		return io.stockSituation();
	}
}
