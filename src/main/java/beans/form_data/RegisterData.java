package beans.form_data;

public class RegisterData {
	private String fullname;
	private String diaChi;
	private String email;
	private String password;
	private String sdt;
	private int gioiTinh;
	private int loaiKH;
	
	public RegisterData() {}

	public RegisterData(String fullname, String diaChi, String email, String password, String sdt, int gioiTinh,
			int loaiKH) {
		super();
		this.fullname = fullname;
		this.diaChi = diaChi;
		this.email = email;
		this.password = password;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.loaiKH = loaiKH;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getLoaiKH() {
		return loaiKH;
	}
	public void setLoaiKH(int loaiKH) {
		this.loaiKH = loaiKH;
	}
	
	// source -> Generate getter and setter
}
