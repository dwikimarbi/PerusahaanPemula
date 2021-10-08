package perusahaan_pemula;
/***
 * 
 * @author DNABigBoss
 *
 */
public class KaryawanParuhWaktu {
	private int id;
	private String namaDepan;
	private String namaBelakang;
	private int keluarga;
	private String jabatan;
	private int waktuKerja;
	private int gaji;
	private int tunjanganJab;
	private int tunjanganKel;
	
	public KaryawanParuhWaktu() {
	}
	
	public KaryawanParuhWaktu(int id, String namaDepan, String namaBelakang, int keluarga, String jabatan, int waktuKerja) {
		this.id = id;
		this.namaDepan = namaDepan;
		this.namaBelakang = namaBelakang;
		this.keluarga = keluarga;
		this.jabatan = jabatan;
		
		//MENGHITUNG GAJI KARYAWAN PARUH WAKTU
		int tentuanGajiMin = 1500; // 1500 adalah gaji minimal dalam satu bulan bekerja
		/**
		* Karyawan Paruh Waktu Yang Bekerja Kurang dari Sama dengan 160 Jam akan mendapatkan gaji 1500
		* Karyawan Paruh Waktu Yang Bekerja selama 161 jam sampai 163 jam akan mendapatkan gaji 1700
		* Karyawan Paruh Waktu Yang Bekerja selama 164 jam sampai 166 jam akan mendapatkan gaji 1800
		* Karyawan Paruh Waktu Yang Bekerja selama 167 jam sampai 169 jam akan mendapatkan gaji 1900
		* Karyawan Paruh Waktu Yang Bekerja selama 167 jam sampai 169 jam akan mendapatkan gaji 2000
		*/
		if (waktuKerja <= 160) {     //160 adalah jam maksimal dalam satu bulan bekerja
			this.gaji = tentuanGajiMin; // jadi waktuKerja yang diinput oleh user akan berubah menjadi gaji karyawan paruh waktu
		}
		else if (waktuKerja >= 161 && waktuKerja <= 163) { // 163 adalah jam maksimal + 1-3 jam, 1 jam yaitu lembur minimal per bulan 
			this.gaji = tentuanGajiMin + 200;
		}
		else if (waktuKerja >= 164 && waktuKerja <= 166) { // 166 adalah jam maksimal + 4-6 jam lembur
			this.gaji = tentuanGajiMin + 300;
		}
		else if (waktuKerja >= 167 && waktuKerja <= 169) { // 169 adalah jam maksimal + 7-9 jam lembur
			this.gaji = tentuanGajiMin + 400;
		}
		else if (waktuKerja >= 170 && waktuKerja <= 172) { // 172 adalah jam maksimal + 10-12 jam lembur, 12 jam adalah jam lembur maksimal 
			this.gaji = tentuanGajiMin + 500;
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
		return namaDepan + namaBelakang;
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
	
	public int getGajiParuhWaktu() {
		return gaji;
	}
	
	public void setGajiParuhWaktu(int gaji) {
		this.gaji = gaji;
	}
	
	public int getTunjanganJabatan() {
		/***
		 *Tunjangan Wakil Manager = 500
		 *Tunjangan Sekretaris = 200
		 */
		if (jabatan.toLowerCase().equals("wakil manager")) {
			this.tunjanganJab = 500;
			return tunjanganJab;
		}
		else if (jabatan.toLowerCase().equals("sekretaris")) {
			this.tunjanganJab = 200;
			return tunjanganJab;
		}
		else {
			throw new IllegalArgumentException("wakil manager / sekretaris"); //masukan sesuai perintah
		}
	}
	
	// Menghitung Tunjangan Keluarga Paruh Waktu
	public int getTunjanganKeluargaParuhWaktu() {
		if (keluarga > 1) { //lebih dari satu karena jika satu berarti belum berkeluarga alias jomblo
			tunjanganKel = (gaji*10/100);
			return tunjanganKel;
		}else {
			return 0;
		}
	}
	
	public int getWaktuKerja() {
		return waktuKerja;
	}
	
	public int getGajiTotal() {
		return gaji+tunjanganJab+tunjanganKel;
	}
	public String toString() {
		return "KaryawanParuhWaktu[id="+id+",nama="+namaDepan+" "+ namaBelakang+",Jumlah Keluarga="+keluarga+",Gaji="
	+getGajiParuhWaktu()+",Tunjangan Jabatan="+getTunjanganJabatan()+",Tunjangan Keluarga="
	+getTunjanganKeluargaParuhWaktu()+",Gaji Total="+getGajiTotal()+"]";
	}
}
