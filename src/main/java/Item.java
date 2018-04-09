import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Item {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pid")
	private int id;
	@Column(name="pname")
	private String name;
	private String psize;
	private long price;
	private String pcolor;
	private String plength;
	private String ptype;
	private String pstatus;
	private String description;
	private Date date;
	private String stock;
	@Column(name="suitable_for")
	private String suit;
	@Column(length=1000000 )
   private byte[] pimage;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsize() {
		return psize;
	}
	public void setPsize(String psize) {
		this.psize = psize;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getPcolor() {
		return pcolor;
	}
	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}
	public String getPlength() {
		return plength;
	}
	public void setPlength(String plength) {
		this.plength = plength;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public byte[] getPimage() {
		return pimage;
	}
	public void setPimage(byte[] bFile) {
		
	        this.pimage=bFile;
	}
	
	


}