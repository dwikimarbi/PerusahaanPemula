package perusahaan_pemula;
/***
 * 
 * @author DNABigBoss - hanunalya22@gmail.com
 *
 */
import java.util.Scanner;
public class Driver {
	public static void main(String[] args) {
		// format (id,nama depan, nama belakang, jumlah keluarga, jabatan, golongan gaji)
		KaryawanTetap u = new KaryawanTetap(001,"Ana","Nadia",31,"manager",5);
		System.out.println(u);
		
		// format (id,nama depan, nama belakang, jumlah keluarga, jabatan, golongan gaji)
		KaryawanParuhWaktu g = new KaryawanParuhWaktu(002,"Syifa","Fauziah",2,"sekretaris",3);
		System.out.println(g);
		
		Scanner input = new Scanner(System.in);
		String  namaDepan, namaBelakang, jabatan, jawaban;
		int id, keluarga, golonganGaji, waktuKerja;
		
		System.out.print("Masukan ID Karyawan : ");
        id = input.nextInt();
        System.out.print("Masukan Nama Depan Karyawan : ");
        namaDepan = input.next();
        System.out.print("Masukan Nama Belakang Karyawan : ");
        namaBelakang = input.next();
        System.out.print("Masukan Jumlah Keluarga Karyawan : ");
        keluarga = input.nextInt();
        System.out.print("Masukan Jabatan Karyawan : ");
        jabatan = input.next();
		if(jabatan.toLowerCase().equals("wakil manager") || jabatan.toLowerCase().equals("sekretaris")) {
			System.out.print("Apakah Karyawan Merupakan Karyawan Paruh Waktu ? Isikan dengan Y untuk ya dan T untuk tidak =  ");
	        jawaban = input.next();
	        if(jawaban.equals("y") || jawaban.equals("Y")) {	
	        	System.out.print("Masukan Waktu Kerja PerBulan : ");
	        	waktuKerja = input.nextInt();
	        	KaryawanParuhWaktu y = new KaryawanParuhWaktu(id,namaDepan,namaBelakang,keluarga,jabatan,waktuKerja);
	        	System.out.print("Gaji Karyawan Bulan ini = "+ y.getGajiTotal());
	        }else {
	        	System.out.print("Masukan Golongan Gaji Karyawan : ");
	            golonganGaji = input.nextInt();
	            KaryawanTetap x = new KaryawanTetap(id,namaDepan,namaBelakang,keluarga,jabatan,golonganGaji);
	            System.out.print("Gaji Karyawan Bulan ini = "+ x.getGajiTotal());
	        }
		}
		else if(jabatan.toLowerCase().equals("manager") || jabatan.toLowerCase().equals("direktur")) {
			System.out.print("Masukan Golongan Gaji Karyawan : ");
            golonganGaji = input.nextInt();
            KaryawanTetap x = new KaryawanTetap(id,namaDepan,namaBelakang,keluarga,jabatan,golonganGaji);
            System.out.print("Gaji Karyawan Bulan ini = "+ x.getGajiTotal());
		}else {
			System.out.print("Masukan Jabatan Karyawan : ");
	        jabatan = input.next();
		}
        input.close();
	}
}
