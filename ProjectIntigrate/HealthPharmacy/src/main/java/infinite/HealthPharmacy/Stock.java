package infinite.HealthPharmacy;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name = "stock")
@SessionScoped
@Entity
@Table(name = "stock")
public class Stock {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "itemId")
	private int itemId;

	@Column(name = "pharmaId")
	private int pharmId;

	@Column(name = "pharmaName")
	private String pharmName;

	@Column(name = "itemName")
	private String itemName;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private double price;

	@Column(name = "mfgDate")
	private Date mfgDate;

	@Column(name = "expiryDate")
	private Date expiryDate;

	@Column(name = "vendor")
	private String vendor;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getPharmId() {
		return pharmId;
	}

	public void setPharmId(int pharmId) {
		this.pharmId = pharmId;
	}

	public String getPharmName() {
		return pharmName;
	}

	public void setPharmName(String pharmName) {
		this.pharmName = pharmName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Stock [itemId=" + itemId + ", pharmId=" + pharmId + ", pharmName=" + pharmName + ", itemName="
				+ itemName + ", quantity=" + quantity + ", price=" + price + ", mfgDate=" + mfgDate + ", expiryDate="
				+ expiryDate + ", vendor=" + vendor + "]";
	}

}
