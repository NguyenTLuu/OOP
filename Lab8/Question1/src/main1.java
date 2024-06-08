public class main1 {
    public static void main(String[] args) {
        CompanyInfo companyInfo = CompanyInfo.getInstance();

        companyInfo.displayInfo();

        companyInfo.setCompanyName("EIU - Dai hoc Quoc te Mien dong");
        companyInfo.setAddress("3M38+6F3, Nam Kỳ Khởi Nghĩa, Định Hoà, Thủ Dầu Một, Bình Dương");
        companyInfo.setPhoneNumber("0274 2220 341");

        companyInfo.displayInfo();
    }
}
