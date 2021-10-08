package perusahaan_pemula;
/***
 * 
 * @author DNABigBoss
 *
 */
public class KaryawanTetap {
	private int id;
	private String namaDepan;
	private String namaBelakang;
	private int keluarga;
	private String jabatan;
	private int golonganGaji;
	private int gaji;
	private int tunjanganJab;
	private int tunjanganKel;
	
	public KaryawanTetap() {
	}
	
	public KaryawanTetap(int id, String namaDepan, String namaBelakang, int keluarga,String jabatan, int golonganGaji) {
		this.id = id;
		this.namaDepan = namaDepan;
		this.namaBelakang = namaBelakang;
		this.keluarga = keluarga;
		this.jabatan = jabatan;
		
		//MENGHITUNG GAJI KARYAWAN TETAP
		int tentuanGajiMin = 1500; // 1500 adalah gaji minimal dalam satu bulan bekerja
		/**
		 * Golongan gaji 1 akan mendapat gaji 2000
		 * Golongan gaji 2 akan mendapat gaji 2200
		 * Golongan gaji 3 akan mendapat gaji 2500
		 * Golongan gaji 4 akan mendapat gaji 2700
		 * Golongan gaji 5 akan mendapat gaji 3000
		 */
		if (golonganGaji == 1) {
			this.gaji = tentuanGajiMin + 500; // jadi golonganGaji yang diinput oleh user akan berubah menjadi gaji karyawan tetap
		}
		else if (golonganGaji == 2) {
			this.gaji = tentuanGajiMin + 700;
		}
		else if (golonganGaji == 3) {
			this.gaji = tentuanGajiMin + 1000;
		}
		else if (golonganGaji == 4) {
			this.gaji = tentuanGajiMin + 1200;
		}
		else if (golonganGaji == 5) {
			this.gaji = tentuanGajiMin + 1500;
		}
		else {
			throw new IllegalArgumentException("Masukkan Golongan Gaji Antara 1 Sampai 5");
		}
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getNamaDepan() {
		return namaDepan;
	}
	
	public String getNamaBelakang() {
		return namaBelakang;
	}
	
	public String getNama() {
		return namaDepan +" "+ namaBelakang;
	}
	
	public int getKeluarga() {
		return keluarga;
	}
	
	public void setKeluarga(int keluarga) {
		this.keluarga = keluarga;
	}
	
	public String getJabatan() {
		return jabatan;
	}
	
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	
	public int getGajiTetap() {
		return gaji;
	}
	
	public void setGajiTetap(int gaji) {
		this.gaji = gaji;
	}
	
	public int getTunjanganJabatan() {
		/***
		 *Tunjangan Manager = 1000
		 *Tunjangan Wakil Manager = 500
		 *Tunjangan Direktur = 1500
		 *Tunjangan Sekretaris = 200
		 */
		if (jabatan.toLowerCase().equals("manager")) { //mencheck apakah sama
			this.tunjanganJab = 1000;
			return tunjanganJab;
		}
		else if (jabatan.toLowerCase().equals("wakil manager")) {
			this.tunjanganJab = 500;
			return tunjanganJab;
		}
		else if (jabatan.toLowerCase().equals("direktur")) {
			this.tunjanganJab = 1500;
			return tunjanganJab;
		}
		else if (jabatan.toLowerCase().equals("sekretaris")) {
			this.tunjanganJab = 200;
			return tunjanganJab;
		}
		else {
			throw new IllegalArgumentException("Masukkan manager / wakil manager / direktur / sekretaris"); //masukan sesuai perintah
		}
	}
	public int getGolonganGaji() {
		return golonganGaji;
	}
	
	public int getTunjanganKeluargaTetap() {
		if (keluarga > 1) { //lebih dari satu karena jika satu berarti belum berkeluarga alias jomblo
			tunjanganKel = (gaji*10/100);
			return tunjanganKel;
		}else {
			return 0;
		}
	}
	
	public int getGajiTotal() {
		return gaji+tunjanganJab+tunjanganKel;
	}
	
	public String toString() {
		return "KaryawanTetap[id="+id+",nama="+getNama()+",Jumlah Keluarga="+keluarga+",Jabatan="
	+jabatan+",Gaji="+getGajiTetap()+",Tunjangan Jabatan="+getTunjanganJabatan()+",Tunjangan Keluarga="
	+getTunjanganKeluargaTetap()+",Gaji Total="+getGajiTotal()+"]";
	}
}
