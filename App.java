import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    static int HitungBukuTeknik = 0;
    static int HitungBukuManajemen = 0;
    static int HitungBukuFiksi = 0;
    static int HitungBukuLainnya = 0;
    static int HitungBukuLawas = 0;
    static int HitungBukuBaru = 0;

    public static void main(String[] args) throws Exception {
        ArrayList<VariabelDataBuku> ListBuku = new ArrayList<VariabelDataBuku>();
        int menu = 1;

        do {
            showMenu();
            BufferedReader inputan = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Pilih Menu (1, 2, atau 3): ");
            menu = Integer.parseInt(inputan.readLine());

            if (menu == 1) {
                System.out.print("Judul: ");
                String judul = inputan.readLine().toString();
                System.out.print("Pengarang: ");
                String pengarang = inputan.readLine().toString();
                System.out.print("Penerbit: ");
                String penerbit = inputan.readLine().toString();
                Kategori();
                System.out.print("Kategori: ");
                int kategori = Integer.parseInt(inputan.readLine());
                System.out.print("Tahun: ");
                int tahun = Integer.parseInt(inputan.readLine());

                ListBuku.add(new VariabelDataBuku(judul, pengarang, penerbit, kategori, tahun));

                HitungKategori(kategori);

                if (tahun <= 2000) {
                    HitungBukuLawas++;
                } else {
                    HitungBukuBaru++;
                }

            } else if (menu == 2) {
                MenampilkanDataBuku(ListBuku);
            }

        } while (menu != 3);
    }

    public static void showMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Tambah Data Buku");
        System.out.println("2. Tampilkan Data Buku");
        System.out.println("3. Exit");
        System.out.println();
    }

    public static void Kategori() {
        System.out.println();
        System.out.println("=== Pilih Kategori ===");
        System.out.println("1. Teknik");
        System.out.println("2. Manajemen");
        System.out.println("3. Fiksi");
        System.out.println("4. Lainnya");
    }

    public static void MenampilkanDataBuku(ArrayList<VariabelDataBuku> booklist) {
        System.out.println("====================================================================");
        System.out.println("No\t\tJudul\t\tPengarang\t\tPenerbit\t\tTahun\t\tKategori");
        System.out.println("====================================================================");
        int No = 0;
        for (VariabelDataBuku TabelBuku : booklist) {
            String Indeks = App.KategoriBuku(TabelBuku.Kategori);
            System.out.println(++No + "\t\t" + TabelBuku.Judul + "\t\t" + TabelBuku.Pengarang + "\t\t"
                    + TabelBuku.Penerbit + "\t\t" + TabelBuku.Tahun + "\t\t" + Indeks);
        }
        System.out.println("===================================================================");
        System.out.println("Jumlah buku yang tersedia: " + No);
        System.out.println("Buku Teknik: " + HitungBukuTeknik);
        System.out.println("Buku Manajemen: " + HitungBukuManajemen);
        System.out.println("Buku Fiksi: " + HitungBukuFiksi);
        System.out.println("Buku Lainnya: " + HitungBukuLainnya);
        System.out.println("Buku Lawas: " + HitungBukuLawas);
        System.out.println("Buku Baru: " + HitungBukuBaru);
    }

    public static String KategoriBuku(int Kategori) {
        String index;
        if (Kategori == 1) {
            index = "Teknik";
        } else if (Kategori == 2) {
            index = "Manajemen";
        } else if (Kategori == 3) {
            index = "Fiksi";
        } else {
            index = "Lainnya";
        }
        return index;
    }

    public static void HitungKategori(int kategori) {
        if (kategori == 1) {
            HitungBukuTeknik++;
        } else if (kategori == 2) {
            HitungBukuManajemen++;
        } else if (kategori == 3) {
            HitungBukuFiksi++;
        } else {
            HitungBukuLainnya++;
        }
    }
}