package lib;

public class TaxFunction {

	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus
	 * dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan
	 * bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan)
	 * dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena
	 * pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah
	 * sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya
	 * ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */

	// long parameter list & conditional complexity
	private static final int NON_TAXABLE_INCOME = 54000000;
	private static final int MARRIED_ADDITIONAL = 4500000;
	private static final int CHILD_ADDITIONAL = 1500000;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible,
			boolean isMarried, int numberOfChildren) {

		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 months working per year");
		}

		numberOfChildren = Math.min(numberOfChildren, 3);

		int nonTaxableIncome = NON_TAXABLE_INCOME + (isMarried ? MARRIED_ADDITIONAL : 0)
				+ (numberOfChildren * CHILD_ADDITIONAL);

		int taxableIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking - deductible - nonTaxableIncome;

		return Math.max((int) Math.round(0.05 * taxableIncome), 0);
	}

}
